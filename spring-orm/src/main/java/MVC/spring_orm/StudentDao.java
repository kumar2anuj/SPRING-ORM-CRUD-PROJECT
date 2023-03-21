package MVC.spring_orm;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	// save student
	@Transactional
	public int insert(Student student) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	@Transactional
	public void deleteStudent(int studentID) {
		Student student = this.hibernateTemplate.get(Student.class, studentID);
		this.hibernateTemplate.delete(student);
	}

	@Transactional 
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
