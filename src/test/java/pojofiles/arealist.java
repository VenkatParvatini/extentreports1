package pojofiles;

import java.util.ArrayList;

public class arealist {
	static area area1;
	static area area2;
	
	public static ArrayList arealist1() {
		area2 = new area();
		area2.setHno1("400");
		area2.setHno2("401");
		 area1 = new area();
		area1.setHno1("200");
		area1.setHno2("201");
		
		ArrayList<area> arealist = new ArrayList<>();
		arealist.add(area1);
		arealist.add(area2);
		
		
		return arealist;
		
	}
	public static ArrayList arealist2() {
		ArrayList<area> arealist2 = new ArrayList<>();
		arealist2.add(area2);
		return arealist2;
	}

}
