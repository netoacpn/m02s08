package tech.devinhouse.ponto.module;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "REGISTROS")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDateTime horaRegistro;
    @Enumerated(EnumType.STRING)
    private TipoRegistro tipoRegistro;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false, referencedColumnName = "id")
    private Funcionario funcionario;

    public Registro() {
    }

    public Registro(Integer id, LocalDateTime horaRegistro, TipoRegistro tipoRegistro, Funcionario funcionario) {
        this.id = id;
        this.horaRegistro = horaRegistro;
        this.tipoRegistro = tipoRegistro;
        this.funcionario = funcionario;
    }
}
