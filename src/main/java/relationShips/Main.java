package relationShips;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession();
             Session session2 = sessionFactory.openSession()) {

            session.beginTransaction();
            Hobbies hobby = new Hobbies("Chilling");
            session.persist(hobby);
            session.getTransaction().commit();

            new Thread(() -> {
                session.beginTransaction();
                Hobbies loadedHobby = session.load(Hobbies.class, 1, LockMode.PESSIMISTIC_WRITE);
                loadedHobby.setHobbyName(loadedHobby.getHobbyName() + " the");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                session.getTransaction().commit();
            }).start();

            new Thread(() -> {
                session2.beginTransaction();
                Hobbies loadedHobby = session2.load(Hobbies.class, 1, LockMode.PESSIMISTIC_WRITE);
                loadedHobby.setHobbyName(loadedHobby.getHobbyName() + " best");
                session2.getTransaction().commit();
            }).start();

            Thread.sleep(1000);

        }
    }
}
