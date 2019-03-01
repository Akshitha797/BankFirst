package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import model.User;

public class Deserialization {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		try {
			
			FileInputStream fileInputStream=new FileInputStream("F:\\JavaPrograms\\User.txt");
			ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
			
			ArrayList<User> userList=(ArrayList<User>)objectInputStream.readObject();
					
			User user=new User();
			user=userList.get(6);
			System.out.println(user.getFirstName());	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
