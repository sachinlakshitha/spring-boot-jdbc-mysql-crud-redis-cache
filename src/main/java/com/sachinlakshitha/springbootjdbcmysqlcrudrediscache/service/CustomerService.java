package com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.service;

import com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.dto.CustomerDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);
    List<CustomerDto> findAll();
    List<CustomerDto> findAllByPage(Pageable page);
    List<CustomerDto> findAllBySort(Sort sort);
    List<CustomerDto> findAllBySortAndPage(Pageable page);
    CustomerDto findById(String id);
    CustomerDto update(CustomerDto customerDto);
    CustomerDto delete(CustomerDto customerDto);
}
