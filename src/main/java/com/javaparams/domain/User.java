package com.javaparams.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "jp_user")
public class User {

    @Id
    private String id;

    private String name;

    private LocalDateTime lastLogin;
    
    public User() {}

	public User(String id, String name, LocalDateTime lastLogin) {
		this.id = id;
		this.name = name;
		this.lastLogin = lastLogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lastLogin, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(lastLogin, other.lastLogin)
				&& Objects.equals(name, other.name);
	}

}