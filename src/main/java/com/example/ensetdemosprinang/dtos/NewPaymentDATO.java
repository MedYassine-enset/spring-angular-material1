package com.example.ensetdemosprinang.dtos;

import com.example.ensetdemosprinang.entities.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class NewPaymentDATO {

  private double amount;
  private PaymentType type;
  private LocalDate date;
  private String studentCode;
}
