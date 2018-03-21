package js.UI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import js.Bean.Book;
import js.Dao.BookDao;
import js.Exception.BookNotFoundException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Operations: A)Add B)Find C)Delete");
		System.out.println("Please Select Operation:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String op = br.readLine();
			if (op.equalsIgnoreCase("A")){
				System.out.print("Enter name:");
				String name = br.readLine();
				System.out.print("Enter price");
				String price = br.readLine();
				System.out.print("Enter author");
				String author = br.readLine();
				System.out.print("Enter date");
				String date = br.readLine();
				System.out.print("Enter id");
				String id = br.readLine();
				
				Book b = new Book();
				b.setAuthor(author);
				b.setDate(Double.parseDouble(date));
				b.setId(id);
				b.setName(name);
				b.setPrice(Double.parseDouble(price));
				
				BookDao dao = new BookDao();
				dao.add(b);
			} else if(op.equalsIgnoreCase("B")) {
				System.out.println("Enter name:");
				String name = br.readLine();
				BookDao dao = new BookDao();
				dao.find(name);
			} else if(op.equalsIgnoreCase("C")) {
				System.out.println("Enter name:");
				String name = br.readLine();
				BookDao dao = new BookDao();
				try {
					dao.delete(name);
				} catch (BookNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("BookNotFound!");
				}
			} else {
				System.out.println("Your input is not supported!");
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //Logging!
			System.out.println("Busy!");
		}
		
		
	}

}
