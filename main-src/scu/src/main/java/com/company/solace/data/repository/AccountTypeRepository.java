package com.company.solace.data.repository;

import com.company.solace.data.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class containing custom SQL queries and full access towards the Account type relation.
 */
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
