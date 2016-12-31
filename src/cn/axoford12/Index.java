package cn.axoford12;

import java.util.Scanner;

import exceptions.InvalidMethodNameException;

public class Index {

	public static void main(String[] args) {

		// Create an Object
		Changer cgr = new Changer();
		try {
			// Print result.
			System.out.println(cgr.change());
			Scanner input = new Scanner(System.in);
			input.next();
			input.close();
		} catch (InvalidMethodNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
