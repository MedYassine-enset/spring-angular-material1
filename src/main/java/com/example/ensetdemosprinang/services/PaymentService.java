package com.example.ensetdemosprinang.services;

import com.example.ensetdemosprinang.dtos.NewPaymentDATO;
import com.example.ensetdemosprinang.entities.Payment;
import com.example.ensetdemosprinang.entities.PaymentStatus;
import com.example.ensetdemosprinang.entities.PaymentType;
import com.example.ensetdemosprinang.entities.Student;
import com.example.ensetdemosprinang.repository.PaymentRepository;
import com.example.ensetdemosprinang.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;
@Service
@Transactional
public class PaymentService {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    public PaymentService(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
    }
    public Payment savePayment(MultipartFile file, NewPaymentDATO newPaymentDATO) throws IOException {
        Path folderPath= Paths.get(System.getProperty("user.home"),"enset-data","payments");
        if (!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath= Paths.get(System.getProperty("user.home"),"enset-data","payments",fileName+".pdf");
        Files.copy(file.getInputStream(),filePath);
        Student student=studentRepository.findByCode(newPaymentDATO.getStudentCode());
        Payment payment = Payment.builder()
                .date(newPaymentDATO.getDate()).type(newPaymentDATO.getType()).student(student).amount(newPaymentDATO.getAmount()).file(filePath.toUri().toString()).status(PaymentStatus.CREATED)
                .build();
        return paymentRepository.save(payment);
    }
    public Payment updatePaymentsStatus(PaymentStatus status,Long id){
        Payment payment=paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);}
    public byte[] getPaymentsFile(Long paymentId) throws IOException {
        Payment payment = paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}
