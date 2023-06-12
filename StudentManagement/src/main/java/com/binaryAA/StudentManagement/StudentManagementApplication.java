package com.binaryAA.StudentManagement;

import com.binaryAA.StudentManagement.entity.Student;
import com.binaryAA.StudentManagement.entity.Teacher;
import com.binaryAA.StudentManagement.entity.User;
import com.binaryAA.StudentManagement.repository.StudentRepository;
import com.binaryAA.StudentManagement.repository.TeacherRepository;
import com.binaryAA.StudentManagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private TeacherRepository teacherRepo;

	@Autowired
	private UserRepository userRepo;

	private static final Logger logger = LoggerFactory.getLogger(StudentManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Teacher teacher1 = new Teacher("Hal", "Johnson", "History", 40000);
		Teacher teacher2 = new Teacher("Sandy", "Olsen", "English", 40000);

		List<Teacher> teachers = Arrays.asList(teacher1, teacher2);

		List<Student> students = Arrays.asList(
				new Student("John", "Doe", 14, 3.5, teacher1),
				new Student("Jane", "Doe", 13, 3.45, teacher1),
				new Student("Bob", "Johnson", 15, 3.3, teacher2),
				new Student("Barbara", "Smith", 14, 3.6, teacher2)
		);

		studentRepo.saveAll(students);
		teacherRepo.saveAll(teachers);

//		userRepo.save(new User("user", "$2y$10$ScjYnlgtYxHama9pHlpZAekHWCgx.q.myFuIdyZkYDkaBfnTBbE6q", "USER"));
//		userRepo.save(new User("admin", "$2y$10$h26Vc5Iz4GiFN3RGptjUSefuaC5EXy.dUJB6wnmtsqG99ax3/ovma", "ADMIN"));
		userRepo.save(new User("user", "userPass", "USER"));
		userRepo.save(new User("admin", "adminPass", "ADMIN"));

	}
}
