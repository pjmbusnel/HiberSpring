package com.pjmb.hiberspring.students;

import com.pjmb.hiberspring.students.dao.StudentEntity;
import com.pjmb.hiberspring.students.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentsCrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsCrudSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//readStudents(studentDAO);
			//readStudentsByLastName(studentDAO);
			//readStudentsByFirstName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int nbRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + nbRowDeleted + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student with id:" + studentId);
		studentDAO.delete(1);
		System.out.println("Deleted student: " + studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Getting student with id:" + studentId);
		StudentEntity myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student with id:" + studentId);
		myStudent.setFirstName("Chuck");
		myStudent.setLastName("Norris");
		myStudent.setEmail("Chuck@Norris.com");

		studentDAO.update(myStudent);
		System.out.println("updated student: " + myStudent);
	}

	private void readStudentsByFirstName(StudentDAO studentDAO) {
		// READ all students by firstName
		List<StudentEntity> students = studentDAO.findAllByFirstName("Pedro11");
		System.out.println("Found " + students.size() + " students");
		for (StudentEntity student : students) {
			System.out.println(student);
		}
	}

	private void readStudentsByLastName(StudentDAO studentDAO) {
		// READ all students by lastName
		List<StudentEntity> students = studentDAO.findAllByLastName("LAne");
		System.out.println("Found " + students.size() + " students");
		for (StudentEntity student : students) {
			System.out.println(student);
		}
	}

	private void readStudents(StudentDAO studentDAO) {
		// READ all students
		List<StudentEntity> students = studentDAO.findAll();
		System.out.println("Found " + students.size() + " students");
		for (StudentEntity student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new Student");
		StudentEntity tmpStudent = new StudentEntity("Daffy","LAne", "pedro@lane.ca");
		studentDAO.save(tmpStudent);
		System.out.println("Student saved with ID=" + tmpStudent.getId());

		// READ
		StudentEntity student = studentDAO.findById(tmpStudent.getId());
		System.out.println("Found student with ID=" + student.getId() + " name is " + student.getFirstName());
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating Students");
		StudentEntity tmpStudent1 = new StudentEntity("Pedro11","LAne11", "pedro1@lane.ca");
		StudentEntity tmpStudent2 = new StudentEntity("Pedro22","LAne22", "pedro2@lane.ca");
		StudentEntity tmpStudent3 = new StudentEntity("Pedro33","LAne33", "pedro3@lane.ca");

		System.out.println("Saving Students");
		studentDAO.save(tmpStudent1);
		studentDAO.save(tmpStudent2);
		studentDAO.save(tmpStudent3);

		System.out.println("Student saved with ID=" + tmpStudent1.getId());
		System.out.println("Student saved with ID=" + tmpStudent2.getId());
		System.out.println("Student saved with ID=" + tmpStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student");
		StudentEntity tmpStudent = new StudentEntity("Pedro","LAne", "pedro@lane.ca");

		System.out.println("Saving Student");
		studentDAO.save(tmpStudent);

		System.out.println("Student saved with ID=" + tmpStudent.getId());
	}

}
