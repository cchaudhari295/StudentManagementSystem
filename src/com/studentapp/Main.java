package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("*************Student Management System*************");
		System.out.println("**********************Welcome*********************");

		Student s1;
		s1 = new Student("Niki Raj", 26, "S-7");
		s1.enrollCourse("DSA");
		// System.out.println(s1);
		s1.printStudentInfo();

		Student s2 = new Student("Kiki", 22, "S-2");
		s2.enrollCourse("Java");
		// System.out.println(s2);
		s2.printStudentInfo();

		Student s3 = new Student("Miki", 25, "S-3");
		s3.enrollCourse("DevOps");
		// System.out.println(s3);
		s3.printStudentInfo();
	}

}