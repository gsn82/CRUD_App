package ru.gorshkov.springcource.DAO;

import org.springframework.stereotype.Component;
import ru.gorshkov.springcource.model.Person;


import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom",34,"Tom@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",33,"Bob@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",13,"Mike@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy",56,"Katy@mail.com"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatePerson.getName());
        personToBeUpdate.setAge(updatePerson.getAge());
        personToBeUpdate.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
