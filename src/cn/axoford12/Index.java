package cn.axoford12;

import exceptions.InvalidMethodNameException;

public class Index {
	public static void main(String[] args) {
		new Thread(new RunningThread()).start();
	}

	public static void Runner() {

		// Create an Object
		Changer cgr = new Changer();
		try {
			// Print result.
			System.out.println(cgr.change());
		} catch (InvalidMethodNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
