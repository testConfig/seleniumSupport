package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class getScreenShot {

public void screenshot() {
	WebDriver Driver = null;
	File xFile  = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyDirectory(xFile, xFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
}
