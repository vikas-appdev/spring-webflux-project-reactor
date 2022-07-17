package com.jvmchain.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();


    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsMono() {
        var fruitsMono = fluxAndMonoServices.fruitsMono();
        StepVerifier.create(fruitsMono)
                .expectNext("Mango")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fruitFlux)
                .expectNext("MANGO", "ORANGE", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFIlter() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxFIlter(5).log();
        StepVerifier.create(fruitFlux)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFIlterMap() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxFIlterMap(5).log();
        StepVerifier.create(fruitFlux)
                .expectNext("ORANGE", "BANANA")
                .verifyComplete();
    }
}