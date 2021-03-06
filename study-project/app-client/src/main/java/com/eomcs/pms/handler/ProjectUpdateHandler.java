package com.eomcs.pms.handler;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectUpdateHandler implements Command {

  ProjectDao projectDao;
  MemberPrompt memberPrompt;
  SqlSession sqlSession;

  public ProjectUpdateHandler(ProjectDao projectDao, MemberPrompt memberPrompt, SqlSession sqlSession) {
    this.projectDao = projectDao;
    this.memberPrompt = memberPrompt;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[프로젝트 변경]");
    int no = (int) request.getAttribute("no");

    Project project = projectDao.findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthLoginHandler.getLoginUser().getNo()) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.getContent()));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.getStartDate()));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.getEndDate()));
    List<Member> members = memberPrompt.promptMembers(String.format(
        "팀원(%s)?(완료: 빈 문자열) ", project.getMemberNames()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.setTitle(title);
    project.setContent(content);
    project.setStartDate(startDate);
    project.setEndDate(endDate);
    project.setMembers(members);

    try {
      projectDao.update(project);
      projectDao.deleteMember(project.getNo());
      for (Member m : project.getMembers()) {
        projectDao.insertMember(project.getNo(), m.getNo());
      }
      sqlSession.commit();
    } catch (Exception e) {
      // 예외가 발생하기 전에 성공한 작업이 있으면 모두 취소한다.
      // 그래야 다음 작업에 영향을 끼치지 않는다.
      sqlSession.rollback();
    } 

    projectDao.update(project);
    sqlSession.commit();

    System.out.println("프로젝트를 변경하였습니다.");
  }
}





