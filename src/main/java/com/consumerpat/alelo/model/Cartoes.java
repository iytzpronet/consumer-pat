package com.consumerpat.alelo.model;

import javax.annotation.Generated;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Cartoes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long numeroDoCartao;
    private Double saldo;


    @Enumerated(EnumType.STRING)
    private TipoDeCartao tipoCartao;


    



    
}
