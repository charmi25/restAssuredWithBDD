package serializeDeSerialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

 class Test implements Serializable 
 // if we do not implement it throws error 
 //Exception in thread "main" java.io.NotSerializableException: serializeDeSerialize.SerializationAndDeserialization

 {
	int i=10;
	int j=20;
}

public class SerializationAndDeserialization {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		Test t1 = new Test();
		
		
		//Serialization : obj to file
		FileOutputStream fos = new FileOutputStream("test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(t1);  // converts obj into file
		
		
		//DeSerialize : File  test.txt to Object
		
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
	Test t2 = (Test)	ois .readObject();  // file to object and stores in variable of type Test class
	System.out.println(t2.i);
	System.out.println(t2.j);
		
	}
}
