package com.example.springboot.combinacion;

import com.example.springboot.model.Person;
import com.example.springboot.model.Venta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combination {

    private  static final Logger log = LoggerFactory.getLogger(Combination.class);

    // unir combinaciones
    public void merge() {
        //repetir un flujo de datos
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Juan", 33));
        persons1.add(new Person(2, "Cuenca", 3));
        persons1.add(new Person(2, "Sevilla", 23));


        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(1, "Harry", 33));
        persons2.add(new Person(2, "James", 3));
        persons2.add(new Person(2, "Potter", 23));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.of(2020,2,2,2,2,2)));

        Flux<Person> fx1 = Flux.fromIterable(persons1);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx1, fx2, fx3)
                .subscribe(p->log.info(p.toString()));
    }

// une flujos alternativamente
    public void zip() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Juan", 33));
        persons1.add(new Person(2, "Cuenca", 3));
        persons1.add(new Person(2, "Sevilla", 23));


        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(1, "Harry", 33));
        persons2.add(new Person(2, "James", 3));
        persons2.add(new Person(2, "Potter", 23));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.of(2020,2,2,2,2,2)));

        Flux<Person> fx1 = Flux.fromIterable(persons1);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.zip(fx1, fx2, (p1, p2)-> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(x->log.info(x));
        log.info("--------------------------");

        Flux.zip(fx1, fx2, fx3)
                .subscribe(x->log.info(x.toString()));
    }

    public void zipWith() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Juan", 33));
        persons1.add(new Person(2, "Cuenca", 3));
        persons1.add(new Person(2, "Sevilla", 23));


        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(1, "Harry", 33));
        persons2.add(new Person(2, "James", 3));
        persons2.add(new Person(2, "Potter", 23));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.of(2020, 2, 2, 2, 2, 2)));

        Flux<Person> fx1 = Flux.fromIterable(persons1);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        fx1.zipWith(fx3, (p1, v1)-> String.format("Flux1: %s, Flux2: %s", p1, v1))
                .subscribe(x->log.info(x));
    }

}
