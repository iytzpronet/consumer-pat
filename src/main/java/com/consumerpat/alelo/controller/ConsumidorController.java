package com.consumerpat.alelo.controller;


import com.consumerpat.alelo.exception.RegrasException;
import com.consumerpat.alelo.model.Consumidor;
import com.consumerpat.alelo.repository.ConsumidorRepository;
import com.consumerpat.alelo.service.ConsumidorService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consumidor")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsumidorController {



    private final @NonNull ConsumidorService consumidorService;

    //Funcao Simples para busca direto no banco todos os consumidores.
    ConsumidorRepository repository;

    @GetMapping(value = "/todos")
    public ResponseEntity<List<Consumidor>> todos(){

        return ResponseEntity.ok(repository.findAll());
    }
    

    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value= "/{id}")
    public ResponseEntity<Consumidor> buscaPorId(@PathVariable Long id){
        Optional<Consumidor> consumidorOptional = consumidorService.buscaPorId(id);
        return consumidorOptional

                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/cadastrar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Consumidor> novoConsumidor(@RequestBody Consumidor consumidor){
        return ResponseEntity.ok(consumidorService.save(consumidor));
    }

    public ResponseEntity<Consumidor> atualizaConsumidor(@PathVariable @RequestBody Long id, Consumidor consumidor )throws RegrasException {

        Consumidor atualizaConsumidor = null;


        if (id.equals(consumidor.getId())){
            atualizaConsumidor = consumidorService.atualizar(consumidor);
        }

        if (atualizaConsumidor == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(atualizaConsumidor);

    }

}
