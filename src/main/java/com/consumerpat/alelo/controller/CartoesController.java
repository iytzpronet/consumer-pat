package com.consumerpat.alelo.controller;


import com.consumerpat.alelo.exception.RegrasException;
import com.consumerpat.alelo.model.Cartoes;
import com.consumerpat.alelo.model.Saque;
import com.consumerpat.alelo.service.CartoesService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping("/cartoes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartoesController {

    private final @NonNull CartoesService cartoesService;



    @GetMapping(value = "/adicionaSaldo")
    public void adicionaSaldo (Long numeroDoCartao, Double saldo) throws RegrasException{
        cartoesService.adicionarSaldo(numeroDoCartao, saldo);
    }

    @ResponseBody
    @GetMapping(value = "/compra")
    public Saque compra (int tipoDoEstabelecimento, String nomeDoEstabelecimento, Long numeroDoCartao, Double valorDaCompra) throws RegrasException{
        return cartoesService.comprar(tipoDoEstabelecimento,nomeDoEstabelecimento,numeroDoCartao,valorDaCompra);
    }

}
