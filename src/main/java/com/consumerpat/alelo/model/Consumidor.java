package com.consumerpat.alelo.model;


import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Data
@EqualsAndHashCode
public class Consumidor {



    // CRIO 3 atributos para a tabela no banco de dados.


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String name;
        private String CPF;



     //CRIAR UMA LISTA PARA ARMAZENAS OS CARTOES DESTE CONSUMIDOR.
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "consumidor_id")
    private Set<Cartoes> listaDeCartoes; 
        














        
    
}
