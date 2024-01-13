package br.com.gerenciamentosimples.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private BigDecimal dinheiro;

    @Column(nullable = false)
    private BigDecimal cartaoCredito;

    @Column(nullable = false)
    private BigDecimal cartaoDebito;

    @Column(nullable = false)
    private BigDecimal pix;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate data;

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}