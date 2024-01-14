package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String departure_city;
	private String destination_city;
	private String departure_time;
	private double ticket_price;
	
}
