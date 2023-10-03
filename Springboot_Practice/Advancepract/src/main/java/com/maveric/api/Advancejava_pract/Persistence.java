package com.maveric.api.Advancejava_pract;

import java.util.Scanner;

public class Persistence {
	public static int persistence(int num) { 
		int count = 0;

		while (num > 9) {
			int product = 1;
			while (num != 0) {
				int digit = num % 10;
				product *= digit;
				num /= 10;
			}
			num = product;
			count++;
		}
 
		return count;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int num = scanner.nextInt();
		scanner.close();

		int result = persistence(num);
		System.out.println("Multiplicative persistence: " + result);
}
}

