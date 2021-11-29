package parser.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class JSONMainBasic {

	public static void main(String[] args) throws FileNotFoundException {
		JSON<Map<String, Object>, List<Object>> jsonParser = 
				new JSON<Map<String, Object>, List<Object>>(new FileInputStream("sample.json"));
		Handler<Map<String, Object>, List<Object>> handler = new BasicHandler();
		try {
			Object result = jsonParser.parse(handler);
			System.out.println("Parsing successfully Ends.");
			System.out.println("result="+result);
		}
		catch(ParseException e){
			System.out.println("***Encountered errors during parse.");
			e.printStackTrace();
		}
	}

}
