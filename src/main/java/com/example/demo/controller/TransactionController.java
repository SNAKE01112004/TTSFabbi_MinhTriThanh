package com.example.demo.controller;

import com.example.demo.entity.Payments;
import com.example.demo.services.TransactionService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    UserService userService;

    @GetMapping()
    private String view_Home(Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);

        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Payments> paymentsPage = transactionService.getAllListPayments(pageable);

        int totalElement = (int) paymentsPage.getTotalElements();
        int begin = currentPage * pageSize + 1;
        int end = Math.min((currentPage + 1) * pageSize, totalElement);

        model.addAttribute("totalPage", paymentsPage.getTotalPages());
        model.addAttribute("begin", begin);
        model.addAttribute("number", currentPage);
        model.addAttribute("end", end);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("paymentsPage", paymentsPage.getContent());
        model.addAttribute("listUser", userService.getAllUser());
        return "Transaction/transaction";
    }

    @GetMapping("/search")
    private String searchCodeOrName(@RequestParam("keyword") String keyword, Model model) {
        List<Payments> listTransaction;
        if (keyword == null || keyword.trim().isEmpty()) {
            listTransaction = transactionService.getAllPayment();
            model.addAttribute("listTransaction", listTransaction);
        } else {
            listTransaction = transactionService.searchByIdOrName(keyword);
            model.addAttribute("listTransaction", listTransaction);
        }
        if (listTransaction.isEmpty()) {
            System.out.println("No data found for usersCode: " + keyword);
            model.addAttribute("emptyData", "Không có dữ liệu");
        } else {
            System.out.println("Found " + listTransaction.size() + " records for usersCode: " + keyword);
        }
        return "/Transaction/transaction";
    }

    @GetMapping("/view_detail/{transactionId}")
    private String view_DetailTransaction(@PathVariable("transactionId") UUID transactionId, Model model) {
        Payments payments = transactionService.getById(transactionId);
        model.addAttribute("payments", payments);
        model.addAttribute("listUser", userService.getAllUser());

        return "Transaction/detailTransaction";
    }

    @GetMapping("/filter")
    public String filterPayments(@RequestParam("type") int type,
                                 Model model) {
        List<Payments> paymentsList = transactionService.findPaymentsByType(type);
        model.addAttribute("listTransaction", paymentsList);
        model.addAttribute("listUser", userService.getAllUser());
        model.addAttribute("emptyData", paymentsList.isEmpty() ? "Không có dữ liệu" : null);
        return "/Transaction/transaction";
    }

    @PostMapping("/update_delete_flag/{transactionId}")
    private String updateDeleteFlag(@PathVariable("transactionId") UUID transactionId,
                                    @RequestParam("deleteFlag") Integer deleteFlag,
                                    Model model) {
        Payments payments = transactionService.getById(transactionId);
        if(payments != null) {
            transactionService.updateDeleteFlag(transactionId, deleteFlag);
        }
        return "/Transaction/transaction";
    }

    @GetMapping("delete/{transactionId}")
    private String delete(@PathVariable("transactionId") UUID transactionId) {
        Payments payments = transactionService.getById(transactionId);
        transactionService.deletePayments(payments);
        return "redirect:/transactions";
    }


    @GetMapping("/view_CreateInformation")
    private String view_CreateInformation() {
        return "Transaction/informationTransaction";
    }

    @GetMapping("/view_CreateInformation2")
    private String view_CreateInformation2() {
        return "Transaction/informationTransaction2";
    }
}
