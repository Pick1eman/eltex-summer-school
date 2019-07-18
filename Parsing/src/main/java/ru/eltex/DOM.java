package ru.eltex;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class DOM
{
    private static ArrayList<String> msgs = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("resources/temp.xml"));
        NodeList msgElements = document.getDocumentElement().getElementsByTagName("msg");
        for (int i = 0; i < msgElements.getLength(); i++)
        {
            Node msg = msgElements.item(i);
            NamedNodeMap attributes = msg.getAttributes();
            //msgs.add(new msg(attributes.getNamedItem("to").getNodeValue(),attributes.getNamedItem("from").getNodeValue(),attributes.getNamedItem("title").getNodeValue()));
            System.out.println(attributes.getNamedItem("to").getNodeValue() + " " + attributes.getNamedItem("from").getNodeValue() + " " + attributes.getNamedItem("title").getNodeValue());
            System.out.println("Text: " + msg.getTextContent());
        }
        /*for (String msg : msgs)
        {
            System.out.println(msg);
        }*/
    }
}