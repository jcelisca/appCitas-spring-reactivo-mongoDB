package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Optional;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }


    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

    @Override
    public Flux<citasDTOReactiva> findByFecha(String fecha) {
        return IcitasReactivaRepository.findByFechaReservaCita(fecha);
    }

    @Override
    public Flux<citasDTOReactiva> findByHora(String hora) {
        return IcitasReactivaRepository.findByHoraReservaCita(hora);
    }

    @Override
    public Mono<citasDTOReactiva> cancelarCita(String id, citasDTOReactiva cita){
        return IcitasReactivaRepository.findById(id)
                .flatMap(cita1 ->{
                    cita.setId(id);
                    cita.setIdPaciente(cita1.getIdPaciente());
                    cita.setNombrePaciente(cita1.getNombrePaciente());
                    cita.setApellidosPaciente(cita1.getApellidosPaciente());
                    cita.setNombreMedico(cita1.getNombreMedico());
                    cita.setApellidosMedico(cita1.getApellidosMedico());
                    cita.setHoraReservaCita(cita1.getHoraReservaCita());
                    cita.setFechaReservaCita(cita1.getFechaReservaCita());
                    cita.setEstadoReservaCita(cita.getEstadoReservaCita());
                    return save(cita);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<String> consultarMedico(String idPaciente) {
        return IcitasReactivaRepository.findByIdPaciente(idPaciente)
                .flatMap(cita -> Mono.just("Nombre médico: "+cita.getNombreMedico()+" "+cita.getApellidosMedico()+
                            "\nhora de la cita: "+cita.getHoraReservaCita()))
                .switchIfEmpty(Mono.empty());

    }
}
