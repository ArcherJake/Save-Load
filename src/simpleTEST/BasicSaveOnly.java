package simpleTEST;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.ClassObject;
import models.Datamodel;
import models.Relationship;

public class BasicSaveOnly {

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

		SaveState();
		// LoadState();
		System.out.println("Save run");

	}

	private static void SaveState() throws FileNotFoundException, IOException {
		state = new Datamodel(classObjectList, relationList);
		ObjectOutputStream scribe = new ObjectOutputStream(
				new FileOutputStream(path));

		// variables for classObjects list
		ClassObject target;
		/*
		 * String classname; int id, xpos, ypos, width, height;
		 * ArrayList<Attribute> aList; ArrayList<Operation> oList;
		 */

		int sizeof = classObjectList.size();
		scribe.writeInt(sizeof);
		for (int i = 0; i < sizeof; i++) {
			target = classObjectList.get(i);
			/*
			 * classname = target.getName(); id = target.getId(); xpos =
			 * target.getxPos(); ypos = target.getyPos(); width =
			 * target.getWidth(); height = target.getHeight();
			 */
			scribe.writeObject(target);
		}

		// variables for relationships list
		/*Relationship target2;
		sizeof = relationList.size();
		scribe.writeInt(sizeof);
		for (int i = 0; i < sizeof; i++) {
			target2 = relationList.get(i);
			scribe.writeObject(target2);
		}*/
		scribe.close();
	}

}
