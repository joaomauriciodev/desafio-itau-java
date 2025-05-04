package com.joaomauricio.desafio_itau.controller.dtos;

public record EstatisticasResponseDTO(
        Integer count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
