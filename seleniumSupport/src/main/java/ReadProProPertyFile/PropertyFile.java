package ReadProProPertyFile;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertyFile {
	
static	String readpropertyFile(String propName) {
		String value = null;
		String xPath =System.getProperty("user.dir")+"//All_Property//Excel.Properties";
		File xfile = new File(xPath);
		FileReader xRead;
		try {
			xRead = new FileReader(xfile);
			Properties property = new Properties();
			property.load(xRead);
			 value = property.getProperty(propName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
public static void main(String[] args) {
	System.out.println(PropertyFile.readpropertyFile("firstData"));
}

}
