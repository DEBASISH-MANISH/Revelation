/**
 * 
 */
package fileUtilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Reporter;

/**
 * @author MANISH
 *
 */
public class PayLoad {
	
	
	
	public static String getAddPlacePostBodyData()
	{
		String requestBody= "{"+

   "\"location\":{"+

        "\"lat\" : -38.383494,"+

       " \"lng\" : 33.427362"+

    "},"+

    "\"accuracy\":50,"+

    "\"name\":\"Frontline house\","+

    "\"phone_number\":\"(+91) 983 893 3937\","+

    "\"address\" : \"29, side layout, cohen 09\","+

    "\"types\": [\"shoe park\",\"shop\"],"+

    "\"website\" : \"http://google.com\","+

    "\"language\" : \"French-IN\""+

"}";
		Reporter.log("Request Body Attached For Add Place....", true);
		return requestBody;
	}
	
	public static String addBook(String isbnData, String aisleData)
	{
		//String payLoad="{\r\n\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\"pooja\",\r\n\"aisle\":\"612\",\r\n\"author\":\"John foe\"\r\n}";
		String payLoad="{\r\n\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\""+isbnData+"\",\r\n\"aisle\":\""+aisleData+"\",\r\n\"author\":\"John foe\"\r\n}";
		Reporter.log("Request Body Attached For Add Book....", true);
		return payLoad;
	}
	
	public static String deleteBookPostBodyData(String bookId)
	{
		String reqBody= "{\r\n \r\n\"ID\" : \""+bookId+"\"\r\n \r\n} \r\n";
		Reporter.log("Request Body Attached For Delete Book....", true);
		return reqBody;
	}
	
	public static String getDeletePlacePostBodyData(String placeid)
	{
		String reqBody= "{"+
			    "\"place_id\":\""+placeid+"\"" +          
			    "}";
		Reporter.log("Request Body Attached For Delete Place....", true);
		return reqBody;
	}
	
	//***** Store XML/Json data in .xml/.json extension and pass the full path inside below method and it will take xml/json data as byte and convert it to string data format.
	public static String generateStringFromResource(String path) throws IOException
	{
		Reporter.log("Converted Raw Data to String Data And Request Body Attached For Add Place....", true);
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
