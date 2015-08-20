package net.sl;

import net.sl.entity.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by a601054 on 2015-08-20.
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            listElements(entityManager);
            fillEventList(entityManager);
            listElements(entityManager);

            entityManager.close();
        } finally {
            entityManagerFactory.close();
        }
    }

    private static void fillEventList(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Event event = new Event();
        event.setName("event_1");
        entityManager.persist(event);

        Event event2 = new Event();
        event2.setName("event_2");
        entityManager.persist(event2);

        entityManager.getTransaction().commit();
    }

    private static void listElements(EntityManager entityManager) {
        List<Event> resultList = entityManager.createQuery("FROM Event e", Event.class).getResultList();
        System.out.println("Event list\n---");
        for (int i = 0; i < resultList.size(); i++) {
            Event event = resultList.get(i);
            System.out.printf("%d. %s\n", event.getId(), event.getName());
        }
        System.out.println("---");
    }

}
