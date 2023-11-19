package tech.devinhouse.ponto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import tech.devinhouse.ponto.module.Registro;
import tech.devinhouse.ponto.module.TipoRegistro;

import java.time.LocalDateTime;

public record RegistroDTO (Integer id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")LocalDateTime horaRegistro, TipoRegistro tipoRegistro){
    public RegistroDTO(Registro registro){
        this(registro.getId(), registro.getHoraRegistro(), registro.getTipoRegistro());
    }
}
