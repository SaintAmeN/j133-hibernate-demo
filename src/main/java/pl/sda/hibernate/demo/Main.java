package pl.sda.hibernate.demo;

import org.hibernate.Session;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-demo
 * @created 26.11.2022
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession();
        session.close();
    }
}
