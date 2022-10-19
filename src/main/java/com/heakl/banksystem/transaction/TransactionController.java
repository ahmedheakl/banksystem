package com.heakl.banksystem.transaction;


import com.heakl.banksystem.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @GetMapping(path = "transactions")
    @CrossOrigin(origins = "*")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @PostMapping(path = "transactions")
    @CrossOrigin(origins = "*")
    public String addTransaction(@RequestBody TransactionPostModel transactionPostModel){
        System.out.println(transactionPostModel);
        transactionService.addTransaction(transactionPostModel);
        return "Sucess";
    }



    @RequestMapping(value = "userTransactions/{user}", method = RequestMethod.GET)
    public List<Transaction> getUserTransactions(@PathVariable(value = "user") Long userID){
        return transactionService.getUserTransactions(userID);
    }

}
