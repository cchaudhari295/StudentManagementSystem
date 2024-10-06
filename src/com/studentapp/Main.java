package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("*************Student Management System*************");
		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);
		while (true) {
			System.out.println("**********************Welcome*********************");
			System.out.println("Select an option....");
			System.out.println("1. Register a Student");
			System.out.println("2. Find Student with StudentID");
			System.out.println("3. List All Student Information");
			System.out.println("4. List Student Information In Sorted Order");
			System.out.println("5. Exit");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentById(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid option selected.... Enter between 1 to 5");
			}
		}

	}

	private static void findStudentById(Scanner scanner2) {
		Student studentFound = null;
		System.out.println("Enter the student ID");
		String studentId = scanner2.next();
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentID().equalsIgnoreCase(studentId))
					.findFirst().orElseThrow(() -> new RuntimeException("No Data Found!!!"));
		}

		catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found");
		}
		studentFound.printStudentInfo();
	}

	private static void printAllStudentData() {
		if (studentList.size() > 0) {
			System.out.println("---------------PRINTING ALL STUDENT DATA---------------");
			for (Student student : studentList) {
				System.out.println(student);
			}
		} else {
			System.err.println("Student list is empty");
		}
	}

	private static void exit() {
		System.out.println("Good Bye!!!");
		System.exit(0);
	}

	private static int checkValidAgeEntered() {
		int age = 0;
		try {
			age = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Invalid age!!! Please enter digits only");
			System.exit(0);
		}
		return age;
	}

	private static void enrollStudent(Scanner scanner2) {

		System.out.println("Enter Student Name...");
		String name = scanner.next();

		System.out.println("Enter Student Age...");
		int age = checkValidAgeEntered();

		System.out.println("Enter Student Id...");
		String id = scanner.next();

		Student newStudent = new Student(name, age, id);

		while (newStudent.getName() == null || newStudent.getAge() == 0 || newStudent.getStudentID() == null) {

			System.out.println("Re-Enter the information....");
			System.out.println("Enter Student Name...");
			name = scanner.next();

			System.out.println("Enter Student Age...");
			age = scanner.nextInt();

			System.out.println("Enter Student Id...");
			id = scanner.next();
			newStudent = new Student(name, age, id);
		}

		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course to be enrolled...Type Done to exit");
			String course = scanner.next();
			if (course.equalsIgnoreCase("done")) {
				break;
			}
			newStudent.enrollCourse(course);

		}

		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		Collections.sort(studentList, studentNameComparator);
		printAllStudentData();
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