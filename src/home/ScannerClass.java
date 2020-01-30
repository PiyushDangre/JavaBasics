package home;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Input");
        int i = scan.nextInt();
        scan.nextLine();
        Double d = Double.parseDouble(scan.nextLine());
        String s = scan.nextLine();
        scan.close();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

	}

}
