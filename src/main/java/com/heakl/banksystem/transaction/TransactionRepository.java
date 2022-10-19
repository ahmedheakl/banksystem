package com.heakl.banksystem.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Modifying
    @Query(
            value = "INSERT INTO transaction (amount, receiver_id, sender_id) values (:amount, :receiver_id, :sender_id)",
            nativeQuery = true
    )
    @Transactional
    void saveTransaction(@Param("amount") float amount,
                         @Param("receiver_id") Long receiver_id,
                         @Param("sender_id") Long sender_id);

    @Query(
         value = "SELECT * FROM transaction t WHERE t.receiver_id=:id OR t.sender_id=:id",
         nativeQuery = true
    )
    List<Transaction> getUserTransactions(@Param(value = "id") Long id);
}
