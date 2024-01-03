package pojofiles;

import java.util.ArrayList;

public class addressalist {
	
	public static ArrayList addressarraylist() {
		
		
		

		address address = new address();
		address.setArea(arealist.arealist1());
		address.setHno("20");
		address address2 = new address();
		address2.setArea(arealist.arealist2());
		address2.setHno("201");
		
		ArrayList<address> addressList = new ArrayList<>();
		addressList.add(address);
		addressList.add(address2);
		
		return addressList;
		
	}
	
}
