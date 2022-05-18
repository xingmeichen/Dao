package com.mabel;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-05-18
 **/
public class XmlUtil {

    /***
     * get all the child nodes of the same level nodes
     * @param nodeList
     * @return
     */
    public static List<Map<String, NodeList>> parseNode(NodeList nodeList) {
        List<Map<String, NodeList>> list = new ArrayList<>();
        if (null == nodeList || nodeList.getLength() <= 0) {
            return list;
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (null == node.getChildNodes()) {
                continue;
            }
            Map<String, NodeList> map = new HashMap<String, NodeList>() {
                {
                    put(node.getNodeName(), node.getChildNodes());
                }
            };
            list.add(map);
        }
        return list;
    }

    /***
     * get all the attributes of one node
     * @param node
     * @return
     */
    public static Map<String, String> parseAttribute(Node node) {
        Map<String, String> attrMap = new HashMap<>();
        NamedNodeMap attributes;
        if (null == node || null == (attributes = node.getAttributes())) {
            return attrMap;
        }
        for (int i = 0; i < attributes.getLength(); i++) {
            Node item = attributes.item(i);
            attrMap.put(item.getNodeName(), item.getNodeValue());
        }
        return attrMap;
    }
}