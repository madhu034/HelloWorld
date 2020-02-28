package com.learnwithmosh;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sailpoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 System.out.println(" Hello world");
 
   Sailpoint test = new Sailpoint();
	test.listOperation();
	
	Sailpoint test2 = new Sailpoint();
	
	 test2.mapOperations();
	}
 public void listOperation() {
	 
	 List<String> list1 = new ArrayList<String>();
	  
	 list1.add("E1");
	 list1.add("E2");
	 list1.add("E3");
	 System.out.println("List is :"+ list1.get(2));
	 
	 
//	 for (String list2 : list1) {
//		 
//		 System.out.println("Content of list is " + list1));
	// }
 }
public void mapOperations() {
	 Map map1 = new HashMap();
	 map1.put("userName", "Madhu Gyawali");
	 map1.put("Dept", "IT");
	 map1.put("Email", "madhu.gyawali@gmail.com");
	 map1.put("Dept", "HR");
	 //System.out.println(" My map content is :" + map1);
	//System.out.println(" Value against key Dept is :" + map1.get("Dept"));
	 
	 Set<String> set = new HashSet();
	 
	 set = map1.keySet();
	 System.out.println("Keys of the maps are :"  + set);
	 
	 
	 for(String key : set) {
     System.out.println("Value against key " + key + " is " + map1.get(key));
		 
		 
	 }
 }
}
