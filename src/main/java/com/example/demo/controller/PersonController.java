package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/")
    public String home(){
        System.out.println("From Home");
        return "insertperson";
    }
    @RequestMapping("/find")
    public String find(){
        System.out.println("Going to find person");
        return "findperson";
    }
    @RequestMapping("/person")
    public String allPerson(){
        List<Person>  allPerson= personRepository.findAll();
        System.out.println("Printing all :");
        for(Person instance : allPerson){
            System.out.println(instance.getAge() + " " + instance.getName() + " " + instance.getPid());
        }
        return "findperson";
    }
    @GetMapping("/insertPerson")
    public String insertPerson(Person person){
        System.out.println("inserting person " + person.getName() + " age : " + person.getAge() +" id is " + person.getPid());
        personRepository.save(person);
        return "insertperson";
    }
    @GetMapping("/findbyid")
    public String personById(@RequestParam int id){
        System.out.println(" person ID " + id );
        Person  person = personRepository.findById(id).orElse(new Person());
        System.out.println(person.getAge() + " : " +person.getName()+" : " + person.getPid());
        return "findperson";
    }
    @GetMapping("/findbyname")
    public String personByName(@RequestParam String name){
        System.out.println(" person name " + name);
        List<Person>  allPerson=personRepository.findByName(name);
        for(Person instance : allPerson){
            System.out.println(instance.getAge() + " " + instance.getName() + " " + instance.getPid());
        }
        return "findperson";
    }
    @GetMapping("/findbyage")
    public String personByAge(@RequestParam int age){
        System.out.println(" person age " + age);
        List<Person>  allPerson=personRepository.findByAge(age);
        for(Person instance : allPerson){
            System.out.println(instance.getAge() + " " + instance.getName() + " " + instance.getPid());
        }
        return "findperson";
    }
    @GetMapping("update")
    public String updatePerson(){
        System.out.println("update to updateperson html");
        return "updateperson";
    }
    @PostMapping("/updatePerson")
    public String updatePerson(Person person){
        System.out.println("UPDATING TO" + person.getAge()+" : "+person.getName() + " : "+person.getPid());
        //personRepository.save(person);
        //updatePersonPut(person);
        return "updateperson";
    }
    @PutMapping("updatepersonput")
    public void updatePersonPut(Person person){
        System.out.println("UPDATING Put TO" + person.getAge()+" : "+person.getName() + " : "+person.getPid());
        personRepository.save(person);
    }


}
