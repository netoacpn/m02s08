package tech.devinhouse.ponto.dto;

import jakarta.validation.constraints.NotBlank;

public record CriarFuncionarioDTO (@NotBlank String nome, @NotBlank String cargo, @NotBlank float salario){

}
