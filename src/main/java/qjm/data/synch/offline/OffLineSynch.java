package qjm.data.synch.offline;

import org.apache.hadoop.hbase.client.Scan;
import qjm.data.synch.hbase.HbaseUtils;
import qjm.data.synch.modle.EducationExperience;
import qjm.data.synch.modle.Employee;
import qjm.data.synch.service.LoadSqlData;

import java.util.List;

/**
 * 离线同步数据
 */
public class OffLineSynch {

    public void synch(){
        //加载数据
        LoadSqlData loadData = new LoadSqlData("SqlMapConfig.xml");
        //加载员工信息
        List<Employee> employees = loadData.loadEmployee();
        //加载学历信息
        List<EducationExperience> educations = loadData.loadEducationExperience();

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
}
