package com.tantely.freshfruitmanager.repositories;

import com.tantely.freshfruitmanager.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
