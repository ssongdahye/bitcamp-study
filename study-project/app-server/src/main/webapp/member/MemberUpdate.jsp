<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.eomcs.pms.domain.Member"%>
<%@page import="com.eomcs.pms.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원변경</title>
</head>
<body>
<h1>회원변경결과</h1>
<%
int no = Integer.parseInt(request.getParameter("no"));

Member member = memberDao.findByNo(no);

if (member == null) {
  throw new Exception("해당 번호의 회원이 없습니다.");
} else {
  member.setName(request.getParameter("name"));
  member.setEmail(request.getParameter("email"));
  member.setPassword(request.getParameter("password"));
  member.setPhoto(request.getParameter("photo"));
  member.setTel(request.getParameter("tel"));

  memberDao.update(member);
  sqlSession.commit();
}
response.sendRedirect("MemberList.jsp");
%>
</body>
</html>
<%! // <== declaration element (tag)
// 자바 서블릿 클래스를 만들 때 클래스에 들어갈 변수와 메서드를 이 태그 안에 작성한다.
  MemberDao memberDao;
  SqlSession sqlSession;

  public void jspInit() {
    ServletConfig config = getServletConfig();
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }
%>











