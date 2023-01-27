package com.consumerpat.alelo.model;

import lombok.Getter;

@Getter
public enum TipoDeCartao {

     //DEFINO OS CODIGOS DE CADA TIPO DE CARTAO
    DROGARIA(100),ALIMENTACAO(200),COMBUSTIVEL(300);

    //CRIO UMA VARIAVEL CODIGO  E ATRIBUO ELA AO TIPO DE CARTAO.
    int codigo;



    //CONSTRUTOR
    TipoDeCartao(int codigo){
        this.codigo = codigo;
    }
    
    
}
