package net.javaguide.BankingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "accounts")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double balance;

}
