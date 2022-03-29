package com.springBajo8.springBajo8;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class CitasReactivaServiceTest {

    @Autowired
    private IcitasReactivaService service;

    @Test
    void buscarPorIdPaciente(){
        citasDTOReactiva cita = new citasDTOReactiva();
        cita.setIdPaciente("1");
        cita.setNombrePaciente("Roberto");
        cita.setNombreMedico("Julian");
        cita.setHoraReservaCita("08:00 am");

        Flux<citasDTOReactiva> paciente = service.findByIdPaciente("1");
        StepVerifier.create(paciente).expectNext(cita).verifyComplete();
    }

    @Test
    void buscarPorId(){
        citasDTOReactiva cita = new citasDTOReactiva();
        cita.setId("yyuu33");
        cita.setIdPaciente("1");
        cita.setNombrePaciente("Roberto");
        cita.setNombreMedico("Julian");
        cita.setHoraReservaCita("08:00 am");
        cita.setEstadoReservaCita("Activa");

        Mono<citasDTOReactiva> citas = service.findById("yyuu33");
        StepVerifier.create(citas).verifyComplete();
    }

    @Test
    void buscarPorHora(){

    }
}
