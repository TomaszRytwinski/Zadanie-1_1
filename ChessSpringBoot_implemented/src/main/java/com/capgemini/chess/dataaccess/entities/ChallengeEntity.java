package com.capgemini.chess.dataaccess.entities;

import java.util.UUID;

import com.capgemini.chess.enums.Status;

public class ChallengeEntity {
	private Long p1id;
	private Long p2id;
	private UUID id;
	private Status status;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public Long getP1id() {
		return p1id;
	}

	public void setP1id(Long p1id) {
		this.p1id = p1id;
	}

	public Long getP2id() {
		return p2id;
	}

	public void setP2id(Long p2id) {
		this.p2id = p2id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
