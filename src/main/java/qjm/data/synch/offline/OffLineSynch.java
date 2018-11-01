package qjm.data.synch.offline;

import org.apache.hadoop.hbase.client.Scan;
import qjm.data.synch.hbase.HbaseUtils;
import qjm.data.synch.modle.EducationExperience;
import qjm.data.synch.modle.Employee;
import qjm.data.synch.service.SqlDataService;

import java.util.List;

/**
 * 离线同步数据
 */
public class OffLineSynch {

    /**
     * 从关系型数据库同步数据到hbase
     */
    public void synchToHbase(){
        //加载数据
        SqlDataService sqlDataService = new SqlDataService("SqlMapConfig.xml");
        //加载员工信息
        List<Employee> employees = sqlDataService.loadEmployee();
        //加载学历信息
        List<EducationExperience> educations = sqlDataService.loadEducationExperience();

        HbaseUtils hbaseUtils = new HbaseUtils();
        try {
            //将数据添加到hbase
            hbaseUtils.putData(employees);
            hbaseUtils.putData(educations);

            //查询hbase中的数据
            Scan scan = new Scan();
            List<Employee> list = hbaseUtils.scanData(scan, Employee.class);
            for (Employee employee:list){
                System.out.println(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            hbaseUtils.close();
        }
    }

    /**
     * 从hbase同步数据到关系型数据库
     */
    public void synchFromHbase(){
        HbaseUtils hbaseUtils = new HbaseUtils();
        List<Employee> employees;
        //List<EducationExperience> educations;
        try {
            //将数据添加到hbase
            employees = hbaseUtils.scanData(new Scan(), Employee.class);
            //educations = hbaseUtils.scanData(new Scan(), EducationExperience.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            hbaseUtils.close();
        }

        //加载数据
        SqlDataService sqlDataService = new SqlDataService("SqlMapConfig.xml");
        sqlDataService.putEmployee(employees);

    }
}
