package com.example.ensetdemosprinang.web;

import com.example.ensetdemosprinang.entities.Payment;
import com.example.ensetdemosprinang.entities.PaymentStatus;
import com.example.ensetdemosprinang.entities.PaymentType;
import com.example.ensetdemosprinang.entities.Student;
import com.example.ensetdemosprinang.repository.PaymentRepository;
import com.example.ensetdemosprinang.repository.StudentRepository;
import com.example.ensetdemosprinang.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
public class PaymentRestController {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;
    private PaymentService paymentService;

    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PaymentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
    }
    @GetMapping(path = "/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }
    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> PaymentByStudents(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }
    @GetMapping(path = "/payments/byStatus")
    public List<Payment> PaymentByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }
    @GetMapping(path = "/payments/byType")
    public List<Payment> PaymentByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path = "/payment/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }
    @GetMapping (path = "/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/students/{code}")
    public Student getStudentsByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }
    @GetMapping("/studentsByProgramID")
    public List<Student> getStudentsByProgramId(String programId){
        return studentRepository.findByProgramId(programId);
    }
    @PutMapping("/payments/{id}")
    public Payment updatePaymentsStatus(@RequestParam PaymentStatus status,@PathVariable Long id){

        return this.paymentService.updatePaymentsStatus(status,id);
    }
    @PostMapping(path = "/payments",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  Payment savePayment(@RequestParam MultipartFile file, LocalDate date, double amount, PaymentType type,String studentCode) throws IOException {

        return this.paymentService.savePayment(file,date,amount,type,studentCode);
    }
    @GetMapping(value = "paymentFile/{paymentId}",produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentsFile(@PathVariable Long paymentId) throws IOException {
        return paymentService.getPaymentsFile(paymentId);
    }
}
