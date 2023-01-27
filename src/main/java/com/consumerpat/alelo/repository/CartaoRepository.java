package com.consumerpat.alelo.repository;



import java.util.Optional;

import com.consumerpat.alelo.model.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.consumerpat.alelo.model.Cartoes;
import org.springframework.stereotype.Repository;


@Repository
public interface CartaoRepository extends JpaRepository<Cartoes, Long> {

   Optional<Cartoes> findById(Long id);

   Optional<Cartoes> findCartoesByNumeroDoCartao(Long numeroDoCartao);


    /*
                A classe java.util.Optional é uma classe de contêiner presente a partir do Java 8 que fornece um meio seguro de lidar com valores nulos. Ela é usada para encapsular um valor que pode ou não estar presente. Ao invés de retornar null, um método pode retornar um objeto Optional,  indicando que o valor pode ou não estar presente. Isso ajuda a evitar exceções de NullPointerException e fornece uma maneira concisa de lidar com valores nulos. 
    
    
    */
    
}
