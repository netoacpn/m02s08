package tech.devinhouse.ponto.module;

import jakarta.persistence.*;

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
    private List<Registro> registers;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String cargo, float salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }


}
