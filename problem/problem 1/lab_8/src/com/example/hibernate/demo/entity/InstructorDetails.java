package com.example.hibernate.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetails {
	// define fields
	
	// define constructor
	
	// define getter and setter
	
	// add toString methong
	
	// add annotation
	// relate to instructor (one to one)
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	
	public InstructorDetails() {
		
	}

	public InstructorDetails(String channel, String hobby) {
		this.youtubeChannel = channel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String channel) {
		this.youtubeChannel = channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby= hobby;
	}


	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", channel=" + youtubeChannel + ", hobbyString=" + hobby + "]";
	}
	
	
	
	
	
}
