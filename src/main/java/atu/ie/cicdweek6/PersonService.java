package atu.ie.cicdweek6;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person create(Person p) {
        return repo.save(p);
    }

    public List<Person> findAll() {
        return repo.findAll(); }

    public Person findById(Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person Cannot Be Found"));

    }

    public Person update(Long id, Person p) {

        Person existingPerson = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person Cannnot Be Found"));

        existingPerson.setName(p.getName());
        existingPerson.setEmail(p.getEmail());
        existingPerson.setEmployeeId(p.getEmployeeId());
        existingPerson.setPosition(p.getPosition());
        existingPerson.setDepartment(p.getDepartment());
        return repo.save(p);

    }

    public Person delete(Long id) {

        Person person = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person Cannnot Be Found"));

        repo.delete(person);
        return person;
    }

}