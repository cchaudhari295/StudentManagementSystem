package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	public static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("*************Student Management System*************");
		System.out.println("**********************Welcome*********************");
		studentList = new ArrayList<Student>();
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

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		Student result = findStudentById("S-3");
		System.out.println("Student Result :" + result);

		sortByName();

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