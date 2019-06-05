package com.serenity.repository.entity;

import com.serenity.repository.util.ArgumentValidator;

import java.util.Objects;

/**
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class Person {
    private long id;
    private String name;
    private int age;
    private String livingCity;
    private String email;
    private String job;
    private Gender gender;
    private boolean isMarried;

    public Person() {
    }

    public Person(long id, String name, int age, String livingCity, String email, String job, Gender gender, boolean isMarried) {
        setId(id);
        setName(name);
        setAge(age);
        setLivingCity(livingCity);
        setEmail(email);
        setJob(job);
        setGender(gender);
        setMarried(isMarried);
    }

    public Person(long id, String name, int age, String livingCity, String email, Gender gender) {
        setId(id);
        setName(name);
        setAge(age);
        setLivingCity(livingCity);
        setEmail(email);
        setGender(gender);
    }

    public Person(long id, String name, int age, String email, Gender gender) {
        setId(id);
        setName(name);
        setAge(age);
        setEmail(email);
        setGender(gender);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        ArgumentValidator.checkForNegativity(id, "Person id is not allow to be negative number");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ArgumentValidator.checkForNullOrEmptyString(name, "Person Name is not allow to be empty or null");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        ArgumentValidator.checkForNegativity(age, "Person Age is not allow to be negative number");
        this.age = age;
    }

    public String getLivingCity() {
        return livingCity;
    }

    public void setLivingCity(String livingCity) {
        ArgumentValidator.checkForNullOrEmptyString(livingCity, "Person livingCity is not allow to be empty or null");
        this.livingCity = livingCity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        ArgumentValidator.checkForNullOrEmptyString(email, "Person email is not allow to be empty or null");
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        ArgumentValidator.checkForNullOrEmptyString(job, "Person job is not allow to be empty or null");
        this.job = job;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        ArgumentValidator.checkForNull(gender, "Person gender is not allow to be empty or null");
        this.gender = gender;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                isMarried == person.isMarried &&
                Objects.equals(name, person.name) &&
                Objects.equals(livingCity, person.livingCity) &&
                Objects.equals(email, person.email) &&
                Objects.equals(job, person.job) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + age;
        result = prime * result + (livingCity != null ? livingCity.hashCode() : 0);
        result = prime * result + (email != null ? email.hashCode() : 0);
        result = prime * result + (job != null ? job.hashCode() : 0);
        result = prime * result + (gender != null ? gender.hashCode() : 0);
        result = prime * result + (isMarried ? 1231 : 1237);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", livingCity='" + livingCity + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", gender=" + gender +
                ", isMarried=" + isMarried +
                '}';
    }
}
