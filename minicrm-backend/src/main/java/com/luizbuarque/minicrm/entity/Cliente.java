package com.luizbuarque.minicrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.luizbuarque.minicrm.util.RandomNumber;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @RandomNumber  // Use your custom annotation here
    private Long id;
    
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    
    @Column(nullable = false)
    private String sexo;
    
    @Column(name = "nome_mae", nullable = false)
    private String nomeMae;
    
    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;
}