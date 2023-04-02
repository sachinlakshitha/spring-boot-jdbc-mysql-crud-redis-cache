package com.sachinlakshitha.springbootjdbcmysqlcrudrediscache;

import com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.dto.CustomerDto;
import com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
@EnableCaching
@Slf4j
public class SpringBootJdbcMysqlCrudRedisCacheApplication implements CommandLineRunner {
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcMysqlCrudRedisCacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("[SAVE]");
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(UUID.randomUUID().toString());
		customerDto.setName("Sachin Lakshitha");
		customerDto.setEmail("sachin@email.com");
		customerDto.setCreatedTime(new Date());
		CustomerDto savedCustomer = customerService.save(customerDto);

		if (savedCustomer != null) {
			log.info("Customer [{}] saved successfully", customerDto.getName());
		} else {
			log.info("Customer [{}] saving failed", customerDto.getName());
		}

		log.info("[FIND_BY_ID] {}", customerService.findById(customerDto.getId()));

		log.info("[FIND_ALL] {}", customerService.findAll());

		// Pagination example with page size 10
		log.info("[FIND_ALL_BY_PAGINATION] {}", customerService.findAllByPage(PageRequest.of(0,10)));

		// Sort by name in ascending order
		log.info("[FIND_ALL_BY_SORT] {}", customerService.findAllBySort(Sort.by(Sort.Direction.fromString("ASC"), "NAME")));

		// Sort by name in descending order and pagination with page size 10
		log.info("[FIND_ALL_BY_SORT_AND_PAGINATION] {}", customerService.findAllBySortAndPage(PageRequest.of(0,10, Sort.by(Sort.Direction.fromString("DESC"), "NAME"))));

		log.info("[UPDATE]");
		customerDto.setName("Sachin Lakshitha (Updated)");
		CustomerDto updatedCustomer = customerService.update(customerDto);

		if (updatedCustomer != null) {
			log.info("Customer [{}] updated successfully", customerDto.getName());
		} else {
			log.info("Customer [{}] updating failed", customerDto.getName());
		}

		log.info("[FIND_BY_ID] {}", customerService.findById(customerDto.getId()));

		log.info("[DELETE]");
		customerService.delete(customerDto);
		log.info("Customer [{}] deleted successfully", customerDto.getName());

		log.info("[FIND_ALL] {}", customerService.findAll());
	}
}
