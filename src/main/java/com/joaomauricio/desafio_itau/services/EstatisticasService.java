package com.joaomauricio.desafio_itau.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstatisticasService {

    public final TransacaoService transacaoService;


    public EstatisticasService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    
}
