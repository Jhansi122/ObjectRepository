package Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReaderTest 
{
	Properties pro;
   public ConfigReaderTest()
   
   {
	try 
	{
		File src = new File("C:\\Program Files\\Selenium\\Spring tool suite\\Code\\ObjectRepository.Selenium\\src\\main\\resources\\Configurations\\Configuration.properties\\");
		FileInputStream fis = new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	} 
   catch (Exception e) 
   {
	   e.printStackTrace();
		System.out.println("Exception is " +e.getMessage());
	}
	
 }
   public String getPath()
   {
	   String path = pro.getProperty("ChromeDriver");
	   
	   return path;
   }
   
   public String getURL()
   {
	   String URL = pro.getProperty("URL");
	   return URL;
   }
}
