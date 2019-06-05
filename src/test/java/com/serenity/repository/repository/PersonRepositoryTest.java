package com.serenity.repository.repository;

import com.serenity.repository.entity.Gender;
import com.serenity.repository.entity.Person;
import com.serenity.repository.repository.specification.specificationimpl.FindByPersonId;
import com.serenity.repository.repository.specification.specificationimpl.FindByPersonName;
import com.serenity.repository.sorage.PersonStorage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryTest {

    private static Person person;
    private static Person person1;

    private static Person person2;
    private static Person person3;

    private static Person person4;
    private static Person person5;

    private static PersonRepository personRepository;

    @BeforeClass
    public static void init() {
        person = new Person(1, "Person1", 24, "city", "email", "job", Gender.MALE, false);
        person1 = new Person(2, "Person2", 22, "city2", "email2", "job2", Gender.FEMALE, true);
        person2 = new Person(3, "Person3", 20, "city3", "email3", "job3", Gender.MALE, true);
        person3 = new Person(4, "Person4", 18, "city4", "email4", "job4", Gender.FEMALE, false);
        person4 = new Person(5, "Person5", 50, "city5", "email5", "job5", Gender.MALE, true);
        person5 = new Person(6, "Person6", 34, "city6", "email6", "job6", Gender.FEMALE, false);

        personRepository = new PersonRepository();

        personRepository.add(person);
        personRepository.add(person1);
        personRepository.add(person2);
        personRepository.add(person3);
        personRepository.add(person4);
        personRepository.add(person5);
    }

    @Test
    public void addTestPass() {

        int expectedRecordInStorage = PersonStorage.getInstance().getPersonList().size();
        int actualRecordInStorage = 6;

        Assert.assertEquals(expectedRecordInStorage, actualRecordInStorage);
    }

    @Test
    public void getAllPass(){
        List<Person> actualPersonList = new ArrayList<>();
        actualPersonList.add(person);
        actualPersonList.add(person1);
        actualPersonList.add(person2);
        actualPersonList.add(person3);
        actualPersonList.add(person4);
        actualPersonList.add(person5);

        List<Person> expectedPersonList = PersonStorage.getInstance().getPersonList();

        Assert.assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void findBySpecificationPassUsingName(){
        String name = "Person4";

        List<Person> expectedResult = personRepository.findBySpecification(new FindByPersonName(name));
        List<Person> actualResult = new ArrayList<>();
        actualResult.add(person3);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findBySpecificationPassUsingId(){
        int id = 2;

        List<Person> expectedResult = personRepository.findBySpecification(new FindByPersonId(id));
        List<Person> actualResult = new ArrayList<>();
        actualResult.add(person1);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updatePass(){
        Person person6 = new Person(7, "Person7", 48, "city6", "email6", "job6", Gender.FEMALE, false);

        personRepository.update(person5, person6);

        boolean isInList = PersonStorage.getInstance().getPersonList().contains(person6);

        Assert.assertTrue(isInList);
    }

    @Test
    public void removePass(){
        personRepository.remove(2);
        boolean notInList = PersonStorage.getInstance().getPersonList().contains(person1);
        Assert.assertFalse(notInList);
    }
}
