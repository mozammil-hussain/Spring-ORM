package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Spring ORM");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//       Student student=new Student(2345,"Sherlin Janet J","Blr");
//       
//       
//       int r=studentDao.insert(student);
//       System.out.println("Inserted succesfully.. "+r); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean b = true;
		while (b) {
			System.out.println("Press 1 for add new student");
			System.out.println("Press 2 for display all student");
			System.out.println("Press 3 for get detail of single student");
			System.out.println("Press 4 for delete students");
			System.out.println("Press 5 for update student");
			System.out.println("Press 6 for exit");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1: {
					System.out.println("Enter UserId");
					int uid = Integer.parseInt(br.readLine());

					System.out.println("Enter username");
					String uName = br.readLine();

					System.out.println("Enter City name");
					String uCity = br.readLine();

					Student s = new Student(uid, uName, uCity);

					int i = studentDao.insert(s);
					System.out.println(i + " Student Addded.. ");

					break;
				}
				case 2: {
					System.out.println("*************************************************");
					List<Student> allStudent = studentDao.getAllStudents();

					for (Student s : allStudent) {
						System.out.println("Name " + s.getStudentName());
						System.out.println("StudentId " + s.getStudentId());
						System.out.println("City " + s.getStudentCity());
						System.out.println("_________________________________________");
					}
					System.out.println("*************************************************");
					break;
				}
				case 3: {
					System.out.println("Enter UserId");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);

					System.out.println("Name " + student.getStudentName()); 
					System.out.println("StudentId " + student.getStudentId());
					System.out.println("City " + student.getStudentCity());
					System.out.println("_________________________________________");

					System.out.println("*************************************************");

					break;
				
				}
				case 4: {
					
					System.out.println("Enter UserId");
					int id = Integer.parseInt(br.readLine()); 
					studentDao.delete(id);
					System.out.println("Student deleted.");
                
  					break;
				}
				case 5: {
					System.out.println("Enter UserId");
					int uid = Integer.parseInt(br.readLine());

					System.out.println("Enter New username");
					String uName = br.readLine();

					System.out.println("Enter New City name");
					String uCity = br.readLine();
					Student student=new Student(uid,uName,uCity);
					studentDao.updateStudent(student);
					break;
				}
				case 6: {
					System.out.println("Thankyou!!!");
					b = false;
					break;
				}
				}

			} catch (Exception e) {
				System.out.println("Invalid input Try with Another one !\n");
				System.out.println(e.getMessage());
			}
		}

	}
}
