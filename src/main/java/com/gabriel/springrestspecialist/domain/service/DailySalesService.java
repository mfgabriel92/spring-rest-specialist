package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.dto.DailySales;
import com.gabriel.springrestspecialist.domain.filter.DailySalesFilter;

import java.util.List;

public interface DailySalesService {
    List<DailySales> getDailySales(DailySalesFilter filter);
}
