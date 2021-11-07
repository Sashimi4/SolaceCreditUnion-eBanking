package com.company.solace.data.repository;

import com.company.solace.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class containing custom SQL queries and full access towards the Customer relation.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
