package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Datamodel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1736941983536755231L;
	//serial Version UID needed for compatability checking
	
	private static ArrayList<ClassObject> classObjectList;
	private static ArrayList<Relationship> relationList;
	private static String projectName;
	
	
	public Datamodel (ArrayList<ClassObject> cObjectList, ArrayList<Relationship> relList){
		
		classObjectList = cObjectList;
		relationList = relList;
				
	}
	
	public void cleardata(){
		classObjectList.clear();
		relationList.clear();
			}
	public static ArrayList<ClassObject> getClassList () {
		
		return classObjectList;
		
	}
	public static ArrayList<Relationship> getRelationList () {
		return relationList;
	}
	
	
}

