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


khi lưu instructor thì bảng instructor và instructor_detail cập nhật còn bảng course thì không

==> khi thay đổi ở lớp instructor
cascade = CascadeType.All, fetch =fetchType.eager thì nó hoạt động