package com.example.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetails;
import com.example.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateInstructorDemo2 {

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
			Instructor tempInstructor = new Instructor("Susan", "Burble", "susan@example.com");

			// instructor id before add instructor into database

			System.out.println("======>>> Instructor ID (before): " + tempInstructor.getId());

			// create Instructor Detail

			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.youtube.com/susano123",
					"Playing Video games");

			// set instructorDetails obj for instructor obj

			tempInstructor.setInstructorDetails(tempInstructorDetails);

			// instructor Details id before add instructor into database

			System.out.println("======>>> Instructor Details ID (before): " + tempInstructorDetails.getId());

			// add some course for instructor

//			tempInstructor.addCourse(new Course("Java core basis"));
//
//			tempInstructor.addCourse(new Course("Learning Java by Hard way"));

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
