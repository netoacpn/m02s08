package tech.devinhouse.ponto.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.ponto.dto.*;
import tech.devinhouse.ponto.service.FuncionarioService;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;


    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<Page<FuncionarioDTO>> list(@PageableDefault(size = 12, sort = "nome") Pageable pageable) {
        Page<FuncionarioDTO> response = this.funcionarioService.listAll((org.springframework.data.domain.Pageable) pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDetalhadoDTO> getById(@PathVariable("id") Integer id) {
        FuncionarioDetalhadoDTO response = this.funcionarioService.getEmployee(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody @Valid CriarFuncionarioDTO body) {
        FuncionarioDTO response = this.funcionarioService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{id}/registros")
    public ResponseEntity<RegistroDTO> createPointRecord(@PathVariable("id") Integer id, @RequestBody @Valid CriarRegistroDTO body) {
        RegistroDTO response = this.funcionarioService.criarRegistro(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
