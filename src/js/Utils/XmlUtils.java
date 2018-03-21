package js.Utils;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XmlUtils {

	public static String fileloc = "src/BookInfo.xml";
	
	public static Document getDocument () throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(fileloc);
		return document;
		
	}
	
	public static void writeToDocument (Document document) throws Exception {
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tfer = tffactory.newTransformer();
		tfer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(fileloc)));
		
	}
}
