package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-demo
 * @created 26.11.2022
 */
public class MainUpdate_Update {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Student student = Student.builder()
                    .dataUrodzenia(LocalDate.of(1995, 6, 15))
                    .kierunekNauczania("Filozofia")
                    .indeks("321321")
                    .imie("Gaweł")
                    .id(2L)
                    .build();

            // SQL: UPDATE 'student' SET ... WHERE id=X
            // Merge:
            //  - służy do aktualizacji,
            //  - wymaga podania id (w obiekcie) ponieważ jest to kryterium aktualizacji (aktualizujemy obiekt o podanym id)
            // Persist:
            //  - służy do wstawiania NOWYCH rekordów do bazy,
            //  - przeważnie nie podaje się ID ponieważ jest generowane
            session.merge(student);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
