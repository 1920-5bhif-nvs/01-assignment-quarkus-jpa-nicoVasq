package at.htl.business;

import at.htl.entity.Barbershop;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    void init(@Observes StartupEvent ev){
        System.out.println("-----INIT-----");

        Barbershop shop = new Barbershop("Klipp","Linz");
        em.persist(shop);
        Barbershop shop2 = new Barbershop("Klipp","Ottensheim");
        em.persist(shop2);
        Barbershop shop3 = new Barbershop("Schnittzone","Linz");
        em.persist(shop3);
    }
}
