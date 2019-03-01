
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class Validation {
	
	 public static User getInfo(Long aadhar)
	 {
		 Scanner s=new Scanner(System.in);		 
		 User user=new User();
		 System.out.println("Enter User details :");
		
		 System.out.println("Enter First Name :");
		 user.setFirstName(s.next());
		 System.out.println("Enter Last Name :");
		 user.setLastName(s.next());
		// System.out.println("Enter Aadhar Card Number :");
		 user.setAadharCardNo(aadhar);
		 System.out.println("Enter Account Number :");
		 user.setAccountNo(s.nextLong());
		 System.out.println("Enter Account type :");
		 user.setAccountType(s.next());
		 System.out.println("Enter Pan Card Number :");
		 user.setPanCardNo(s.nextLong());
		 System.out.println("Enter Phone Number :");
		 user.setPanCardNo(s.nextLong());
		 System.out.println("Enter Address :");
		 user.setAddress(s.next());
		 
		 
		 return user;	 
	 }


	public static void main(String[] args) {

				Scanner s=new Scanner(System.in);
				try {
					
					System.out.println("Enter User's Aadhar card number : ");
					long aadhar=s.nextLong();
					
					FileInputStream fileInputStream=new FileInputStream("F:\\JavaPrograms\\User.txt");
					ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
					
					ArrayList<User> userList=(ArrayList<User>)objectInputStream.readObject();
					objectInputStream.close();
							
					User user=new User();
					int count1=0;
					
					for(int i=0;i<userList.size();i++)
					{
						user=userList.get(i);
						if(aadhar==user.getAadharCardNo())
						{
							count1++;
							break;
						}
					}
					
					if(count1==1)
						System.out.println("User already exists");
					else
					{	
							userList.add(getInfo(aadhar));
							
							FileOutputStream fileOutputStream=new FileOutputStream("F:\\JavaPrograms\\User.txt");
							ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
							objectOutputStream.writeObject(userList);
							objectOutputStream.close();
			
					
					}
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		
	}

}
