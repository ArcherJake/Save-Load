package simpleTEST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BasicSaveLoad {
	
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
		
		SaveState();
		LoadState();
		
		for (int i = 0; i < startState.size(); i++){
			System.out.println("Start Test");
			System.out.println(startState.get(i) + " vs " + endState.get(i));
		}
		
	}
	private static void SaveState () throws FileNotFoundException, IOException {
		
		ObjectOutputStream scribe = new ObjectOutputStream (new FileOutputStream(path));
		scribe.writeObject(startState);
		scribe.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void LoadState () throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream scribe = new ObjectInputStream(new FileInputStream(path));
		endState = (ArrayList<String>) scribe.readObject();
		scribe.close();
		
		
	}
}
