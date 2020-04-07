package com.pedrolima.workshopmongo.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Instant instant;
	private AuthorDTO author;
	
	public CommentDTO() {
	}

	public CommentDTO(String text, Instant instant, AuthorDTO author) {
		super();
		this.text = text;
		this.instant = instant;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
}
