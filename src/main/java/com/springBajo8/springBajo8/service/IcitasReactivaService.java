package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.HistorialPaciente;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

public interface IcitasReactivaService {
    Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva);

    Mono<citasDTOReactiva> delete(String id);

    Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva);

    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);

    Flux<citasDTOReactiva> findAll();

    Mono<citasDTOReactiva> findById(String id);

    Flux<citasDTOReactiva> findByFecha(String fecha);

    Flux<citasDTOReactiva> findByHora(String hora);

    Mono<citasDTOReactiva> cancelarCita(String id, citasDTOReactiva cita);

    Flux<String> consultarMedico(String idPaciente);

    Flux<String> consultarPadecimientos(String idPaciente);
}
