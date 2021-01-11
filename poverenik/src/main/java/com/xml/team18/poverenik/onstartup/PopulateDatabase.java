package com.xml.team18.poverenik.onstartup;

import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.factory.ResenjeFactory;
import com.xml.team18.poverenik.factory.ZahtevFactory;
import com.xml.team18.poverenik.factory.ZalbaCutanjeFactory;
import com.xml.team18.poverenik.factory.ZalbaNaOdlukuFactory;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import com.xml.team18.poverenik.repository.*;
import com.xml.team18.poverenik.service.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class PopulateDatabase {
    private final ZahtevService zahtevService;
    private final ZalbaCutanjeService zalbaCutanjeService;
    private final ZalbaNaOdlukuService zalbaNaOdlukuService;
//    private final ObavestenjeService obavestenjeService;
    private final ResenjeService resenjeService;
    private final ExistManager existManager;
    private final JaxB jaxB;

    @Autowired
    public PopulateDatabase(ZahtevService zahtevService,
                            ExistManager existManager,
                            ZalbaCutanjeService zalbaCutanjeService,
                            ZalbaNaOdlukuService zalbaNaOdlukuService,
                            /*ObavestenjeService obavestenjeService,*/
                            ResenjeService resenjeService,
                            JaxB jaxB) {
        this.zahtevService = zahtevService;
        this.zalbaCutanjeService = zalbaCutanjeService;
        this.zalbaNaOdlukuService = zalbaNaOdlukuService;
//        this.obavestenjeService = obavestenjeService;
        this.resenjeService = resenjeService;
        this.existManager = existManager;
        this.jaxB = jaxB;
    }

    @PostConstruct
    public void init() {
        try {
//            save("/db/zahtevi", this.existManager, "data/zahtev.xml", this.zahtevRepository);
//            save("/db/obavestenja", this.existManager, "data/obavestenje.xml", this.obavestenjeRepository);
            save("/db/zahtevi",
                    this.existManager,
                    "data/zahtev.xml",
                    this.zahtevService,
                    Zahtev.class,
                    ZahtevFactory.class);
            save("/db/zalbecutanje",
                    this.existManager,
                    "data/zalbacutanje.xml",
                    this.zalbaCutanjeService,
                    com.xml.team18.poverenik.model.zalba.cutanje.Zalba.class,
                    ZalbaCutanjeFactory.class);
            save("/db/zalbenaodluku",
                    this.existManager,
                    "data/zalbanaodluku.xml",
                    this.zalbaNaOdlukuService,
                    com.xml.team18.poverenik.model.zalba.na.odluku.Zalba.class,
                    ZalbaNaOdlukuFactory.class);
            save("/db/resenja",
                    this.existManager,
                    "data/resenje.xml",
                    this.resenjeService,
                    Resenje.class,
                    ResenjeFactory.class);
        } catch (Exception ignored) { // as it's not that important
            System.err.println("Ignored exception");
        }
    }

    private <T> void save(String collectionId,
                             ExistManager existManager,
                             String dataPath,
                             PoverenikService<T> service,
                             Class<T> clazz,
                             Class<?> factoryClazz) throws Exception {
        if(!existManager.containsCollection(collectionId)) {
            String rawXml = IOUtils.toString(new ClassPathResource(dataPath).getInputStream(), StandardCharsets.UTF_8);
            T o = (T) ((JAXBElement<?>) this.jaxB.unmarshall(rawXml, clazz, factoryClazz)).getValue();
            service.save(o);
        }
    }
}
