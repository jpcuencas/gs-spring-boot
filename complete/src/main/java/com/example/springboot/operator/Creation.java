package com.example.springboot.operator;

import com.example.springboot.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creation {


    private  static final Logger log = LoggerFactory.getLogger(Creation.class);

    public void justFrom() {
        Mono.just(new Person(1,"Juan", 33));
        //Flux.fromIterable(collection);

        //Observable.just(item);
    }

    public void empty() {
        // expresar flujos vacios
        Mono.empty();
        Flux.empty();

        //rxjava
        Observable.empty();
    }

    public void range() {
        // expresar un rango de datos
        Flux.range(0, 3)
                .doOnNext(i -> log.info("i = " + i))
                .subscribe();
    }

    public void repeat() {
        //repetir un flujo de datos

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Juan", 33));
        persons.add(new Person(2,"Cuenca", 33));
        persons.add(new Person(3,"Sevilla", 33));

        Flux<Person> fx = Flux.fromIterable(persons)
                .repeat(3);
        fx.subscribe(p->log.info(p.toString()));

        Mono.just(new Person(0,"Juan", 33))
                .repeat(3)
                .subscribe(p->log.info(p.toString()));
    }


}
