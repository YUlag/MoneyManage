package atom;

import java.util.Date;

public class Emp {
    private int empID;
    private String username;
    private String password;
    private String name;
    private String gender;
    private int age;
    private String position;
    private String department;
    private Date hireYear;
    private int financialAuthority;
    private Date Birthdate;

    public Emp() {
    }

//    public Emp(int empID, String username, String password, String name, String gender, String position, String department, Date hireYear, int financialAuthority, Date Birthdate) {
//        this.empID = empID;
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.gender = gender;
//        this.position = position;
//        this.department = department;
//        this.hireYear = hireYear;
//        this.financialAuthority = financialAuthority;
//        this.Birthdate = Birthdate;
//    }

    public Emp(int empID, String username, String password, String name, String gender, int age, String position, String department, Date hireYear, int financialAuthority, Date Birthdate) {
        this.empID = empID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.position = position;
        this.department = department;
        this.hireYear = hireYear;
        this.financialAuthority = financialAuthority;
        this.Birthdate = Birthdate;
    }

    /**
     * 获取
     *
     * @return employeeID
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * 设置
     *
     * @param empID
     */
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置
     *
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取
     *
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置
     *
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取
     *
     * @return hireYear
     */
    public Date getHireYear() {
        return hireYear;
    }

    /**
     * 设置
     *
     * @param hireYear
     */
    public void setHireYear(Date hireYear) {
        this.hireYear = hireYear;
    }

    /**
     * 获取
     *
     * @return financialAuthority
     */
    public int getFinancialAuthority() {
        return financialAuthority;
    }

    /**
     * 设置
     *
     * @param financialAuthority
     */
    public void setFinancialAuthority(int financialAuthority) {
        this.financialAuthority = financialAuthority;
    }

    /**
     * 获取
     *
     * @return Birthdate
     */
    public Date getBirthdate() {
        return Birthdate;
    }

    /**
     * 设置
     *
     * @param Birthdate
     */
    public void setBirthdate(Date Birthdate) {
        this.Birthdate = Birthdate;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Emp{empID = " + empID + ", username = " + username + ", password = " + password + ", name = " + name + ", gender = " + gender + ", age = " + age + ", position = " + position + ", department = " + department + ", hireYear = " + hireYear + ", financialAuthority = " + financialAuthority + ", Birthdate = " + Birthdate + "}";
    }
}