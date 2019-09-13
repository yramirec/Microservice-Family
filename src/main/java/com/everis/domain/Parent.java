package com.everis.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Parent")
public class Parent {
	
	@Id
	private String id;	
	private String fullName;
	private String gender;
	private LocalDate dateOfBirth;
	private String typeDocument;
	private int numberDocument;

}
