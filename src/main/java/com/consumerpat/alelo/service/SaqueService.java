package com.consumerpat.alelo.service;


import com.consumerpat.alelo.model.Saque;
import com.consumerpat.alelo.repository.SaqueRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SaqueService {


    private final @NonNull
    SaqueRepository saqueRepository;


    public Saque save(int tipoDoEstabelecimento,String nomeDoEstabelecimento,Long  numeroDoCartao,Double valorDaCompra){


    Saque extrato = Saque.builder()
            .nomeDoEstabelecimento(nomeDoEstabelecimento)
            .tipoDoEstabelecimento(tipoDoEstabelecimento)
            .numeroDoCartao(numeroDoCartao)
            .valorDaCompra(valorDaCompra)
            .build();


            return saqueRepository.save(extrato);
    }


}
