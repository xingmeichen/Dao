package com.dao.util;

import com.dao.util.domain.Library;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;

/**
 * @project: dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-07
 **/
@Slf4j
public class SoapUtil {

    public static Document readDocument(InputStream inputStream) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            return documentBuilder.parse(inputStream);
        } catch (Exception e) {
            log.error("Read document error", e);
        }
        return null;
    }

    public XMLStreamReader xmlStreamReader(String input) {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
        try {
            return factory.createXMLStreamReader(IOUtils.toInputStream(input, Charset.defaultCharset()));
        } catch (XMLStreamException e) {
            log.error("Parse to XML Stream Reader error", e);
        }
        return null;
    }

    public static String transformNodeToString(Node node) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(node), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            log.error("Transform Node to String error", e);
        }
        return null;
    }

    public static void main(String[] args) {
        InputStream resource = SoapUtil.class.getClassLoader().getResourceAsStream("files/soap.xml");
        Document document = readDocument(resource);
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<Library> jaxbElement = unmarshaller.unmarshal(document, Library.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}