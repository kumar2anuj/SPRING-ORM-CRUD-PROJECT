package MVC.spring_orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		Student student = new Student(232945, "Durgesh Tiwari", "lucknow");
//		int r = studentDao.insert(student);
//		System.out.println("done " + r);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean go=true;
		while (go) {
			System.out.println("press 1 for add new student");
			System.out.println("press 2 for display all student");
			System.out.println("press 3 for get details of single student");
			System.out.println("press 4 for delete student");
			System.out.println("press 5 for update student");
			System.out.println("press 6 for exit");

			try {
				int input = Integer.parseInt(bufferedReader.readLine());
				switch (input) {
				case 1:
					//add all
					System.out.println("enter user id");
					int uid=Integer.parseInt(bufferedReader.readLine());
					System.out.println("enter user name");
					String uName=bufferedReader.readLine();
					System.out.println("enter user city");
					String uCity=bufferedReader.readLine();
					
					Student student=new Student();
					student.setStudentId(uid);
					student.setStudentName(uName);
					student.setStudentCity(uCity);
					
					int r=studentDao.insert(student);
					System.out.println(r + "student added");
					System.out.println("************************************");
					System.out.println();
					break;
				case 2:
					//display all
					List<Student> allStudents=studentDao.getAllStudents();
					for(Student st : allStudents)
					{
						System.out.println("________________________________________________");

						System.out.println();
						System.out.println("id  " + st.getStudentId());
						System.out.println("name  " + st.getStudentName());
						System.out.println("city  " + st.getStudentCity());
					
						System.out.println("________________________________________________");
					}
					break;
				case 3:
					// get single student data
					System.out.println("Enter user id : ");
					int userId = Integer.parseInt(bufferedReader.readLine());
					Student student1 = studentDao.getStudent(userId);
					System.out.println("Id : " + student1.getStudentId());
					System.out.println("Name : " + student1.getStudentName());
					System.out.println("City : " + student1.getStudentCity());
					System.out.println("___________________________________");

					break;
				case 4:
					// delete student;

					System.out.println("Enter user id : ");
					int id = Integer.parseInt(bufferedReader.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted...");
					break;

				case 5:
					// update the student
					System.out.println("Enter user id : ");
					int id1 = Integer.parseInt(bufferedReader.readLine());
					Student student2 = studentDao.getStudent(id1);
					studentDao.updateStudent(student2);
					
					break;

				case 6:
					// exit
					go = false;
					break;

				}
			} catch (Exception e) {
				System.out.println("invalid input try another");
			}
		}
		System.out.println("THANKS FOR USING");
		

	}
}
