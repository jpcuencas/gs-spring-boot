package com.example.springboot.operator;

import com.example.springboot.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformation {

    private  static final Logger log = LoggerFactory.getLogger(Transformation.class);

    public void map() {
        //repetir un flujo de datos

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 33));
        persons.add(new Person(3, "Sevilla", 33));
        /**
        Flux.fromIterable(persons)
                .map(p-> {
                    p.setAge(p.getAge() + 10);
                    return p;
                })
                .subscribe(p->log.info(p.toString()));
        /**/
        Flux<Integer> fx = Flux.range(0,10);
        Flux<Integer> fx2 = fx.map(x-> x+10);
        fx2.subscribe(p->log.info(p.toString()));
    }

    public void flatMap() {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 33));
        persons.add(new Person(3, "Sevilla", 33));

         Flux.fromIterable(persons)
                 .flatMap(p-> {
                     p.setAge(p.getAge() + 10);
                     return Mono.just(p);
                 }).subscribe(p->log.info(p.toString()));
    }

    public void groupBy() {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 33));
        persons.add(new Person(3, "Sevilla", 33));
        persons.add(new Person(4, "Code", 33));

        Flux.fromIterable(persons)
                .groupBy(Person::getIdPerson)
                .flatMap(idFlux ->idFlux.collectList()).subscribe(p->log.info(p.toString()));
    }
}
