package saveload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import models.Attribute;
import models.ClassObject;
import models.Datamodel;
import models.Operation;
import models.Relationship;

public class LoadOnly {

	/**
	 * @param args
	 */

	private static ArrayList<ClassObject> classObjectList = new ArrayList<ClassObject>();
	private static ArrayList<Relationship> relationList = new ArrayList<Relationship>();
	private static ArrayList<ClassObject> classObjectList2 = new ArrayList<ClassObject>();
	@SuppressWarnings("unused")
	private static ArrayList<Relationship> relationList2 = new ArrayList<Relationship>();
	private static Datamodel state;

	public static void main(String[] args) throws FileNotFoundException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub//create two test Classobjects
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
		System.out.println("size of list before save/load is : "
				+ classObjectList.size());

		// try to pass them in and out of the loader
		System.out.println("First Save Load attempt:");

		LoadState();
		if (classObjectList.size() == classObjectList2.size()) {
			System.out.println("Both Classes equal size: "
					+ classObjectList.size());
			loadTest();

		} else {
			System.out
					.println("Size of loaded ArrayList does not match."
							+ classObjectList.size() + " vs "
							+ classObjectList2.size());
		}

	}

	private static void loadTest() {

		// Information matching tests
		ClassObject cL1, cL2;
		ArrayList<Attribute> attributeList1, attributeList2;
		ArrayList<Operation> operationList1, operationList2;
		String name1, name2;
		for (int i = 0; i < classObjectList.size(); i++) {
			cL1 = classObjectList.get(i);
			cL2 = classObjectList2.get(i);
			name1 = cL1.getName();
			name2 = cL2.getName();
			attributeList1 = cL1.getAttributes();
			attributeList2 = cL2.getAttributes();
			operationList1 = cL1.getOperations();
			operationList2 = cL2.getOperations();
			System.out.println(name1 + " vs " + name2);

			for (int j = 0; j < attributeList1.size(); j++) {
				Attribute Acheck1 = attributeList1.get(j);
				Attribute Acheck2 = attributeList2.get(j);
				System.out.println(Acheck1.getAttributeName() + " vs "
						+ Acheck2.getAttributeName());

			}

			for (int j = 0; j < attributeList1.size(); j++) {
				Operation Ocheck1 = operationList1.get(j);
				Operation Ocheck2 = operationList2.get(j);
				System.out.println(Ocheck1.getOperationName() + " vs "
						+ Ocheck2.getOperationName());

			}
		}

	}

	private static void LoadState() throws FileNotFoundException, IOException,
			ClassNotFoundException {

		ObjectInputStream scribe = new ObjectInputStream(new FileInputStream(
				"UML.ser"));
		state = (Datamodel) scribe.readObject();
		scribe.close();

		classObjectList2 = state.getClassList();
		relationList2 = state.getRelationList();

	}

}
