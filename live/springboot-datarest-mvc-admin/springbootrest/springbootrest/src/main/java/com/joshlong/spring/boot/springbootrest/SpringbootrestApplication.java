package com.joshlong.spring.boot.springbootrest;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class SpringbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ReservationRepository rr) {
		return args ->  {
			Arrays.asList("Tabish,Junaid,Alfiya,Yasir,Darakhshan".split(","))
				  .forEach(n -> rr.save(new Reservation(n)));
			
			rr.findAll().forEach(System.out::println);
			
			rr.findByReservationName("Tabish")
			  .forEach(System.out::println);
			
		};
	}
}

interface ReservationRepository extends JpaRepository<Reservation, Long>{
	Collection<Reservation> findByReservationName(String reservationName);
}

@Entity
class Reservation{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String reservationName;

	public Reservation() {
		super();
	}

	public Reservation(String reservationName) {
		super();
		this.reservationName = reservationName;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationName=" + reservationName + "]";
	}
	
	
	
	
}
