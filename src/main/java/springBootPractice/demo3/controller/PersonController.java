package springBootPractice.demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBootPractice.demo3.dao.PersonRepository;
import springBootPractice.demo3.entities.Person;

@RestController
	public class PersonController {
	    @Autowired
	    PersonRepository personRepository;
	    @GetMapping(value = "/person")
	    private List<Person> personList() {
	        return personRepository.findAll();
	    }
	    
	    /**
	     * 添加一个人员
	     *
	     * @param name
	     * @param age
	     * @return
	     */
	    @PostMapping(value = "/person")
	    public Person personAdd(@RequestParam("name") String name,
	                        @RequestParam("age") Integer age) {
	        Person person = new Person();
	        person.setName(name);
	        person.setAge(age);

	        return personRepository.save(person);
	    }
	    
	    /**
	     * 删除一个人员
	     *
	     * @param id
	     */
	    @PostMapping(value = "/person/{id}")
	    public void personDelete(@PathVariable("id") Integer id) {
	        personRepository.delete(id);
	    }
	    
	    /**
	     * 查询一个人员
	     *
	     * @param id
	     * @return
	     */
	    @PostMapping(value = "/person/{id}")
	    public Person personFindOne(@RequestParam("id") Integer id) {
	        Person person=personRepository.findOne(id);

	        return person;
	    }
	    
	    /**
	     * 更新一个人员
	     *
	     * @param id
	     * @param name
	     * @param age
	     * @return
	     */
	    @PostMapping(value = "/person/{id}")
	    public Person personUpdate(@PathVariable("id") Integer id,
	    					@RequestParam("name") String name,
	                        @RequestParam("age") Integer age) {
	        Person person = personRepository.getOne(id);
	        person.setName(name);
	        person.setAge(age);

	        return personRepository.save(person);
	    }
	    
	    /**
	     * 通过年龄来查询
	     * @param age
	     * @return
	     */
	    @GetMapping(value = "/person/age/{age}")
	    public List<Person> personListByAge(@PathVariable("age") Integer age) {
	        return personRepository.findByAge(age);
	    }
	    
	    
	}

