package springBootPractice.demo3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springBootPractice.demo3.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {
	 /**
     *  通过年龄来查询
     *  方法名固定findByAge
     * @param age
     * @return
     */
	public List<Person> findByAge(Integer age);
}
