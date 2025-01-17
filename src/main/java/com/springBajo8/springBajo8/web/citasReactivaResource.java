package com.springBajo8.springBajo8.web;


import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
public class citasReactivaResource {

    @Autowired
    private IcitasReactivaService icitasReactivaService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.save(citasDTOReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
        return this.icitasReactivaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<citasDTOReactiva> findAll() {
        return this.icitasReactivaService.findAll();
    }

    @PutMapping("/citasReactivas/cancelarCita/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> cancelarCita(@PathVariable("id") String id, @RequestBody citasDTOReactiva cita){
        return this.icitasReactivaService.cancelarCita(id, cita)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/citasReactivas/{fechaReservaCita}/byFecha")
    private Flux<citasDTOReactiva> findByFecha(@PathVariable("fechaReservaCita") String fecha) {
        return this.icitasReactivaService.findByFecha(fecha);
    }

    @GetMapping("/citasReactivas/{horaReservaCita}/byHora")
    private Flux<citasDTOReactiva> findByHora(@PathVariable("horaReservaCita") String hora) {
        return this.icitasReactivaService.findByHora(hora);
    }

    @GetMapping("/citasReactivas/{idPaciente}/medico")
    private Flux<String> consultarMedico(@PathVariable("idPaciente") String idPaciente){
        return icitasReactivaService.consultarMedico(idPaciente);
    }

    @GetMapping("/citasReactivas/{idPaciente}/padecimientos")
    private  Flux<String> consultarPadecimientos(@PathVariable("idPaciente") String idPaciente){
        return icitasReactivaService.consultarPadecimientos(idPaciente);
    }
}
