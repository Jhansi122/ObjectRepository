package Screenshot;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityTest 
{
	public static void Utility(WebDriver driver, String Screenshot) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/" + Screenshot + ".png"));

		} 
		catch (Exception e) 
		{

			e.printStackTrace();
		}

	}
}
