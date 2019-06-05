package com.serenity.repository.repository;

import com.serenity.repository.repository.specification.Specification;

import java.util.List;
/**
 *
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public interface Repository<T> {
    void add(T t);
    List<T> getAll();
    List<T> findBySpecification(Specification specification);
    void update(T oldT, T newT);
    void remove(long id);
}
