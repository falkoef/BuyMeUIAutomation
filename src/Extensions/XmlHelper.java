package Extensions;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlHelper {
    private static File configXmlFile = new File("C:\\Users\\Falko\\Desktop\\BuyMeUIAutomation\\config.xml");

    //Will return data by keyName
    public static String getData(String keyName) throws ParserConfigurationException, IOException, org.xml.sax.SAXException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
