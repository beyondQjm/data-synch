package qjm.data.synch.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import qjm.data.synch.modle.EducationExperience;
import qjm.data.synch.modle.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 加载数据数
 */
public class LoadSqlData {

    private SqlSessionFactory sqlSessionFactory;

    public LoadSqlData(String xmlPath) {
        this.sqlSessionFactory = getSqlSessionFactory(xmlPath);
    }

    public LoadSqlData(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 初始化SqlSessionFactory
     * @return
     */
    public SqlSessionFactory getSqlSessionFactory(String xmlPath) {
        //加载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream(xmlPath);
            return new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载员工信息
     * @return
     */
    public List<Employee> loadEmployee(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Employee> list = sqlSession.selectList("qjm.data.synch.mapper.EmployeeMapper.selectAll");
        sqlSession.close();
        return list;
    }

    /**
     * 加载学历信息
     * @return
     */
    public List<EducationExperience> loadEducationExperience(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<EducationExperience> list = sqlSession.selectList("qjm.data.synch.mapper.EducationExperienceMapper.selectAll");
        sqlSession.close();
        return list;
    }
}
