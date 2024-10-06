package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	public static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("*************Student Management System*************");
		System.out.println("**********************Welcome*********************");
		studentList = new ArrayList<Student>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student Name...");
		String name=scanner.next();//Read input in String format, use this
		System.out.println("You have entered the name "+ name);
		
		System.out.println("Enter Student Age...");
		int age=scanner.nextInt();//Read input in int format, use this
		System.out.println("You have entered the age "+ age);
	}

	private static void sortByName() {

//		Comparator<Student> studentNameComparator=new Comparator<Student>() {
//			
//			@Override
//			public int compare(Student o1, Student o2) {
//
//				return o1.getName().compareTo(o2.getName());
//			}
//		};

		// OR

		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found!!!"));
		}

		catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found");
		}
		return result;
	}

}