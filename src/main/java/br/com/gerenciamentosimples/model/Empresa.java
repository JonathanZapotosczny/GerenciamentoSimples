package br.com.gerenciamentosimples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = true, unique = true, length = 14)
    private String cnpj;

    @Column(nullable = true, length = 100)
    private String vendedor;

    @Column(nullable = true, length = 11)
    private String telefone;
}
