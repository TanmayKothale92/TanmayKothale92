package net.javaguide.BankingApp.repository;

import net.javaguide.BankingApp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
