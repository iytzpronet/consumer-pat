package com.consumerpat.alelo.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Saque {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int tipoDoEstabelecimento;
    String nomeDoEstabelecimento;
    Long numeroDoCartao;
    Double valorDaCompra;



    
}
