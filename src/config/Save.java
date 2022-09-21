package config;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Save {
    public static boolean enabled;
    public static String fileName;
    public static String fileFormat;

    public static void save() {
        try {
            File fXmlFile = new File("shop.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList2 = doc.getElementsByTagName("save");

            for (int temp = 0; temp < nList2.getLength(); temp++) {
                Node nNode = nList2.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    enabled = Boolean.parseBoolean(eElement.getElementsByTagName("enabled")
                            .item(0).getTextContent());
                    fileName = eElement.getElementsByTagName("fileName")
                            .item(0).getTextContent();
                    fileFormat = eElement.getElementsByTagName("format")
                            .item(0).getTextContent();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getFileName() {
        return fileName;
    }

    public static String getFileFormat() {
        return fileFormat;
    }

    public static boolean isEnabled() {
        return enabled;
    }
}