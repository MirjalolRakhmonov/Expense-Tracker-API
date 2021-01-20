package com.mirjalolcode.expensetracker.rest;

import com.mirjalolcode.expensetracker.model.Transaction;
import com.mirjalolcode.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories/{categoryId}/transactions")
public class TransactionRestController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("")
    public ResponseEntity<List<Transaction>> getAllTransactions(HttpServletRequest request,
                                                                @PathVariable("categoryId") Integer categoryId){

        int userId=(Integer) request.getAttribute("userId");
        List<Transaction> transactions=transactionService.fetchAllTransactions(userId, categoryId);

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(HttpServletRequest request,
                                                          @PathVariable("transactionId") Integer transactionId,
                                                          @PathVariable("categoryId") Integer categoryId){

        int userId=(Integer) request.getAttribute("userId");
        Transaction transaction=transactionService.fetchTransactionById(userId, categoryId, transactionId);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Transaction> addTransaction(HttpServletRequest request,
                                                      @PathVariable("categoryId") Integer categoryId,
                                                      @RequestBody Map<String, Object> transactionMap) {

        int userId = (Integer) request.getAttribute("userId");
        Double amount = Double.valueOf(transactionMap.get("amount").toString());
        String note = (String) transactionMap.get("note");
        Long transactionDate = (Long) transactionMap.get("transactionDate");
        Transaction transaction = transactionService.addTransaction(userId, categoryId, amount, note, transactionDate);

        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
