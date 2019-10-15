package at.htl.quarkus;

import at.htl.entity.Barbershop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BarbershopService {

    @Inject
    EntityManager entityManager;

    public List<Barbershop> getAll(){
        TypedQuery<Barbershop> query = entityManager.createNamedQuery("barbershop.findAll", Barbershop.class);
        return query.getResultList();
    }
}
