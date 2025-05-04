package com.joaomauricio.desafio_itau.controller.dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(
        Double valor, OffsetDateTime dataHora
) {
}
