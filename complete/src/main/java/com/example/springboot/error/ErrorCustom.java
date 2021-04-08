package com.example.springboot.error;

import com.example.springboot.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class ErrorCustom {

    private  static final Logger log = LoggerFactory.getLogger(ErrorCustom.class);

    // unir combinaciones
    public void retry() {
        //repetir un flujo de datos
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Juan", 33));
        persons1.add(new Person(2, "Cuenca", 3));
        persons1.add(new Person(2, "Sevilla", 23));

        Flux.fromIterable(persons1)
                .concatWith(Flux.error(new RuntimeException(" un Error")))
                .retry(1)
                .subscribe();
    }

}
