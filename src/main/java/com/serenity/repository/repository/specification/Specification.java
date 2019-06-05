package com.serenity.repository.repository.specification;

/**
 *
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public interface Specification<T> {

    boolean isExist(T t);
}
