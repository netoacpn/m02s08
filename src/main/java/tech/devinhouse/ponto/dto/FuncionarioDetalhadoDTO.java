package tech.devinhouse.ponto.dto;

import tech.devinhouse.ponto.module.Funcionario;

import java.util.List;

public record FuncionarioDetalhadoDTO(Integer id, String nome, String cargo, float salario, List<RegistroDTO> registro) {
    public FuncionarioDetalhadoDTO(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCargo(), funcionario.getSalario(), funcionario.getRegistro());
    }
}
