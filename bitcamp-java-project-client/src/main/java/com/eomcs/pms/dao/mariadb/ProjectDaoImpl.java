package com.eomcs.pms.dao.mariadb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;

public class ProjectDaoImpl implements ProjectDao{
  SqlSessionFactory sqlSessionFactory;
  public ProjectDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  @Override
  public int insert(Project project) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.insert("ProjectDao.insert", project);

      for (Member member : project.getMembers()) {
        Map<String,Object> map = new HashMap<>();
        map.put("member_no", member.getNo());
        map.put("project_no", project.getNo());
        sqlSession.insert("ProjectDao.insertMember", map);
      }
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.delete("ProjectDao.deleteMembers", no);
      int count = sqlSession.delete("ProjectDao.delete",no);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public Project findByNo(int no) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("ProjectDao.findByNo", no);
    }
  }

  @Override
  public List<Project> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      List<Project> projects = sqlSession.selectList("ProjectDao.findAll");
      return projects;
    }
  }

  @Override
  public int update(Project project) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.update("ProjectDao.update", project);

      if (count == 0) {
        return 0;
      }
      sqlSession.delete("ProjectDao.deleteMembers", project.getNo());
      // => 새로 팀원을 입력한다.
      for (Member member : project.getMembers()) {
        Map<String,Object> map = new HashMap<>();
        map.put("member_no", member.getNo());
        map.put("project_no", project.getNo());
        sqlSession.insert("ProjectDao.insertMember", map);
      }
      sqlSession.commit();
      return 1;
    }
  }
}