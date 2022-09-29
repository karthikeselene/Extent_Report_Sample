package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericProperties {

	public static byte[] screenshot(RemoteWebDriver driver) {
		File src = driver.getScreenshotAs(OutputType.FILE);	
		byte[] img = null;
		try {			
			img = FileUtils.readFileToByteArray(src);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return img;
	}	

}