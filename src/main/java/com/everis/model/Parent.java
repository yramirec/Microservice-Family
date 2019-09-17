package com.everis.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "Parent")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Parent {
	
	@Id
	private String id;	
	private String fullName;
	private String gender;
	private LocalDate dateOfBirth;
	private String typeDocument;
	private int numberDocument;

}
