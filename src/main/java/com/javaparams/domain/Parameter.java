package com.javaparams.domain;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "jp_parameter")
public class Parameter {

    @Id
    private Long    id;
    private String  name;
    private String  description;
    private Long    totalLikes;

	public Parameter() {}

	public Parameter(Long id, String name, String description) {
		this.id = id;
		this.description = description;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
 	public Long getTotalLikes() {
		return totalLikes;
	}
	public void setTotalLikes(Long totalLikes) {
		this.totalLikes = totalLikes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, totalLikes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parameter other = (Parameter) obj;
		return Objects.equals(description, other.description)
				&& Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Objects.equals(totalLikes, other.totalLikes);
	}
    
}
