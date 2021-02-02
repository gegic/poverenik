package com.xml.team18.sluzbenik.exist;

import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;
import org.exist.xmldb.EXistResource;
import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XUpdateQueryService;

import javax.xml.transform.OutputKeys;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExistManager {

    private final static String TARGET_NAMESPACE = "";

    public static final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + ">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
            + "</xu:modifications>";
    public static final String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + ">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
            + "</xu:modifications>";

    private final ExistProperties existProperties;

    @Autowired
    public ExistManager(ExistProperties existProperties) {
        this.existProperties = existProperties;
    }

    public void createConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, XMLDBException {
        Class<?> cl = Class.forName(existProperties.getDriver());
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);
    }

    public Collection getOrCreateCollection(String collectionId, int pathOffset) throws XMLDBException {
        Collection col = DatabaseManager.getCollection(existProperties.getUri() + collectionId, existProperties.getUser(), existProperties.getPassword());
        if (col == null) {
            if (collectionId.startsWith("/")) {
                collectionId = collectionId.substring(1);
            }
            String[] pathSegments = collectionId.split("/");
            if (pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();
                for (int i = 0; i <= pathOffset; i++) {
                    path.append("/").append(pathSegments[i]);
                }
                Collection startCol = DatabaseManager.getCollection(existProperties.getUri() + path,
                        existProperties.getUser(), existProperties.getPassword());
                if (startCol == null) {
                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(existProperties.getUri() + parentPath,
                            existProperties.getUser(), existProperties.getPassword());
                    CollectionManagementService service = (CollectionManagementService) parentCol
                            .getService("CollectionManagementService", "1.0");
                    col = service.createCollection(pathSegments[pathOffset]);
                    col.close();
                    parentCol.close();
                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(collectionId, ++pathOffset);
        } else {
            return col;
        }
    }

    public void saveFile(String collectionId, String documentId, String filePath) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            return;
        }
        this.save(collectionId, documentId, f);
    }

    public boolean containsCollection(String collectionId) throws Exception {
        this.createConnection();
        try (Collection col = DatabaseManager.getCollection(existProperties.getUri() + collectionId,
                existProperties.getUser(),
                existProperties.getPassword())) {
            return col != null;
        }
    }

    public void saveRaw(String collectionId, String documentId, String xmlString) throws Exception {
        this.save(collectionId, documentId, xmlString);
    }

    private void save(String collectionId, String documentId, Object obj) throws Exception {
        createConnection();
        XMLResource res = null;
        try (Collection col = getOrCreateCollection(collectionId, 0)) {
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
            res.setContent(obj);
            col.storeResource(res);
        } finally {
            if (res != null) {
                ((EXistResource) res).freeResources();
            }
        }
    }

    public void deleteById(String collectionId, String documentId) throws Exception {
        createConnection();
        Resource r = null;
        try (Collection col = getOrCreateCollection(collectionId, 0)) {
            r = col.getResource(documentId);
            col.removeResource(r);
        } finally {
            if (r != null) {
                ((EXistResource) r).freeResources();
            }
        }
    }

    public void delete(String collectionId, Resource r) throws Exception {
        createConnection();
        try (Collection col = getOrCreateCollection(collectionId, 0)) {
            col.removeResource(r);
        } finally {
            ((EXistResource) r).freeResources();
        }
    }
    public XMLResource read(String collectionId, String documentId) throws ResourceNotFoundException {
        try (Collection col = DatabaseManager.getCollection(existProperties.getUri() + collectionId,
                existProperties.getUser(), existProperties.getPassword())) {
            createConnection();
            col.setProperty(OutputKeys.INDENT, "yes");
            return (XMLResource) col.getResource(documentId);
        } catch (XMLDBException e) {
            throw new ResourceNotFoundException(collectionId, documentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> readAll(String collectionId) throws Exception {
        createConnection();
        try (Collection col = DatabaseManager.getCollection(existProperties.getUri() + collectionId,
                existProperties.getUser(), existProperties.getPassword())) {
            col.setProperty(OutputKeys.INDENT, "yes");
            return Arrays.stream(col.listResources()).map(resId -> {
                try {
                    return col.getResource(resId).getContent().toString();
                } catch (XMLDBException e) {
                    e.printStackTrace();
                    return null;
                }
            }).collect(Collectors.toList());
        }
    }

    public ResourceSet query(String collectionUri, String xpathExp) throws Exception {
        createConnection();
        ResourceSet result;
        try (Collection col = DatabaseManager.getCollection(existProperties.getUri() + collectionUri,
                existProperties.getUser(), existProperties.getPassword())) {
            XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xpathService.setProperty("indent", "yes");
            xpathService.setNamespace("", TARGET_NAMESPACE);
            result = xpathService.query(xpathExp);
        }
        return result;
    }

    public void update(int template, String collectionUri, String document, String contextXPath, String patch)
            throws Exception {
        createConnection();
        String chosenTemplate;
        switch (template) {
            case 0: {
                chosenTemplate = UPDATE;
                break;
            }
            case 1: {
                chosenTemplate = APPEND;
                break;
            }
            default: {
                return;
            }
        }
        try (Collection col = DatabaseManager.getCollection(existProperties.getUri() + collectionUri,
                existProperties.getUser(), existProperties.getPassword())) {
            XUpdateQueryService service = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            service.setProperty("indent", "yes");
            service.updateResource(document, String.format(chosenTemplate, contextXPath, patch));
        }
    }
}