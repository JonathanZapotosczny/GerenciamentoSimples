package br.com.gerenciamentosimples.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    @NotBlank(message = "O campo NOME é obrigatório!")
    @Length(min = 2, max = 100, message = "O campo NOME deverá ter no mínimo {min} e no máximo {max} caracteres!")
    private String nome;
}
