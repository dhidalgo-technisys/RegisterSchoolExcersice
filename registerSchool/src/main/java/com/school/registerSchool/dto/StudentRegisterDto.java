package com.school.registerSchool.dto;

public class StudentRegisterDto {
	private String fullname;
	private String course;
	private String score;

	public StudentRegisterDto(String fullname, String course, String score) {
		this.fullname = fullname;
		this.course = course;
		this.score = score;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
