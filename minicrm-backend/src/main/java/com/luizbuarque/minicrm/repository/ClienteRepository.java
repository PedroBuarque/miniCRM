package com.luizbuarque.minicrm.repository;

import com.luizbuarque.minicrm.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Additional query methods can be defined here if needed.
}