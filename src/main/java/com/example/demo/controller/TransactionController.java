package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @GetMapping()
    private String view_Home() {
        return "Transaction/transaction";
    }

    @GetMapping("/view_detail")
    private String view_DetailTransaction() {
        return "Transaction/detailTransaction";
    }
}
