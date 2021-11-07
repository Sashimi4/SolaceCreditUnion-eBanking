package com.company.solace.data.repository;

import com.company.solace.data.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class containing custom SQL queries and full access towards the Credit Card relation.
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

}
