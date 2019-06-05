package com.serenity.repository.runner;

import com.serenity.repository.entity.Gender;
import com.serenity.repository.entity.Person;
import com.serenity.repository.repository.PersonRepository;
import com.serenity.repository.repository.specification.specificationimpl.FindByPersonId;
import com.serenity.repository.repository.specification.specificationimpl.FindByPersonName;
import com.serenity.repository.sorage.PersonStorage;

import java.util.List;
/**
 *
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class Runner {
    public static void main(String[] args) {

        PersonRepository repository = new PersonRepository();
        Person person = new Person(1, "Person1", 24, "city", "email", "job", Gender.MALE, false);
        Person person1 = new Person(2, "Person2", 22, "city2", "email2", "job2", Gender.FEMALE, true);
        Person person2 = new Person(3, "Person3", 20, "city3", "email3", "job3", Gender.MALE, true);
        Person person3 = new Person(4, "Person4", 18, "city4", "email4", "job4", Gender.FEMALE, false);
        Person person4 = new Person(5, "Person5", 50, "city5", "email5", "job5", Gender.MALE, true);
        Person person5 = new Person(6, "Person6", 34, "city6", "email6", "job6", Gender.FEMALE, false);

        // Adding Person to the storage
        repository.add(person);
        repository.add(person1);
        repository.add(person2);
        repository.add(person3);
        repository.add(person4);
        repository.add(person5);

        // Getting Person list from the storage
        System.out.println("=================== Getting Person list from the storage ===================");
        List<Person> personList = repository.getAll();

        for (Person p : personList) {
            System.out.println(p);
        }
        System.out.println("===================");
        // FindByPersonName Specification
        System.out.println("=================== FindByPersonName Specification ===================");

        String name = "Person4";
        List<Person> findByPersonName = repository.findBySpecification(new FindByPersonName(name));
        for (Person p : findByPersonName) {
            System.out.println(p);
        }

        System.out.println("===================");
        // FindByPersonId Specification
        System.out.println("=================== FindByPersonId Specification ===================");

        int id = 2;
        List<Person> findByPersonId = repository.findBySpecification(new FindByPersonId(id));
        for (Person p : findByPersonId) {
            System.out.println(p);
        }

        /* You can check the Person class then creating a specification search as FindByPersonId
        and FindByPersonName in the repository package
        */

        System.out.println("===================");
        // Update Old Person with a new one
        System.out.println("=================== Update Old Person with a new one ===================");

        Person person6 = new Person(7, "Person7", 48, "city6", "email6", "job6", Gender.FEMALE, false);
        repository.update(person5, person6);
        int indexOfUpdatedObject = PersonStorage.getInstance().getPersonList().indexOf(person6);
        System.out.println(PersonStorage.getInstance().getPersonList().get(indexOfUpdatedObject));

        System.out.println("===================");
        // remove Person from the list
        System.out.println("=================== remove Person from the list ===================");
        repository.remove(2);
        List<Person> personListAfterRemovingPerson = repository.getAll();

        for (Person p : personListAfterRemovingPerson) {
            System.out.println(p);
        }
    }
}
