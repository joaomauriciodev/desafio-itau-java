package com.joaomauricio.desafio_itau.services;

import com.joaomauricio.desafio_itau.controller.dtos.TransacaoRequestDTO;
import com.joaomauricio.desafio_itau.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacao(TransacaoRequestDTO dto) {
        log.info("Inicio do processo de gravar transacoes");
        if (dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maior que a data e hora atual");
            throw new UnprocessableEntity("Data e hora maior que a data e hora atual");
        }

        if (dto.valor() < 0){
            log.error("Valor não pode ser menor que zero");
            throw new UnprocessableEntity("Valor não pode ser menor que zero");
        }

        listaTransacoes.add(dto);
    }

    public void limparTransacoes(){
        listaTransacoes.clear();
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca){
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo))
                .toList();
    }
}
