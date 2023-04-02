package com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.dao;

import com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    Integer save(Customer customer);
    List<Customer> findAll();
    Page<Customer> findAllByPage(Pageable page);
    List<Customer> findAllBySort(Sort sort);
    Page<Customer> findAllBySortAndPage(Pageable page);
    Optional<Customer> findById(String id);
    Integer update(Customer customer);
    Integer delete(String id);
}
