package com.xml.team18.poverenik.onstartup;

import com.xml.team18.poverenik.exist.ExistManager;
import com.xml.team18.poverenik.jaxb.JaxB;
import com.xml.team18.poverenik.service.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

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
//            save("/db/zahtevi",
//                    this.existManager,
//                    "data/zahtev.xml",
//                    this.zahtevService,
//                    Zahtev.class,
//                    ZahtevFactory.class);
            save("/db/zalbecutanje",
                    this.existManager,
                    "data/zalbacutanje.xml",
                    this.zalbaCutanjeService);
            save("/db/zalbenaodluku",
                    this.existManager,
                    "data/zalbanaodluku.xml",
                    this.zalbaNaOdlukuService);
            save("/db/resenja",
                    this.existManager,
                    "data/resenje.xml",
                    this.resenjeService);
        } catch (Exception ignored) { // as it's not that important
            System.err.println("Ignored exception");
        }
    }

    private <T> void save(String collectionId,
                             ExistManager existManager,
                             String dataPath,
                             PoverenikService<T> service) throws Exception {
        if(!existManager.containsCollection(collectionId)) {
            String rawXml = IOUtils.toString(new ClassPathResource(dataPath).getInputStream(), StandardCharsets.UTF_8);
            service.save(rawXml);
        }
    }
}
