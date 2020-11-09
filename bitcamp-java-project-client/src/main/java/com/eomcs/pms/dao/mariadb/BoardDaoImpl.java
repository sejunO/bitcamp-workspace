package com.eomcs.pms.dao.mariadb;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.pms.domain.Board;

// 역할
// - 게시글 데이터를 등록,조회,목록조회,변경,삭제 처리하는 일을 한다.
//
public class BoardDaoImpl implements com.eomcs.pms.dao.BoardDao{
  Connection con;
  public BoardDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public int insert(Board board) throws Exception {
    String resource = "com/eomcs/pms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

      return sqlSession.insert("BoardDao.insert", board);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    String resource = "com/eomcs/pms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

      return sqlSession.delete("BoardDao.delete", no);
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    String resource = "com/eomcs/pms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

      return sqlSession.selectOne("BoardDao.findByNo", no);
    }
  }



  @Override
  public List<Board> findAll() throws Exception {
    String resource = "com/eomcs/pms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardDao.findAll");
    }
  }

  @Override
  public int update(Board board) throws Exception {
    String resource = "com/eomcs/pms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      return sqlSession.update("BoardDao.update", board);
    }
  }
}

