package com.consumerpat.alelo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumerpat.alelo.model.Saque;
import org.springframework.stereotype.Repository;


@Repository
public interface SaqueRepository extends JpaRepository<Saque, Long> {



    //Optional<Saque> findByTipoDoEstabelecimento(int tipoDoEstabelecimento);

    //Optional<Saque> findByNomeDoEstabelecimento(String nomeDoEstabelecimento);


        
}
