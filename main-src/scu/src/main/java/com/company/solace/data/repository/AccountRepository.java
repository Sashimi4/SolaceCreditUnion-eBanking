package com.company.solace.data.repository;

import com.company.solace.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class containing custom SQL queries and full access towards the Account relation.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
