package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.domain.dto.DailySales;
import com.gabriel.springrestspecialist.domain.filter.DailySalesFilter;
import com.gabriel.springrestspecialist.domain.service.DailySalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/statistics")
@RequiredArgsConstructor
public class StatisticController {
    private final DailySalesService dailySalesService;

    @GetMapping("daily-sales")
    public ResponseEntity<List<DailySales>> getDailySales(DailySalesFilter filter) {
        var response = dailySalesService.getDailySales(filter);
        return ok(response);
    }
}
