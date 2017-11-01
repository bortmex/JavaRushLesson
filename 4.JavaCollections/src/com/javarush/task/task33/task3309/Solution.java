package com.javarush.task.task33.task3309;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        Document document = (Document) obj;
        doSomething(document.getDocumentElement());
        return null;
    }

    public static void doSomething(Node node) {
        // do something with the current node instead of System.out
        System.out.println(node.getNodeName());

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                //calls this method for all the children which is Element
                doSomething(currentNode);
            }
        }
    }

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException {
        System.out.println(toXmlWithComment(test(),"<second>", "it’s a comment"));
    }
    public static Document test() throws ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element first = document.createElement("first");
        document.appendChild(first);

 /*       Comment comment = document.createComment("it's a comment");
        first.appendChild(comment);*/

        Element second = document.createElement("second");
        second.setTextContent("some string");
        first.appendChild(second);
        Element second2 = document.createElement("second");
        second2.setTextContent("some string");
        first.appendChild(second2);

        Element second3 = document.createElement("second");
        first.appendChild(second3);

        CDATASection cdata = document.createCDATASection("need CDATA because of < and >");
        second3.appendChild(cdata);

        Element second4 = document.createElement("second");
        first.appendChild(second4);

        String result = XmlUtil.toXML(XmlUtil.fromXML(XmlUtil.toXML(document)));
        System.out.println(result);
        System.out.println();
        System.out.println();
        System.out.println();

        return XmlUtil.fromXML(XmlUtil.toXML(document));
    }
}
