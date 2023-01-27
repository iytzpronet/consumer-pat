package com.consumerpat.alelo.service;


import com.consumerpat.alelo.exception.RegrasException;
import com.consumerpat.alelo.model.Cartoes;
import com.consumerpat.alelo.model.Saque;
import com.consumerpat.alelo.model.TipoDeCartao;
import com.consumerpat.alelo.repository.CartaoRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartoesService {



    private final @NonNull
    CartaoRepository cartaoRepository;

    private final @NonNull
    SaqueService saqueService;



    public void adicionarSaldo (Long numeroDoCartao, Double saldo) throws RegrasException {
        if (saldo == null || saldo <= 0.0){

            throw new RegrasException("Saldo adicionado ao cartao: "+saldo);
        }

        Optional<Cartoes> opCartoes = cartaoRepository.findCartoesByNumeroDoCartao(numeroDoCartao);


        if (opCartoes.isEmpty()){

            throw new RegrasException("Cartao nao existe !");


        }


        Cartoes cartoes = opCartoes.get();
        cartoes.setSaldo(cartoes.getSaldo()+saldo);
        cartaoRepository.save(cartoes);

    }

    public Saque comprar (int tipoDoEstabelecimento, String nomeDoEstabelecimento, Long numeroDoCartao, Double valorDaCompra) throws RegrasException {

        Optional<Cartoes> opCartoes = cartaoRepository.findCartoesByNumeroDoCartao(numeroDoCartao);
        Saque extrato = null;


        if (opCartoes.isPresent()) {
            Cartoes cartoes = opCartoes.get();


            if (cartoes.getTipoCartao().getCodigo() != (tipoDoEstabelecimento)) {

                throw new RegrasException("Tipo do estabelecimento e diferente do tipo do cartao utilizado !");
            }

            if (cartoes.getSaldo() < valorDaCompra) {
                throw new RegrasException("Saldo insuficiente !!!");
            }


            cartoes.setSaldo(cartoes.getSaldo() - valorDaCompra);
            cartaoRepository.save(cartoes);

            extrato = saqueService.save(tipoDoEstabelecimento, nomeDoEstabelecimento, numeroDoCartao, valorDaCompra);

        }

        return extrato;
    }

     private boolean Combustivel(Cartoes cartoes) {


        return cartoes.getTipoCartao().equals(TipoDeCartao.COMBUSTIVEL);
     }



     private boolean Alimentacao(Cartoes cartoes){

        return cartoes.getTipoCartao().equals(TipoDeCartao.ALIMENTACAO);
     }


     private boolean Drogaria (Cartoes cartoes) {

        return cartoes.getTipoCartao().equals(TipoDeCartao.DROGARIA);
     }










}
