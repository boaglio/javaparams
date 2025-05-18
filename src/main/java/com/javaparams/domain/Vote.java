package com.javaparams.domain;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "jp_vote")
public class Vote {

    @Id
    private Long id;

    @ManyToOne
    private Parameter parameter;

    @ManyToOne
    private User user;

    private Boolean liked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLiked() {
		return liked;
	}

	public void setLiked(Boolean liked) {
		this.liked = liked;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parameter, id, liked, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		return Objects.equals(parameter, other.parameter)
				&& Objects.equals(id, other.id)
				&& Objects.equals(liked, other.liked)
				&& Objects.equals(user, other.user);
	}
    
}
