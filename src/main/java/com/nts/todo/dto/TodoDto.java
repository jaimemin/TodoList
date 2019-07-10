package com.nts.todo.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class TodoDto {
	private long id;
	private String name;
	private Timestamp registeredDate;
	private int sequence;
	private String title;
	private String type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new NullPointerException("name is null");
		}

		this.name = name;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate.toLocalDateTime().toLocalDate();
	}

	public void setRegisteredDate(Timestamp registeredDate) {
		if (registeredDate == null) {
			throw new NullPointerException("registeredDate is null");
		}

		this.registeredDate = registeredDate;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null) {
			throw new NullPointerException("title is null");
		}

		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type == null) {
			throw new NullPointerException("type is null");
		}

		this.type = type;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", registeredDate=" + registeredDate + ", sequence=" + sequence
				+ ", title=" + title + ", type=" + type + "]";
	}

}
