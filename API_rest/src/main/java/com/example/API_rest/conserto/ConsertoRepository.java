package com.example.API_rest.conserto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    Collection<Conserto> findAllByAtivoTrue();
}
