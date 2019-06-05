package com.serenity.repository.repository.specification.specificationimpl;

import com.serenity.repository.entity.Person;
import com.serenity.repository.repository.specification.Specification;
/**
 *
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class FindByPersonId implements Specification<Person> {

    private long userId;

    public FindByPersonId(long userId) {
        this.userId = userId;
    }


    @Override
    public boolean isExist(Person person) {
        return person.getId() == userId;
    }
}
