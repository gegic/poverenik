/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.xml.team18.poverenik.soap.izvestaj;

import com.xml.team18.poverenik.model.izvestaj.Izvestaj;
import com.xml.team18.poverenik.repository.IzvestajRepository;
import com.xml.team18.poverenik.soap.izvestaj.IzvestajServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.logging.Logger;

/**
 * This class was by Apache CXF 3.2.1
 * 2021-02-01T23:10:18.287+01:00
 * source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "IzvestajService",
                      portName = "IzvestajServiceSoapBinding",
                      wsdlLocation = "src/main/resources/wsdl/izvestaj.wsdl",
                      endpointInterface = "com.xml.team18.poverenik.soap.izvestaj.IzvestajServicePortType")
@Service
public class IzvestajServiceSoapBindingImpl implements IzvestajServicePortType {

    private IzvestajRepository izvestajRepository;

    private static final Logger LOG = Logger.getLogger(IzvestajServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see cxf.IzvestajServicePortType#neodgovoreniIzvestaji(java.lang.String email)*
     */


    @Autowired
    public void setIzvestajRepository(IzvestajRepository izvestajRepository) {
        this.izvestajRepository = izvestajRepository;
    }

    @Override
    public boolean podnesiIzvestaj(Izvestaj izvestaj) {
        LOG.info("Executing operation podnesiIzvestaj");
        this.izvestajRepository.save(izvestaj);
        return true;
    }
}
