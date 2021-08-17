package com.praxia.springcontactmysqlj;

import com.praxia.springcontactmysqlj.model.Contact;
import com.praxia.springcontactmysqlj.repository.IContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class SpringContactMysqlJApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContactMysqlJApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IContactRepository repository){
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Contact c = new Contact();
						c.setName("Name: " + i);
						c.setEmail("Email: " + i);
						c.setPhone("Phone: " + i);
						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}
