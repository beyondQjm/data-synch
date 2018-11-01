package qjm.data.synch.modle;

import org.apache.hadoop.hbase.util.Bytes;
import qjm.data.synch.annotation.Family;
import qjm.data.synch.annotation.Table;
import qjm.data.synch.hbase.HbaseSerializationReflect;

import java.util.Date;

@Table("education_experience")
@Family("option")
public class EducationExperience extends HbaseSerializationReflect<EducationExperience>{

    private Long id;

    @Family("require")
    private String employeeId;

    private String graduateFrom;

    private String graduateFromOther;

    @Family("require")
    private Integer education;

    @Family("require")
    private Integer degree;

    private String eduMajor;

    @Family("require")
    private Date startdt;

    @Family("require")
    private Date enddt;

    private Date tableDate;

    private Integer tableStatus;

    private String extendField1;

    private String extendField2;

    private Integer extendField3;

    private Integer extendField4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getGraduateFrom() {
        return graduateFrom;
    }

    public void setGraduateFrom(String graduateFrom) {
        this.graduateFrom = graduateFrom == null ? null : graduateFrom.trim();
    }

    public String getGraduateFromOther() {
        return graduateFromOther;
    }

    public void setGraduateFromOther(String graduateFromOther) {
        this.graduateFromOther = graduateFromOther == null ? null : graduateFromOther.trim();
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getEduMajor() {
        return eduMajor;
    }

    public void setEduMajor(String eduMajor) {
        this.eduMajor = eduMajor == null ? null : eduMajor.trim();
    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Date getEnddt() {
        return enddt;
    }

    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }

    public Date getTableDate() {
        return tableDate;
    }

    public void setTableDate(Date tableDate) {
        this.tableDate = tableDate;
    }

    public Integer getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Integer tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getExtendField1() {
        return extendField1;
    }

    public void setExtendField1(String extendField1) {
        this.extendField1 = extendField1 == null ? null : extendField1.trim();
    }

    public String getExtendField2() {
        return extendField2;
    }

    public void setExtendField2(String extendField2) {
        this.extendField2 = extendField2 == null ? null : extendField2.trim();
    }

    public Integer getExtendField3() {
        return extendField3;
    }

    public void setExtendField3(Integer extendField3) {
        this.extendField3 = extendField3;
    }

    public Integer getExtendField4() {
        return extendField4;
    }

    public void setExtendField4(Integer extendField4) {
        this.extendField4 = extendField4;
    }

    public byte[] getKey() {
        return Bytes.toBytes(id);
    }
}