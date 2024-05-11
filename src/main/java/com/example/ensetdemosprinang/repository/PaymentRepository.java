package com.example.ensetdemosprinang.repository;

import com.example.ensetdemosprinang.entities.Payment;
import com.example.ensetdemosprinang.entities.PaymentStatus;
import com.example.ensetdemosprinang.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
