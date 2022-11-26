package pl.sda.hibernate.demo;

import org.hibernate.Session;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-demo
 * @created 26.11.2022
 */
public class MainRead_SelectById {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, 2L);

            // SELECT * FROM Student WHERE id=X
            System.out.println("Znaleźliśmy studenta: " + student);

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
}
