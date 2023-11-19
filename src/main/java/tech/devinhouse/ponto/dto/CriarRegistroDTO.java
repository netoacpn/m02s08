package tech.devinhouse.ponto.dto;

import jakarta.validation.constraints.NotNull;
import tech.devinhouse.ponto.module.TipoRegistro;

public record CriarRegistroDTO(@NotNull TipoRegistro tipoRegistro) {
}
