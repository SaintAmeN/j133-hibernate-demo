package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-demo
 * @created 26.11.2022
 */
public class Zad1_MainCreate_Insert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            System.out.println("Podaj imie:");
            String imie = scanner.nextLine();

            System.out.println("Podaj kierunek:");
            String kierunek = scanner.nextLine();

            String indeks = null;
            do {
                System.out.println("Podaj numer indeksu (6 znaków):");
                indeks = scanner.nextLine();
            }while (indeks.length() != 6);

            // STD Format to: yyyy-MM-dd
            LocalDate dataUrodzenia = null;
            do {
                System.out.println("Podaj datę urodzenia:");
                String dataUr = scanner.nextLine();
                try{
                    dataUrodzenia = LocalDate.parse(dataUr);
                }catch (DateTimeParseException dtpe){ /*Powtórz jeśli jest exception*/}
            }while (dataUrodzenia == null);

            Student student = Student.builder()
                    .dataUrodzenia(dataUrodzenia)
                    .kierunekNauczania(kierunek)
                    .indeks(indeks)
                    .imie(imie)
                    .build();

            session.persist(student);

            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
}
