package com.jvmchain.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoServices {
    public Flux<String> fruitsFlux(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    public Flux<String> fruitsFluxMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitsFluxFIlter(int number){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(s-> s.length() > number);
    }

    public Flux<String> fruitsFluxFIlterMap(int number){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(s-> s.length() > number)
                .map(String::toUpperCase);
    }

    public Mono<String> fruitsMono(){
        return Mono.just("Mango").log();
    }


    public static void main(String[] args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
        fluxAndMonoServices.fruitsFlux()
                .subscribe(e-> System.out.println("E : "+e));

        fluxAndMonoServices.fruitsMono().subscribe(
                s -> System.out.println("s = "+s)
        );
    }
}
