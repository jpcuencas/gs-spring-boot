package com.example.springboot.filtrado;

import com.example.springboot.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private  static final Logger log = LoggerFactory.getLogger(Filter.class);

    public void filter() {
        //filtra un flujo de datos
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(2, "Sevilla", 23));

        Flux.fromIterable(persons)
                .filter(p-> p.getAge() > 28)
                .subscribe(p->log.info(p.toString()));
    }

    public void distinct() {
        //saca los diferentes en un flujo de datos
        Flux.fromIterable(List.of(1,1,2,2))
                .distinct()
                .subscribe(p->log.info(p.toString()));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(2, "Cuenca", 3));

        Flux.fromIterable(persons)
                .distinct()
                .subscribe(p->log.info(p.toString()));
    }


    public void take() {
        //coje una cantidad de elementos de un flujo de datos
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(3, "Sevilla", 33));
        persons.add(new Person(4, "Code", 33));

        Flux.fromIterable(persons)
                .take(2)
                .subscribe(p->log.info(p.toString()));
    }

    public void takeLast() {
        //coje una cantidad de elementos por el final de un flujo de datos
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(3, "Sevilla", 33));
        persons.add(new Person(4, "Code", 33));

        Flux.fromIterable(persons)
                .takeLast(2)
                .subscribe(p->log.info(p.toString()));
    }

    public void skip() {
        //salta cantidad de elementos un flujo de datos
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(3, "Sevilla", 33));
        persons.add(new Person(4, "Code", 33));

        Flux.fromIterable(persons)
                .skip(2)
                .subscribe(p->log.info(p.toString()));
    }

    public void skipLast() {
        //salta por el final los elementos de un flujo de datos
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", 33));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(2, "Cuenca", 3));
        persons.add(new Person(3, "Sevilla", 33));
        persons.add(new Person(4, "Code", 33));

        Flux.fromIterable(persons)
                .skipLast(2)
                .subscribe(p->log.info(p.toString()));
    }
}
