package com.heakl.banksystem.transaction;

import com.heakl.banksystem.customer.Customer;
import com.heakl.banksystem.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void addTransaction(TransactionPostModel trans) {
        Customer receiverCustomer = customerRepository.findByName(trans.getReceiverName()).orElseThrow(() -> new IllegalStateException("Receiver not found!"));
        Customer senderCustomer = customerRepository.findByName(trans.getSenderName()).orElseThrow(() -> new IllegalStateException("Sender not found!"));
        float newSenderBalance = senderCustomer.getCurrentBalance() - trans.getAmount();
        float newReceiverBalance = receiverCustomer.getCurrentBalance() + trans.getAmount();
        customerRepository.updateCustomerCurrentBalance(receiverCustomer.getId(), newReceiverBalance);
        customerRepository.updateCustomerCurrentBalance(senderCustomer.getId(), newSenderBalance);
        transactionRepository.saveTransaction(trans.getAmount(), receiverCustomer.getId(), senderCustomer.getId());
    }

    public List<Transaction> getUserTransactions(Long ID){
        return transactionRepository.getUserTransactions(ID);
    }
}
