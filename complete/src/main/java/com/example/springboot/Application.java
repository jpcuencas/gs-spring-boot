package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot.combinacion.Combination;
import com.example.springboot.error.ErrorCustom;
import com.example.springboot.filtrado.Filter;
import com.example.springboot.model.Person;
import com.example.springboot.operator.Creation;
import com.example.springboot.operator.Transformation;
import io.reactivex.Observable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private  static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
/**
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
/**/
	///// el objetivo es trabajar de forma asincona con java
	public void reactor() {
		Mono.just(new Person(1,"Juan", 33))
				.doOnNext(p-> log.info("[Reactor] Persona: " + p)) // for debug or middle operations
				.subscribe(p-> log.info("[Reactor] Persona: " + p));
	}
	public void rxjava2() {
		// en rxjava es indiferente si viene un flujo de datos o un dato singular
		// lo trata los 2 como observables
		Observable.just(new Person(1,"Juan", 33))
				.doOnNext(p-> log.info("[Rx Java] Persona: " + p))
				.subscribe(p-> log.info("[Rx Java] Persona: " + p));

	}
////// MONO ///////
	public void mono() {
		// Mono metodo para un solo elemento
		Mono.just(new Person(0,"Juan", 33))
				.subscribe(p->log.info(p.toString()));

	}
	public void flux() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"Juan", 33));
		persons.add(new Person(2,"Cuenca", 33));
		persons.add(new Person(3,"Sevilla", 33));

		//Generar un flujo de datos asincrono

		// Flux se usa para generar flujos asincronos en coleciones de datos
		Flux.fromIterable(persons).subscribe(p->log.info(p.toString()));
	}
	public void fluxMono() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"Juan", 33));
		persons.add(new Person(2,"Cuenca", 33));
		persons.add(new Person(3,"Sevilla", 33));

		Flux<Person> fx = Flux.fromIterable(persons);
		// transforma el flujo de datos en una lista
		//collectlist devuelve un generico de Mono (un solo elemento) de list personas
		// Flux --> Mono
		fx.collectList().subscribe(list -> log.info(list.toString()));

	}
	@Override
	public void run(String... args) throws Exception {
		//reactor();
		//rxjava2();
		//mono();
		//flux();
		//fluxMono();

		// Creacion de flujo
		Creation create = new Creation();
		Transformation transformation = new Transformation();
		Filter filter = new Filter();
		Combination combination = new Combination();
		ErrorCustom errorCustom = new ErrorCustom();

		//create.range();
		//create.repeat();
		//transformation.map();
		//transformation.flatMap();
		//transformation.groupBy();

		//filtrado.filter();
		//filtrado.distinct();
		//filtrado.take();
		//filtrado.takeLast();
		//filtrado.skip();
		//filter.skipLast();

		//combination.merge();
		//combination.zip();
		//combination.zipWith();

		errorCustom.retry();
	}
}
