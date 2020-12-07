package com.xml.team18.poverenik.jaxb;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class JaxB {

    public Object unmarshall(String text, Class<?> clazz, Class<?> factoryClazz)
            throws JAXBException {
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
        return sw.toString();
    }
}
