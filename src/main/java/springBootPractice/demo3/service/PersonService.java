package springBootPractice.demo3.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootPractice.demo3.dao.PersonRepository;
import springBootPractice.demo3.entities.Person;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    /**
     * 事务管理测试
     * 两条数据同时成功，或者同时不成功
     * 保证数据库数据的完整性和一致性
     */
    @Transactional
    public void insertTwo(){
        Person personA = new Person();
        personA.setName("Sunny");
        personA.setAge(19);
        personRepository.save(personA);

        System.out.print(1/0);

        Person personB = new Person();
        personB.setName("Spring");
        personB.setAge(25);
        personRepository.save(personB);
    }
}