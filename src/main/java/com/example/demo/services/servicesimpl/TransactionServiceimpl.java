package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Payments;
import com.example.demo.responsitory.TransactionRepository;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Payments> getAllPayment() {
        return transactionRepository.findAll();
    }

    @Override
    public Page<Payments> getAllListPayments(Pageable pageable) {
        return transactionRepository.findAllPayments(pageable);
    }

    @Override
    public Page<Payments> getAllListPaymentsByDelete(Pageable pageable) {
        return transactionRepository.getPaymentsByDeletedFlag(pageable);
    }

    @Override
    public List<Payments> searchByIdOrName(String keyword) {
        return transactionRepository.findByTransactionCodeOrName(keyword);
    }

    @Override
    public Payments getById(UUID id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Payments> findPaymentsByType(int type) {
        return transactionRepository.findPaymentsByType(type);
    }

    @Override
    @Transactional
    public void updateDeleteFlag(UUID transactionId, Integer deleteFlag) {
        transactionRepository.updateDeletedFlag(transactionId, deleteFlag);
    }

    @Override
    public void deletePayments(Payments payments) {
        transactionRepository.delete(payments);
    }
}
