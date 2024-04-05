package ru.kpfu.itis.paramonov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "processing_status")
@Getter
@NoArgsConstructor
public class ProcessingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", length = 15)
    private String value;

    @OneToMany
    @JoinColumn(name = "processing_status")
    private List<Transaction> transactionList;

}
