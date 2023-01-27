package com.consumerpat.alelo.service;


import com.consumerpat.alelo.Util.ListaUtil;
import com.consumerpat.alelo.exception.RegrasException;
import com.consumerpat.alelo.model.Cartoes;
import com.consumerpat.alelo.model.Consumidor;
import com.consumerpat.alelo.repository.ConsumidorRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.consumerpat.alelo.Util.ListaUtil.nonNull;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsumidorService {


    private final @NonNull ConsumidorRepository consumidorRepository;

    public Consumidor save(Consumidor consumidor){
        return consumidorRepository.save(consumidor);
    }

    public Page<Consumidor> buscaTodos(Pageable todos){
        return consumidorRepository.findAll(todos);
    }

    public Consumidor atualizar(Consumidor consumidor)throws RegrasException{
        Optional<Consumidor> opConsumidor = consumidorRepository.findById(consumidor.getId());

        if(opConsumidor.isEmpty()){
            throw new RegrasException("Nenhum cadastro encontrado com este ID: "+consumidor.getId());
        }

        Consumidor consumidorContent = opConsumidor.get();

        if (SaldoAlterado(consumidor.getListaDeCartoes(), consumidorContent.getListaDeCartoes())){
            throw new RegrasException("Nao é possivel alterar o valor do cartao deste consumidor ! "+ consumidor.getId());
        }

        return consumidorRepository.save(consumidor);


    }

    private boolean SaldoAlterado(Set<Cartoes> listaDeCartoes, Set<Cartoes> listaDeCartoesContent){

        List<Double> todoSaldo = nonNull(listaDeCartoes)
                .stream()
                .map(Cartoes::getSaldo)
                .collect(Collectors.toList());


        List<Double> todoSaldoContent = ListaUtil
                .nonNull(listaDeCartoesContent)
                .stream()
                .map(Cartoes::getSaldo)
                .collect(Collectors.toList());


        return !todoSaldo.equals(todoSaldoContent);


    }

    public Optional<Consumidor>  buscaPorId(Long id){

        return consumidorRepository.findById(id);
    }


}
