package com.aexp.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Image {

	@JsonProperty("image")
	private String image;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("image")
	public String getImage() {
		return image;
	}
	@JsonProperty("image")
	public void setImage(String image) {
		this.image = image;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
