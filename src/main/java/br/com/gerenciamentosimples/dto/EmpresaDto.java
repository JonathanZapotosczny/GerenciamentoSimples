package br.com.gerenciamentosimples.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {

    @NotBlank(message = "O campo NOME é obrigatório!")
    private String nome;

    @CNPJ
    private String cnpj;

    @Length(min = 3, max = 100, message = "O campo VENDEDOR deverá ter no mínimo {min} e no máximo {max} caracteres!")
    private String vendedor;

    @Length(min = 10, max = 11, message = "O campo TELEFONE deverá ter no mínimo {min} e no máximo {max} digitos!")
    private String telefone;

    
}
