package com.javaparams.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "jp_vote")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVoteGen")
	@SequenceGenerator(name = "seqVoteGen", sequenceName = "seq_jp_vote", allocationSize = 1)
	private Long id;

	private Long parameterId;

	private String username;

	private LocalDateTime votedAt;

	public Vote() {}

	public Vote(Long parameterId, String username) {
		this.parameterId = parameterId;
		this.username = username;
		this.votedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public Long getParameterId() {
		return parameterId;
	}

	public String getUsername() {
		return username;
	}

	public LocalDateTime getVotedAt() {
		return votedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vote vote)) return false;
        return Objects.equals(id, vote.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}