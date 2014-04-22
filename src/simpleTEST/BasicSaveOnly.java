package simpleTEST;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BasicSaveOnly {
	
	private static ArrayList<String> startState = new ArrayList<String>();	
	private static String path = "BasicTest.ser";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		startState.add("One");
		startState.add("Two");
		startState.add("Three");
		startState.add("Four");
		startState.add("Five");
		startState.add("Six");
		
		SaveState();
		//LoadState();
		System.out.println("Start Test");
		
		
	}
	private static void SaveState () throws FileNotFoundException, IOException {
		
		ObjectOutputStream scribe = new ObjectOutputStream (new FileOutputStream(path));
		scribe.writeObject(startState);
		scribe.close();
	}
		

}
