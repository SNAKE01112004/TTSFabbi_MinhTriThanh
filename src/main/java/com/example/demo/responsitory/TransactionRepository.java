package com.example.demo.responsitory;

import com.example.demo.entity.Payments;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Repository
public interface TransactionRepository extends JpaRepository<Payments, UUID> {
    @Query("SELECT p FROM Payments p")
    Page<Payments> findAllPayments(Pageable pageable);

    @Query("SELECT c FROM Payments c WHERE c.usersId.usersCode LIKE %:keyword% OR c.usersId.usersName LIKE %:keyword%")
    List<Payments> findByTransactionCodeOrName(@Param("keyword") String keyword);

    @Query("SELECT p FROM Payments p WHERE p.paymentStatus = :type AND p.deletedFlag = 0")
    List<Payments> findPaymentsByType(@Param("type") int type);

    @Query(value = "SELECT p FROM Payments p WHERE p.deletedFlag = 0")
    Page<Payments> getPaymentsByDeletedFlag(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Payments c SET c.deletedFlag = :deletedFlag WHERE c.transactionId = :transactionId")
    Integer updateDeletedFlag(@Param("transactionId") UUID transactionId, @Param("deletedFlag") Integer deletedFlag);
}