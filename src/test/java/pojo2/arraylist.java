package pojo2;

import java.util.ArrayList;

public class arraylist {
	
	public static ArrayList addresslist() {
		address addr = new address();
		addr.setHno("20");
		
		ArrayList list = new ArrayList();
		list.add(addr);
		
		return list;
	}

}
