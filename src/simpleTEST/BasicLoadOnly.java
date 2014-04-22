package simpleTEST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BasicLoadOnly {
	
	private static ArrayList<String> startState = new ArrayList<String>();
	private static ArrayList<String> endState = new ArrayList<String>();
	private static String path = "BasicTest.ser";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		startState.add("One");
		startState.add("Two");
		startState.add("Three");
		startState.add("Four");
		startState.add("Five");
		startState.add("Six");
		
		//SaveState();
		LoadState();
		System.out.println("Start Test");
		for (int i = 0; i < startState.size(); i++){
			
			System.out.println(startState.get(i) + " vs " + endState.get(i));
		}
		
	}	
	
	@SuppressWarnings("unchecked")
	private static void LoadState () throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream scribe = new ObjectInputStream(new FileInputStream(path));
		endState = (ArrayList<String>) scribe.readObject();
		scribe.close();
		
		
	}

}
