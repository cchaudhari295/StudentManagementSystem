package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentID;
	private List<String> courses;

	public Student(String name, int age, String studentID) {
		super();
		if (validateName(name) && validateAge(age) && validateStudentID(studentID)) {
			this.name = name;
			this.age = age;
			this.studentID = studentID;
			courses = new ArrayList<String>();
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentID=" + studentID + ", courses=" + courses + "]";
	}

	public void enrollCourse(String course) {

		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to " + course + " successfully!!!");
			} else {
				System.err.println("Student is already enrolled to " + course);

			}
		}
	}

	public void printStudentInfo() {
		System.out.println("============Student Information============");
		System.out.println("Student Name is " + name);
		System.out.println("Student Age is " + age);
		System.out.println("Student Id is " + studentID);
		System.out.println("Enrolled For: " + courses);

	}

	public boolean validateAge(int age) {

		if (age > 19 && age < 31)
			return true;
		else {
			System.err.println("Invalid age!!! Student age needs to be between 20 and 30");
			return false;
		}

	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);

		if (nameMatcher.matches())
			return true;
		else {
			System.err.println("Invalid Name!!!Please enter letters only");
			return false;
		}
	}

	public boolean validateStudentID(String studentID) {
		// String studentIdRegex="S-[0-9]+$";
		String studentIdRegex = "S-\\d+$";
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentID);
		if (studentIdMatcher.matches()) {
			System.out.println();
			return true;
		} else {
			System.err.println("Invalid StudentId!!!Use the format Eg... S-1234");
			return false;
		}

	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {
			return true;
		} else {
			System.err
					.println("Invalid course name!!! Please select valid courses from the list!!![Java, DSA, DevOps]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return studentID;
	}

	public List<String> getCourses() {
		return courses;
	}

}
