package ru.kpfu.itis.paramonov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_name", length = 50)
    private String name;

    @Column(name = "card_last_digits", length = 4)
    private String cardLastDigits;

    @OneToMany
    @JoinColumn(name = "client")
    private List<Transaction> transactionList;
}
