package com.dsAlgo.math;

import java.util.HashSet;
import java.util.Set;

public class VerifyPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 223242566;

		// Compare time differences

		// Using Optimized Algorithm
		System.out.println(System.currentTimeMillis());
		System.out.println(verifyPrime(number));
		System.out.println(System.currentTimeMillis());

		// Just running loop from 1 to number
		System.out.println(System.currentTimeMillis());
		System.out.println(verifyPrime1(number));
		System.out.println(System.currentTimeMillis());
	}

	private static boolean verifyPrime(int number) {
		// TODO Auto-generated method stub

		int count = 0;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				count++;
			}
		}

		if (count > 0)
			return false;
		else
			return true;

	}

	private static boolean verifyPrime1(int number) {
		// TODO Auto-generated method stub
		int count = 0;

		for (int i = 2; i <= number; i++) {
			if (number % i == 0) {
				count++;
			}
		}

		if (count > 0)
			return true;
		else
			return false;

	}
}
