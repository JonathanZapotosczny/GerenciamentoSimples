package br.com.gerenciamentosimples.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaDto {

    @NotNull(message = "O campo DINHEIRO é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = true, message = "O DINHEIRO deve ser igual ou maior que zero!")
    private BigDecimal dinheiro;

    @NotNull(message = "O campo CARTÃO DE CRÉDITO é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = true, message = "O CARTÃO DE CRÉDITO deve ser igual ou maior que zero!")
    private BigDecimal cartaoCredito;

    @NotNull(message = "O campo CARTÃO DÉBITO é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = true, message = "O CARTÃO DE DÉBITO deve ser igual ou maior que zero!")
    private BigDecimal cartaoDebito;

    @NotNull(message = "O campo PIX é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = true, message = "O PIX deve ser igual ou maior que zero!")
    private BigDecimal pix;

    @NotNull(message = "O campo DATA é obrigatório!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}