package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
		
			// start a transaction
			session.beginTransaction();
			
			 //get the students Mary from the database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println(tempStudent);
			
			//create more courses
			Course course2 = new Course("Rubik's cube");
			Course course3 = new Course("Atary 2600");
			
			
			//add students to courses
			course2.addStudent(tempStudent);
			course3.addStudent(tempStudent);
			
			
			//save the courses
			System.out.println("Saving the courses!");
			session.save(course2);
			session.save(course3);
			
			
					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

