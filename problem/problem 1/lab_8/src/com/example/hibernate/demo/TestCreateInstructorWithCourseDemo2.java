package com.example.hibernate.demo;

import org.hibernate.cfg.Configuration;


// tai sao su dung cach duoi trong bang instructor va instructor_detail cos cap nhat con bang course thi khong

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetails;
import com.example.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestCreateInstructorWithCourseDemo2 {

	public static void main(String[] args) {
		// create session factory

		System.out.println("test 1");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		System.out.println("test 2");
		// create session

		Session session = factory.getCurrentSession();

		System.out.println("test 3");
		// use the session obj to save java obj

		try {
		    // create Instructor
		    Instructor tempInstructor = new Instructor("Jame", "Wild", "jammewild@example.com");

		    // instructor id before add instructor into database
		    System.out.println("======>>> Instructor ID (before): " + tempInstructor.getId());

		    // create Instructor Detail
		    InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.youtube.com/tempcode", "Listening Music");

		    // set instructorDetails obj for instructor obj
		    tempInstructor.setInstructorDetails(tempInstructorDetails);

		    // instructor Details id before add instructor into database
		    System.out.println("======>>> Instructor Details ID (before): " + tempInstructorDetails.getId());

		    // add some course for instructor
		    Course tempCourse1 = new Course("Spring boot for beginer");
		    Course tempCourse2 = new Course("Advanced Spring boot");

		    tempInstructor.addCourse(tempCourse1);
		    tempInstructor.addCourse(tempCourse2);


		    // start session
		    session.beginTransaction();

		    // save instructor obj
		    System.out.println("Saving the Instructor...");
		    session.save(tempInstructor);


		    // instructor id after add instructor into database
		    System.out.println("======>>> Instructor ID (after): " + tempInstructor.getId());

		    // instructor Details id after add instructor into database
		    System.out.println("======>>> Instructor Details ID (after): " + tempInstructorDetails.getId());

		    // commit session
		    session.getTransaction().commit();

		    System.out.println("Done!");

		} finally {
		    session.close();
		    factory.close();
		}

	}

}
