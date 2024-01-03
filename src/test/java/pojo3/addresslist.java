package pojo3;

import java.util.ArrayList;

public class addresslist {
	
	public static ArrayList addresslist() {
		
		address address = new address();
		address.setHno("200");
		address.setRoad("2");
		ArrayList list = new ArrayList();
		list.add(address);
		return list;
		
		
	}

}
