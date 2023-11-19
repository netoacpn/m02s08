package tech.devinhouse.ponto.dto;

import jakarta.validation.constraints.NotBlank;
import tech.devinhouse.ponto.module.Funcionario;

public record FuncionarioDTO (Integer id, String nome, String cargo, float salario) {
    public FuncionarioDTO (Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCargo(), funcionario.getSalario());
    }
}
