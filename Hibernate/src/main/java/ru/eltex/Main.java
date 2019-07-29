package ru.eltex;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        //session.save()

        User u1 = new User("Eugene");
        User u2 = new User("Leshy");

        Passport p1 = new Passport(235674,5013);
        Passport p2 = new Passport(595732,5013);

        session.beginTransaction();
        session.save(u1);
        session.save(u2);
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
        session.close();
    }
}
