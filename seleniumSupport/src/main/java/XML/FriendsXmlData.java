package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class FriendsXmlData {

	public static void main(String[] args) {
		try {
		String Path = System.getProperty("user.dir")+"\\XMLFolder\\Friends.xml";
		File xFile = new File(Path);
		DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
	
			DocumentBuilder DB = DBF.newDocumentBuilder();
			Document D =DB.parse(xFile);
			D.getDocumentElement().normalize();
			System.out.println("Element Name: "+D.getDocumentElement().getNodeName());
			System.out.println("----------------------");
			NodeList nList =D.getElementsByTagName("Best_Friend");
			
			for(int i=0; i<nList.getLength();i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent Element :"+node.getNodeName());
				
				if(node.getNodeType() ==Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("ID: "+element.getAttribute("id"));
					System.out.println("Name: "+element.getElementsByTagName("Name").item(0).getTextContent());
					System.out.println("Home: "+element.getElementsByTagName("Home").item(0).getTextContent());
					System.out.println("Occupation: "+element.getElementsByTagName("Occ").item(0).getTextContent());
				}
				
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
