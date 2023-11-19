package tech.devinhouse.ponto.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.devinhouse.ponto.dto.*;
import tech.devinhouse.ponto.module.Funcionario;
import tech.devinhouse.ponto.module.Registro;
import tech.devinhouse.ponto.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioDTO create(CriarFuncionarioDTO body) {
        Funcionario novoFuncionario = this.funcionarioRepository.save(new Funcionario(body));
        return new FuncionarioDTO(novoFuncionario);
    }

    @Transactional
    public RegistroDTO criarRegistro(Integer id, @Valid CriarRegistroDTO body) {
        Funcionario funcionario = this.funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));

        Registro registro = new Registro(body.type(), funcionario);
        funcionario.getRegistro().add(registro);

        return new RegistroDTO(registro);
    }

    public Page<FuncionarioDTO> listAll(Pageable pageable) {
        return this.funcionarioRepository.findAll(pageable).map(FuncionarioDTO::new);
    }

    public FuncionarioDetalhadoDTO getEmployee(Integer id) {
        return this.funcionarioRepository.findById(id).map(FuncionarioDetalhadoDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Id de funcionário não encontrado: " + id));
    }
}
