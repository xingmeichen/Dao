package com.dao.base.file;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-07-08 00:33
 **/
public class ParseXml {

    /***
     * @return DocumentBuilder
     */
    public static DocumentBuilder createDocumentBuilder() throws Exception {
        //实例化DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder();
    }

    /***
     * load a file as a document
     * @param path
     * path example: System.getProperty("user.dir") + "/base/src/main/resources/file/example.xml"
     * @return
     * @throws Exception
     */
    public static Document loadDocument(String path) throws Exception {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            // file doesn't exist or file exists but is a directory
            return null;
        }
        DocumentBuilder documentBuilder = createDocumentBuilder();
        return documentBuilder.parse(file);
    }

    public static Document loadDocument(File file) throws Exception {
        if (!file.exists() || !file.isFile()) {
            // file doesn't exist or file exists but is a directory
            return null;
        }
        DocumentBuilder documentBuilder = createDocumentBuilder();
        return documentBuilder.parse(file);
    }

    /***
     * load a file as a document
     * @param document
     * @return
     */
    public static String getTopTag(Document document) {
        if (null == document) {
            return StringUtils.EMPTY;
        }
        Element element = document.getDocumentElement();
        if (null == element) {
            return StringUtils.EMPTY;
        }
        return element.getTagName();
    }

    /***
     * get a target node's all child nodes
     * @param targetNode
     * @return
     */
    public static List<NodeList> findChildNodes(NodeList nodes, String targetNode) {
        if (null == nodes || nodes.getLength() <= 0) {
            return new ArrayList<>();
        }
        List<NodeList> list = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            if (item.getNodeName().equals(targetNode)) {
                list.add(item.getChildNodes());
                continue;
            } else {
                List<NodeList> childNodes = findChildNodes(item.getChildNodes(), targetNode);
                if (CollectionUtils.isNotEmpty(childNodes)) {
                    list.addAll(childNodes);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) throws Exception {
        Document document = loadDocument(System.getProperty("user.dir") + "/base/src/main/resources/file/example.xml");
        String topTag = getTopTag(document);
        NodeList nodes = document.getElementsByTagName(topTag);
        List<NodeList> foods = findChildNodes(nodes, "food");
        if (null == foods || foods.size() <= 0) {
            return;
        }
        for (int j = 0; j < foods.size(); j++) {
            System.out.println("food " + (j + 1) + ": ");
            NodeList food = foods.get(j);
            for (int i = 0; i < food.getLength(); i++) {
                Node item = food.item(i);
                System.out.println(item.getNodeName() + ": " + item.getTextContent());
            }
            System.out.println();
        }
    }
}