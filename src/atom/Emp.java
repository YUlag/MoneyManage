package atom;

public class Emp {
    private int employeeID;
    private String name;
    private String gender;
    private String position;
    private int hireYear;
    private int FinancialAuthority;


    public Emp() {
    }

    public Emp(int employeeID, String name, String gender, String position, int hireYear, int FinancialAuthority) {
        this.employeeID = employeeID;
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.hireYear = hireYear;
        this.FinancialAuthority = FinancialAuthority;
    }

    /**
     * 获取
     * @return employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * 设置
     * @param employeeID
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取
     * @return hireYear
     */
    public int getHireYear() {
        return hireYear;
    }

    /**
     * 设置
     * @param hireYear
     */
    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    /**
     * 获取
     * @return FinancialAuthority
     */
    public int getFinancialAuthority() {
        return FinancialAuthority;
    }

    /**
     * 设置
     * @param FinancialAuthority
     */
    public void setFinancialAuthority(int FinancialAuthority) {
        this.FinancialAuthority = FinancialAuthority;
    }

    public String toString() {
        return "Emp{employeeID = " + employeeID + ", name = " + name + ", gender = " + gender + ", position = " + position + ", hireYear = " + hireYear + ", FinancialAuthority = " + FinancialAuthority + "}";
    }
}
