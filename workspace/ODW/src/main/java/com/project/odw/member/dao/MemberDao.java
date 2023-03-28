package com.project.odw.member.dao;

import java.util.List;

import com.project.odw.member.dto.MemberDto;

public interface MemberDao {
	
	public void insertMember(MemberDto memberDto) throws Exception;
	public MemberDto overlapped(String memberId) throws Exception;
	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto selectOneMember(String memberId) throws Exception;
	public void updateMember(MemberDto memberDto) throws Exception;
	public void deleteMember(String memberId) throws Exception;
	public List<MemberDto> selectAllMember(String memberGender) throws Exception;
	public void keepLogin(String id) throws Exception;
	public MemberDto getAutoLogin(String autoLogin) throws Exception;
	
}
