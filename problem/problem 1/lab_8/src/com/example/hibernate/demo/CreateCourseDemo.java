package com.example.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetails;
import com.example.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseDemo {

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
			
			int theId = 1;
			
			
			// start session
			session.beginTransaction();
			Instructor temInstructor = session.get(Instructor.class,theId);
			
			Course tempCourse1 = new Course("Java core basis");
			Course tempCourse2 = new Course("Learing Java by Hard way");
			
			temInstructor.addCourse(tempCourse1);
			temInstructor.addCourse(tempCourse2);

			// save instructor obj
			System.out.println("Saving the Instructor...");
			session.save(tempCourse1);
			session.save(tempCourse2);

			// instructor id after add instructor into database

			// commit session
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {

			session.close();

			factory.close();
		}

	}

}
