package com.serenity.repository.repository.specification.specificationimpl;

import com.serenity.repository.entity.Person;
import com.serenity.repository.repository.specification.Specification;
/**
 *
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class FindByPersonName implements Specification<Person> {

    private String name;

    public FindByPersonName(String name) {
        this.name = name;
    }

    @Override
    public boolean isExist(Person person) {
        return person.getName().equalsIgnoreCase(name);
    }
}
