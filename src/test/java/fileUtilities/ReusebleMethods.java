/**
 * 
 */
package fileUtilities;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

/**
 * @author MANISH
 *
 */
public class ReusebleMethods {

	
	public static JsonPath rawToJson(Response res)
	{
		String responseString=res.asString();
		JsonPath js= new JsonPath(responseString);
		return js;	
	}
	
	public static XmlPath rawToXml(Response res)
	{
		String responseString=res.asString();
		XmlPath x= new XmlPath(responseString);
		return x;	
	}
	
	
	
	
	
	
	
}
