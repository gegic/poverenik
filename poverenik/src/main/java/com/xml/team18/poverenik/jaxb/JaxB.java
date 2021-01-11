package com.xml.team18.poverenik.jaxb;

import org.apache.commons.io.output.XmlStreamWriter;
import org.jdom.Element;
import org.springframework.stereotype.Component;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.*;
import javax.xml.transform.dom.DOMResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class JaxB {

    public Object unmarshall(String text, Class<?> clazz, Class<?> factoryClazz)
            throws JAXBException {
        Pattern p = Pattern.compile("xmlns:((?!xsi).{1,6})=");
        Matcher m = p.matcher(text);
        if (m.find()) {
            text = m.replaceAll("rdfa_$1=");
        }
        JAXBContext context = JAXBContext.newInstance(clazz, factoryClazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(new StringReader(text));
    }

    public String marshall(Object toMarshall, Class<?> clazz, Class<?> factoryClazz)
            throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz, factoryClazz);
        Marshaller marshaller = context.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.marshal(toMarshall, sw);
        Pattern p = Pattern.compile("rdfa_(.{1,6})=");
        Matcher m = p.matcher(sw.toString());
        String marshalled = null;
        if (m.find()) {
            marshalled = m.replaceAll("xmlns:$1=");
        }
        return marshalled;
    }
}
