/**
 * 
 */
package commonLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;



/**
 * @author MANISH
 *
 */
public class SuperTestScript {
	
	public static Properties prop ;
	
	@BeforeTest
	public void getData() throws Exception
	{
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\MANISH\\workspaceNeon\\LearnRestAssuredAutomation\\src\\test\\java\\fileUtilities\\env.properties");
		prop.load(fis);
		//prop.getProperty("HOST");
		//prop.getProperty("KEY");
	}
	
	

}
