package com.fernandaviana.projetomongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AthorDTO athor;
	
	public CommentDTO() {
			
	}

	public CommentDTO(String text, Date date, AthorDTO athor) {
		super();
		this.text = text;
		this.date = date;
		this.athor = athor;
	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AthorDTO getAthor() {
		return athor;
	}

	public void setAthor(AthorDTO athor) {
		this.athor = athor;
	}
	
	
	
}