package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadFirstXML {
	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir")+"//XMLFolder//firstXML.xml";
		try {
		File xFile = new File(path);
		DocumentBuilderFactory DBS = DocumentBuilderFactory.newInstance();
			DocumentBuilder DB = DBS.newDocumentBuilder();
			Document D = DB.parse(xFile);
			D.getDocumentElement().normalize();
			NodeList nList = D.getElementsByTagName("Student");
			for(int n=0;n<nList.getLength();n++) {
				Node nNode =nList.item(n);
				System.out.println("Node Name: "+nNode.getNodeName());
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement =(Element) nNode;
					System.out.println("Roll Number: "+eElement.getAttribute("id"));
					System.out.println("Name : "+eElement.getElementsByTagName("Name").item(0).getTextContent());
					System.out.println("Home : "+eElement.getElementsByTagName("home").item(0).getTextContent());
					System.out.println("Subject : "+eElement.getElementsByTagName("Sub").item(0).getTextContent()+"\n");
				}
				
			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
