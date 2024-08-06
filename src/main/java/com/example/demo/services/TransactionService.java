package com.example.demo.services;

import com.example.demo.entity.Courses;
import com.example.demo.entity.Payments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public interface TransactionService {
    List<Payments> searchByIdOrName(String keyword);
    List<Payments> getAllPayment();
    Page<Payments> getAllListPayments(Pageable pageable);
    Page<Payments> getAllListPaymentsByDelete(Pageable pageable);
    Payments getById(UUID id);
    List<Payments> findPaymentsByType(int type);
    @Transactional
    void updateDeleteFlag(UUID transactionId, Integer deleteFlag);
    void deletePayments(Payments payments);
}
