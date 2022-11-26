package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-demo
 * @created 26.11.2022
 */
public class Main {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            // Tworzymy studenta
//            Student student = new Student();
//            student.setImie("Paweł");
//            student.setDataUrodzenia(LocalDate.of(1990, 1, 3));
//            student.setKierunekNauczania("Informatyka");
//            student.setIndeks("123123");

//            Student student = new Student("Paweł", LocalDate.of(1990, 1, 3), "Informatyka", "123123");
            Student student = Student.builder()
                    .dataUrodzenia(LocalDate.of(1990, 1, 3))
                    .kierunekNauczania("Informatyka")
                    .indeks("123123")
                    .imie("Paweł")
                    .build();

            // zapisujemy studenta
            session.persist(student);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
