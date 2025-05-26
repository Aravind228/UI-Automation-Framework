package TestData;

import java.util.LinkedHashMap;

public class HashMapData {
	
	public static String[] GetMapdata(String input) {
	
	LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
	map.put("RIce items", "Raw Rice,: Boiled Rice");
	map.put("Sugar", "White sugar,:BrownSugar");
	map.put("Dal", "moong dal,:Turad dal");
	String key = null;
	try {
		key=map.get(input);
	}
	catch(Exception e) {
		System.out.println("No such a element is present in the map "+e.getMessage());
	}
	String[] s2=key.split(":");
	
	return s2;
	}
	
	
}
