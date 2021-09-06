package com.spring.ex03;

public class MemberServiceImpl implements MemberService
{
	private MemberDAO memberDAO; // 주입되는 빈을 저장할 MemberDAO 타입의 속성을 선언
	
	public void setMemberDAO(MemberDAO memberDAO)
	{
		this.memberDAO = memberDAO;
	} // 설정 파일에서 memberDAO 빈을 생성한 후 setter로 속성 memberDAO에 주입

	@Override
	public void listMembers() {
		memberDAO.listMembers();
		
	}
}
