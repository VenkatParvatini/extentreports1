package preheaderconfig;

import java.util.HashMap;
import java.util.Map;

public class headers {

	
	public Map<String,String> basicheaders() {
		Map<String,String> basicheaders = new HashMap<String,String>();
		basicheaders.put("Content-Type", "application/json");
		return basicheaders;
	}
	
	public Map<String,String> headerswithapiversion() {
		Map<String,String> basicheaders = new HashMap<String,String>();
		basicheaders.put("Content-Type", "application/json");
		basicheaders.put("X_API_VERSION", "1.0");
		return basicheaders;
	}
}
