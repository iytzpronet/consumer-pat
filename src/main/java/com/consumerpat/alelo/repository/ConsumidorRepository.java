package com.consumerpat.alelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumerpat.alelo.model.Consumidor;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Long>{ 

    Optional<Consumidor> findById(Long id);

    //Optional<Consumidor> findByCPF(String CPF);


    

    
}
