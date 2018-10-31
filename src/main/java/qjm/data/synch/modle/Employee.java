package qjm.data.synch.modle;

import org.apache.hadoop.hbase.util.Bytes;
import qjm.data.synch.annotation.Clipping;
import qjm.data.synch.annotation.Family;
import qjm.data.synch.annotation.Table;
import qjm.data.synch.hbase.HbaseSerializationReflect;

import java.util.Date;

@Table("employee")
@Family("option")
public class Employee extends HbaseSerializationReflect<Employee> {
    @Clipping
    private Long id;

    @Family("require")
    private String employeeId;

    private Integer identityType;

    private String identityId;

    private String name;

    @Family("require")
    private Integer gender;

    @Family("require")
    private Date birth;

    private Integer birthYear;

    private Integer birthMonth;

    private Integer birthDay;

    @Clipping
    private String imagePath;

    private Integer age;

    private String tall;

    private String bloodType;

    private Integer nation;

    private Integer jiguan;

    private Integer birthPlace;

    @Family("require")
    private Integer ethic;

    @Family("require")
    private Integer maritalStatus;

    @Family("require")
    private Integer haveChild;

    @Family("require")
    private Integer politicFace;

    @Family("require")
    private Date joinPartyDate;

    private Date fullPartyDate;

    private String localPartyBranch;

    private Integer partyJob;

    @Family("require")
    private Date workDate;

    @Family("require")
    private Date joinDate;

    @Family("require")
    private Integer employmentCategory;

    @Family("require")
    private Integer jobStatus;

    private String phone;

    private String officeTelephone;

    private String email;

    private String address;

    @Clipping
    private String emergContPerson;

    @Clipping
    private String emergContMethon;

    @Clipping
    private String emergContAddr;

    @Clipping
    private String empCode;

    private Date tableDate;

    private Integer tableStatus;

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

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTall() {
        return tall;
    }

    public void setTall(String tall) {
        this.tall = tall == null ? null : tall.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public Integer getJiguan() {
        return jiguan;
    }

    public void setJiguan(Integer jiguan) {
        this.jiguan = jiguan;
    }

    public Integer getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Integer birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Integer getEthic() {
        return ethic;
    }

    public void setEthic(Integer ethic) {
        this.ethic = ethic;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getHaveChild() {
        return haveChild;
    }

    public void setHaveChild(Integer haveChild) {
        this.haveChild = haveChild;
    }

    public Integer getPoliticFace() {
        return politicFace;
    }

    public void setPoliticFace(Integer politicFace) {
        this.politicFace = politicFace;
    }

    public Date getJoinPartyDate() {
        return joinPartyDate;
    }

    public void setJoinPartyDate(Date joinPartyDate) {
        this.joinPartyDate = joinPartyDate;
    }

    public Date getFullPartyDate() {
        return fullPartyDate;
    }

    public void setFullPartyDate(Date fullPartyDate) {
        this.fullPartyDate = fullPartyDate;
    }

    public String getLocalPartyBranch() {
        return localPartyBranch;
    }

    public void setLocalPartyBranch(String localPartyBranch) {
        this.localPartyBranch = localPartyBranch == null ? null : localPartyBranch.trim();
    }

    public Integer getPartyJob() {
        return partyJob;
    }

    public void setPartyJob(Integer partyJob) {
        this.partyJob = partyJob;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getEmploymentCategory() {
        return employmentCategory;
    }

    public void setEmploymentCategory(Integer employmentCategory) {
        this.employmentCategory = employmentCategory;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOfficeTelephone() {
        return officeTelephone;
    }

    public void setOfficeTelephone(String officeTelephone) {
        this.officeTelephone = officeTelephone == null ? null : officeTelephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmergContPerson() {
        return emergContPerson;
    }

    public void setEmergContPerson(String emergContPerson) {
        this.emergContPerson = emergContPerson == null ? null : emergContPerson.trim();
    }

    public String getEmergContMethon() {
        return emergContMethon;
    }

    public void setEmergContMethon(String emergContMethon) {
        this.emergContMethon = emergContMethon == null ? null : emergContMethon.trim();
    }

    public String getEmergContAddr() {
        return emergContAddr;
    }

    public void setEmergContAddr(String emergContAddr) {
        this.emergContAddr = emergContAddr == null ? null : emergContAddr.trim();
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", identityType=" + identityType +
                ", identityId='" + identityId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", birthDay=" + birthDay +
                ", imagePath='" + imagePath + '\'' +
                ", age=" + age +
                ", tall='" + tall + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", nation=" + nation +
                ", jiguan=" + jiguan +
                ", birthPlace=" + birthPlace +
                ", ethic=" + ethic +
                ", maritalStatus=" + maritalStatus +
                ", haveChild=" + haveChild +
                ", politicFace=" + politicFace +
                ", joinPartyDate=" + joinPartyDate +
                ", fullPartyDate=" + fullPartyDate +
                ", localPartyBranch='" + localPartyBranch + '\'' +
                ", partyJob=" + partyJob +
                ", workDate=" + workDate +
                ", joinDate=" + joinDate +
                ", employmentCategory=" + employmentCategory +
                ", jobStatus=" + jobStatus +
                ", phone='" + phone + '\'' +
                ", officeTelephone='" + officeTelephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", emergContPerson='" + emergContPerson + '\'' +
                ", emergContMethon='" + emergContMethon + '\'' +
                ", emergContAddr='" + emergContAddr + '\'' +
                ", empCode='" + empCode + '\'' +
                ", tableDate=" + tableDate +
                ", tableStatus=" + tableStatus +
                '}';
    }

    public byte[] getKey() {
        return Bytes.toBytes(employeeId);
    }
}