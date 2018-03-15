package com.embraces.hive.test;

public class StringTester {
	
	public static void main(String[] args) {
		
		String src = "a,b ,c, d , e  ,f,  g  ,  h  , , , ,  ,,,  ,,,  ";
		String ptn = "[ ,]+";
		
		String[] arr = src.split(ptn);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("end");
	}
}
