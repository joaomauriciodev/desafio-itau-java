package com.joaomauricio.desafio_itau.controller.dtos;

public record EstatisticasResponseDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
