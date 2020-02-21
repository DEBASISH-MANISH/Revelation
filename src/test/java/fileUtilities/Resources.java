/**
 * 
 */
package fileUtilities;

import org.testng.Reporter;

/**
 * @author MANISH
 *
 */
public class Resources {

	public static String addPlacePostResourceJsonData()
	{
		String reqAddData="/maps/api/place/add/json";
		Reporter.log("Json Resource Attached For Add Place....", true);
		return reqAddData;
	}
	
	public static String deletePlacePostResourceJsonData()
	{
		String reqDeleteData="/maps/api/place/delete/json";
		Reporter.log(" Json Resource Attached For Delete Place....", true);
		return reqDeleteData;
	}
	public static String addPlacePostResourceXMLData()
	{
		String reqAddData="/maps/api/place/add/xml";
		Reporter.log("XML Resource Attached For Add Place....", true);
		return reqAddData;
	}
	
	public static String deletePlacePostResourceXMLData()
	{
		String reqDeleteData="/maps/api/place/delete/xml";
		Reporter.log("XML Resource Attached For Delete Place....", true);
		return reqDeleteData;
	}
	
	public static String addBooksPostResourceJsonData()
	{
		String reqAddData="/Library/Addbook.php";
		Reporter.log(" Json Resource Attached For Add Book....", true);
		return reqAddData;
	}
	public static String deleteBooksPostResourceJsonData()
	{
		String reqDeleteData="/Library/DeleteBook.php";
		Reporter.log(" Json Resource Attached For Delete Book....", true);
		return reqDeleteData;
	}
}
