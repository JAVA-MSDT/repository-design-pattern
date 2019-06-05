package com.serenity.repository.repository;

import com.serenity.repository.entity.Person;
import com.serenity.repository.sorage.PersonStorage;
import com.serenity.repository.repository.specification.Specification;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class PersonRepository implements Repository<Person> {

    private List<Person> storage;

    public PersonRepository() {
        storage = PersonStorage.getInstance().getPersonList();
    }

    @Override
    public void add(Person person) {
        storage.add(person);
    }

    @Override
    public List<Person> getAll() {
        return storage;
    }

    @Override
    public List<Person> findBySpecification(Specification specification) {
        List<Person> personList = new ArrayList<>();
        for (Person person : storage) {
            if (specification.isExist(person)) {
                personList.add(person);
            }
        }
        return personList;
    }

    @Override
    public void update(Person oldPerson, Person newPerson) {
       if(storage.contains(oldPerson)){
           int oldPersonIndex = storage.indexOf(oldPerson);
           storage.set(oldPersonIndex, newPerson);
       }else {
           System.out.println("This Person is not in the Storage");
       }
    }

    @Override
    public void remove(long id) {
        for (Person person : storage) {
            if (person.getId() == id) {
                storage.remove(person);
                break;
            }
        }
    }
}
