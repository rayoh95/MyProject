package com.project.odw.member.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MemberDto {
	
	private String profileImage;
	private String memberId;
	private String memberPw;
	private String memberGender;
	private String memberHeight;
	private String memberBirthY;
	private String memberBirthM;
	private String memberBirthD;
	private String hp1;
	private String hp2;
	private String hp3;
	private String smsstsYn;
	private String email;
	private String emailstsYn;
	private String zipcode;
	private String roadAddress;
	private String numberAddress;
	private String remainAddress;
	private Date joinDate;
	
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberHeight() {
		return memberHeight;
	}
	public void setMemberHeight(String memberHeight) {
		this.memberHeight = memberHeight;
	}
	public String getMemberBirthY() {
		return memberBirthY;
	}
	public void setMemberBirthY(String memberBirthY) {
		this.memberBirthY = memberBirthY;
	}
	public String getMemberBirthM() {
		return memberBirthM;
	}
	public void setMemberBirthM(String memberBirthM) {
		this.memberBirthM = memberBirthM;
	}
	public String getMemberBirthD() {
		return memberBirthD;
	}
	public void setMemberBirthD(String memberBirthD) {
		this.memberBirthD = memberBirthD;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getSmsstsYn() {
		return smsstsYn;
	}
	public void setSmsstsYn(String smsstsYn) {
		this.smsstsYn = smsstsYn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailstsYn() {
		return emailstsYn;
	}
	public void setEmailstsYn(String emailstsYn) {
		this.emailstsYn = emailstsYn;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getNumberAddress() {
		return numberAddress;
	}
	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}
	public String getRemainAddress() {
		return remainAddress;
	}
	public void setRemainAddress(String remainAddress) {
		this.remainAddress = remainAddress;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}
