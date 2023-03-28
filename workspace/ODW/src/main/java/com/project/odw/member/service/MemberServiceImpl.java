package com.project.odw.member.service;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.odw.member.dao.MemberDao;
import com.project.odw.member.dto.MemberDto;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static String PROFILE_IMAGE_REPO;	
	static {
		PROFILE_IMAGE_REPO = "/Users/oseunghwan/Desktop/Spring_project/workspace/ODW/src/main/webapp/WEB-INF/views/member/profile_images/";
	}
	
	@Override
	public void joinMember(MemberDto memberDto, MultipartHttpServletRequest mul) throws Exception {
		
		MultipartFile file = mul.getFile("file");
		
		if(!file.isEmpty()) {
			
			UUID fileUuId = UUID.randomUUID(); // 고유식별자 기능을 사용하여 파일명의 중복을 방지한다.
			
			String fileName = fileUuId + "_" + file.getOriginalFilename();
			
			memberDto.setProfileImage(fileName);
			
			File saveFile = new File(PROFILE_IMAGE_REPO + fileName);
			
			file.transferTo(saveFile);
		}
		
		if (memberDto.getEmailstsYn() == null) memberDto.setEmailstsYn("n");
		else								   memberDto.setEmailstsYn("y");
		
		if (memberDto.getSmsstsYn() == null)   memberDto.setSmsstsYn("n");
		else								   memberDto.setSmsstsYn("y");

		memberDto.setMemberPw(passwordEncoder.encode(memberDto.getMemberPw())); 
		memberDao.insertMember(memberDto);
	}

	@Override
	public String overlapped(String memberId) throws Exception {

		String isOverLapped = "true";
		
		if (memberDao.overlapped(memberId) == null) {
			isOverLapped = "false";
		}
		
		return isOverLapped;
	}

	@Override
	public MemberDto loginMember(MemberDto memberDto) throws Exception {

		MemberDto dbMemberDto = memberDao.login(memberDto);
		
		if (dbMemberDto != null) {
			if (passwordEncoder.matches(memberDto.getMemberPw(), dbMemberDto.getMemberPw())) {
				return memberDto;
			}
		}
		
		return null;
	}

	@Override
	public MemberDto showOneMember(String memberId) throws Exception {
		return memberDao.selectOneMember(memberId);
	}

	@Override
	public void getProfileImage(OutputStream out, String filePath) throws Exception {
		
		File image = new File(filePath);
		if (image.exists()) { 
			Thumbnails.of(image).size(256,300).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}

	@Override
	public boolean updateMember(MemberDto memberDto, MultipartHttpServletRequest mul) throws Exception {
		
		MemberDto dbMemberDto = memberDao.login(memberDto);
		
		if (passwordEncoder.matches(memberDto.getMemberPw(), dbMemberDto.getMemberPw())) {
			
			MultipartFile file = mul.getFile("file");
			
			if(!file.isEmpty() && memberDto.getProfileImage() != dbMemberDto.getProfileImage()) {
				
				File preFile = new File(PROFILE_IMAGE_REPO + dbMemberDto.getProfileImage());	// 기존 이미지파일 정보 갖고오기.
				
				if (preFile.exists()) { preFile.delete(); }	// 파일 삭제.
				
				UUID fileUuId = UUID.randomUUID();
				
				String fileName = fileUuId + "_" + file.getOriginalFilename();
				
				memberDto.setProfileImage(fileName);
				
				File saveFile = new File(PROFILE_IMAGE_REPO + fileName);
				
				file.transferTo(saveFile);
			}
			
			if (memberDto.getEmailstsYn() == null) memberDto.setEmailstsYn("n");
			else								   memberDto.setEmailstsYn("y");
			
			if (memberDto.getSmsstsYn() == null)   memberDto.setSmsstsYn("n");
			else								   memberDto.setSmsstsYn("y");

			memberDao.updateMember(memberDto);
			return true;
		}
		return false;
	}

	@Override
	public void deleteMember(String memberId) throws Exception {
		
		MemberDto memberDto = memberDao.selectOneMember(memberId);
		File file = new File(PROFILE_IMAGE_REPO + memberDto.getProfileImage());
		
		if (file.exists()) { file.delete(); }
		
		memberDao.deleteMember(memberId);
	}

	public List<MemberDto> showAllMember(String memberId) throws Exception {
		
		MemberDto memberDto = memberDao.selectOneMember(memberId);
		
		return memberDao.selectAllMember(memberDto.getMemberGender());
	}

	@Override
	public void keepLogin(String id) throws Exception {
		memberDao.keepLogin(id);
	}

	@Override
	public MemberDto getAutoLogin(String autoLogin) throws Exception {
		return memberDao.getAutoLogin(autoLogin);
	}

}
