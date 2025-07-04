package com.gabriel.springrestspecialist.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class DailySales {
    private Date date;
    private Long sales;
    private BigDecimal earnings;
}
