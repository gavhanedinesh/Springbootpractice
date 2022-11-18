package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private int productId;

    private String productName;

    private String productArea;
    @JsonFormat( pattern = "dd/MM/yyyy",timezone = "Asia/kolkata")
    private Date productDate;

    private String productZone;




}
