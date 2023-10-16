package com.checkerslab.electricdevice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ELTC_DVC_TBL")
@Data
public class ElectricDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uniqueId;

    private String deviceId;
    private String paymentId;
    private LocalDateTime creationDateTime;
}
