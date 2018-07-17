package test.seleniumSupport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	WebDriver Driver;
	
	private void getScreenShot(File destFile) {
		
		File xShot = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(xShot, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
