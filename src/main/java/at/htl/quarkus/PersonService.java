package at.htl.quarkus;

import at.htl.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    private EntityManager em;

    @Transactional
    public Person createPerson(String name){
        Person person = new Person();
        person.setName(name);
        em.persist(person);
        return person;
    }

    public List<Person> findAll(){
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll",Person.class);
        return query.getResultList();
    }

    public Person findPersonByName(String name){
        TypedQuery<Person> query = em.createNamedQuery("Person.findByName", Person.class);
        query.setParameter("NAME", name);

        List<Person> ret = query.getResultList();

        if(ret.size() == 0){
            return null;
        }
        
        return query.getResultList().get(0);
    }

}
