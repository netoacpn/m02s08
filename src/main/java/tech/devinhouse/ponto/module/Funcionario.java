package tech.devinhouse.ponto.module;

import jakarta.persistence.*;
import tech.devinhouse.ponto.dto.CriarFuncionarioDTO;
import tech.devinhouse.ponto.dto.RegistroDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private float salario;

    @OneToMany(mappedBy = "employee", orphanRemoval = true,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Registro> registros = new ArrayList<>();

    public Funcionario(CriarFuncionarioDTO body) {
    }

    public Funcionario(Integer id, String nome, String cargo, float salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSalario() {
        return salario;
    }

    public List<RegistroDTO> getRegistro() {
        return this.registros.stream().map(RegistroDTO::new).toList();
    }
}
