package com.example.ensetdemosprinang.dtos;

import com.example.ensetdemosprinang.entities.PaymentStatus;
import com.example.ensetdemosprinang.entities.PaymentType;
import com.example.ensetdemosprinang.entities.Student;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PymentDATO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;

}
