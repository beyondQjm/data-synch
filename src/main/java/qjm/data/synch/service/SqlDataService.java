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
public class SqlDataService {

    private SqlSessionFactory sqlSessionFactory;

    public SqlDataService(String xmlPath) {
        this.sqlSessionFactory = getSqlSessionFactory(xmlPath);
    }

    public SqlDataService(SqlSessionFactory sqlSessionFactory) {
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
     * 添加员工信息
     * @return
     */
    public void putEmployee(List<Employee> list){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("qjm.data.synch.mapper.EmployeeMapper.insertByBatch",list);
        /*for (Employee e:list){
            sqlSession.insert("qjm.data.synch.mapper.EmployeeMapper.insert",e);
        }*/
        sqlSession.commit();
        sqlSession.close();
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

    /**
     * 根据id查找员工信息
     * @return
     */
    public Employee getEmployeeById(Long id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee = sqlSession.selectOne("qjm.data.synch.mapper.EmployeeMapper.selectByPrimaryKey", id);
        sqlSession.close();
        return employee;
    }

    /**
     * 根据id查找信息
     * @return
     */
    public <T> T getById(Long id, Class<T> clazz){
        String clazzName = clazz.getSimpleName();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        T value = sqlSession.selectOne("qjm.data.synch.mapper."+clazzName+"Mapper.selectByPrimaryKey", id);
        sqlSession.close();
        return value;
    }

    /**
     * 根据id查找信息
     * @return
     */
    public <T> List<T> loadAll(Class<T> clazz){
        String clazzName = clazz.getSimpleName();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<T> values = sqlSession.selectList("qjm.data.synch.mapper."+clazzName+"Mapper.selectAll");
        sqlSession.close();
        return values;
    }
}
