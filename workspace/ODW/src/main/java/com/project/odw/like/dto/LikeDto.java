package com.project.odw.like.dto;

import org.springframework.stereotype.Component;

@Component
public class LikeDto {

	private String likeSend;
	private String likeReceive;

	public String getLikeSend() {
		return likeSend;
	}
	public void setLikeSend(String likeSend) {
		this.likeSend = likeSend;
	}
	public String getLikeReceive() {
		return likeReceive;
	}
	public void setLikeReceive(String likeReceive) {
		this.likeReceive = likeReceive;
	}
}
