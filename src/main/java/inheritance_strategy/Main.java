package inheritance_strategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try(SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();   ){




            session.beginTransaction();

            Query query = session.createQuery("select name from Car order by name");
            List<String> list = query.list();
            System.out.println(list);

            session.getTransaction().commit();

            //            Car toyota = new Car("Toyota");
//            Car opel = new Car("Opel");
//            Car bmw = new Car("BMW");
//            session.persist(toyota);
//            session.persist(opel);
//            session.persist(bmw);
        }
    }
}
