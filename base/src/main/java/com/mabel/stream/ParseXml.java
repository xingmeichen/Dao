package com.mabel.stream;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-07-08 00:33
 **/
public class ParseXml {

    public static void main(String[] args) {
        try {
            String path = "/Users/mabelchen/Documents/order-sub.xml";
            Document doc = loadDocument(path);
            NodeList nodes = doc.getElementsByTagName("Message");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element orderElement = (Element) nodes.item(i);
                NodeList orders = orderElement.getElementsByTagName("Order");
                int length = orders.getLength();
                for (int j = 0; j < orders.getLength(); j++) {
                    Element orderItemElement = (Element) orders.item(j);
                    Node firstChild = orderElement.getFirstChild();
                    String nodeValue = firstChild.getNodeValue();
                    String orderId = orderElement.getAttribute("AmazonOrderID");
                    System.out.println(nodeValue);
                    System.out.println(orderId);
                    NodeList orderItems = orderItemElement.getElementsByTagName("OrderItem");
                    for (int k = 0; k < orderItems.getLength(); k++) {
                        Element orderItem = (Element) orderItems.item(k);
                        String orderItemId = orderItem.getAttribute("AmazonOrderItemCode");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static Document loadDocument(String path) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//实例化DocumentBuilderFactory对象
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(path);
        if (file.exists()) {
            return builder.parse(file);
        } else {
            return null;
        }
    }
}