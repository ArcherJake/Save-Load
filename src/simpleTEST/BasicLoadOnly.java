package simpleTEST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.ClassObject;
import models.Datamodel;
import models.Relationship;

public class BasicLoadOnly {
	
	private static ArrayList<ClassObject> classObjectList = new ArrayList<ClassObject>();
	private static ArrayList<Relationship> relationList = new ArrayList<Relationship>();
	private static ArrayList<ClassObject> classObjectList2 = new ArrayList<ClassObject>();
	@SuppressWarnings("unused")
	private static ArrayList<Relationship> relationList2 = new ArrayList<Relationship>();
	private static Datamodel state;
	private static String path = "UML.ser";

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		// create two test Classobjects
		ClassObject target1 = new ClassObject("There", 10, 10, 0);
		target1.addOperation("1-Oper2", 0);
		target1.addOperation("1-Oper3", 0);
		target1.addOperation("1-Oper4", 0);
		target1.addAttribute("1-Atrib1", 0);
		target1.addAttribute("1-Atrib2", 0);
		target1.addAttribute("1-Atrib3", 0);
		target1.addAttribute("1-LongAtrib", 0);

		ClassObject target2 = new ClassObject("Here", 20, 20, 0);
		target2.addOperation("2-Oper2", 0);
		target2.addOperation("2-Oper3", 0);
		target2.addOperation("2-Oper4", 0);
		target2.addAttribute("2-Atrib1", 0);
		target2.addAttribute("2-Atrib2", 0);
		target2.addAttribute("2-Atrib3", 0);
		target2.addAttribute("2-LongAtrib", 0);

		// create a test relationship
		Relationship line = new Relationship(target1, target2, 1);

		relationList.add(line);

		classObjectList.add(target1);
		classObjectList.add(target2);
		
		//SaveState();
		System.out.println("Attempting Load:");
		LoadState();
		System.out.println("Start Test");
		for (int i = 0; i < classObjectList.size(); i++){
			
			System.out.println(classObjectList.get(i).getName() + " vs " + classObjectList2.get(i).getName());
		}
		
	}	
	
	/*@SuppressWarnings("unchecked")
	private static void LoadState () throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream scribe = new ObjectInputStream(new FileInputStream(path));
		endState = (ArrayList<String>) scribe.readObject();
		scribe.close();
		
		
	}*/
	
	private static void LoadState() throws FileNotFoundException, IOException, ClassNotFoundException {
		state = new Datamodel(classObjectList2, relationList2);
		ObjectInputStream scribe = new ObjectInputStream(
				new FileInputStream(path));

		// variables for classObjects list
		ClassObject target;
		int sizeof = scribe.readInt();
		for (int i = 0; i < sizeof; i++) {
			target = (ClassObject) scribe.readObject();
			
			classObjectList2.add(target);		}

		
		
		scribe.close();
	}

}
