package com.heakl.banksystem.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT c.id, c.name, c.email, c.current_balance, max(t.time_stamp) as lastTransaction FROM customers c LEFT JOIN transaction t ON  c.id = t.receiver_id OR c.id = t.sender_id GROUP BY c.id, c.name, c.email, c.current_balance;",
        nativeQuery = true
    )
    List<Customer> getAllCustomersWithDate();

    @Override
    Optional<Customer> findById(Long aLong);

    Optional<Customer> findByName(String name);

    @Modifying
    @Query(
            value = "UPDATE customers c SET c.current_balance = :new_balance WHERE c.id = :id",
            nativeQuery = true
    )
    @Transactional
    void updateCustomerCurrentBalance(@Param(value = "id") Long id, @Param(value = "new_balance") float new_balance);

}
