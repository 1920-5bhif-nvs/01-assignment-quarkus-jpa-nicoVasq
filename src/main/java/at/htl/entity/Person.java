package at.htl.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(name = "Person.findAll", query = "FROM Person "),
    @org.hibernate.annotations.NamedQuery(name = "Person.findByName", query = "FROM Person WHERE name = :NAME")
})
public class Person implements Serializable {

    private Long id;
    private String name;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
