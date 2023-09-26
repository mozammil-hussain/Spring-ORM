package com.spring.orm.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.orm.entities.Student; 
public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	//save student
	@Transactional
	public int insert(Student student)
	{
		//insert 
		Integer i=(Integer)this.hibernateTemplate.save(student);
		
		return i;
	}
	//get the single data(object)
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//get all students(all rows)
	
	public List<Student> getAllStudents()
	{
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	//deleting data
	@Transactional
	public void delete(int studentId)
	{
		this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(studentId);
	}
	//updating data
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
