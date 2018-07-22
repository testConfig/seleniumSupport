package screenShot;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class getDataBaseConnection {
	static	Properties property;
		public static void loadproperty() {
			property = new Properties();
			File xfile = new File(System.getProperty("user.dir")+"//All_Property//Excel.Properties");
			
			try {
				FileReader xRead = new FileReader(xfile);
				property.load(xRead);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		public static void main(String[] args)
		{
			loadproperty();
			String xdata = property.getProperty("SecondData");
			System.out.println(xdata);
		}
}
