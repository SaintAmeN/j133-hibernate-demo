package pl.sda.hibernate.demo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-demo
 * @created 26.11.2022
 *
 * Klasa POJO => Plain Old Java Object
 * Klasa która posiada:
 *  - prywatne pola
 *  - gettery, settery,
 *  - pusty konstruktor
 */

@Data
@Entity
@NoArgsConstructor
public class Student {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;                                                        // `id`                     INT PRIMARY KEY AUTO_INCREMENT,

    @Column(nullable = false)
    private String imie;                                                    // `imie`                   VARCHAR(255) NOT NULL,
    private LocalDate dataUrodzenia;                                        // `data_urodzenia`         DATE,
    private String kierunekNauczania;                                       // `kierunek_nauczania`     VARCHAR(255),
    private String indeks; // index jest słowem zabronionym przez mysql     // `indeks`                 VARCHAR(255)

//    private int wiek;                                                       // `wiek`                   INT NOT NULL,
//    private Integer wiek;                                                   // `wiek`                   INT,
}
