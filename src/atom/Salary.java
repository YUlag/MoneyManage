package atom;

import java.math.BigDecimal;

public class Salary {
    private int salaryID;
    private int empID;
    private int year;
    private int month;
    private BigDecimal baseSalary;
    private BigDecimal benefits;
    private BigDecimal bonus;
    private BigDecimal unemploymentInsurance;
    private BigDecimal housingFund;
    private BigDecimal incomeTax;
    private BigDecimal otherDeductions;
    private BigDecimal totalEarnings;
    private BigDecimal totalDeductions;
    private BigDecimal netSalary;


    public Salary() {
    }

    public Salary(int salaryID, int empID, int year, int month, BigDecimal baseSalary, BigDecimal benefits, BigDecimal bonus, BigDecimal unemploymentInsurance, BigDecimal housingFund, BigDecimal incomeTax, BigDecimal otherDeductions, BigDecimal totalEarnings, BigDecimal totalDeductions, BigDecimal netSalary) {
        this.salaryID = salaryID;
        this.empID = empID;
        this.year = year;
        this.month = month;
        this.baseSalary = baseSalary;
        this.benefits = benefits;
        this.bonus = bonus;
        this.unemploymentInsurance = unemploymentInsurance;
        this.housingFund = housingFund;
        this.incomeTax = incomeTax;
        this.otherDeductions = otherDeductions;
        this.totalEarnings = totalEarnings;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
    }

    /**
     * 获取
     *
     * @return salaryID
     */
    public int getSalaryID() {
        return salaryID;
    }

    /**
     * 设置
     *
     * @param salaryID
     */
    public void setSalaryID(int salaryID) {
        this.salaryID = salaryID;
    }

    /**
     * 获取
     *
     * @return empID
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
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 获取
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * 设置
     *
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * 获取
     *
     * @return baseSalary
     */
    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    /**
     * 设置
     *
     * @param baseSalary
     */
    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * 获取
     *
     * @return benefits
     */
    public BigDecimal getBenefits() {
        return benefits;
    }

    /**
     * 设置
     *
     * @param benefits
     */
    public void setBenefits(BigDecimal benefits) {
        this.benefits = benefits;
    }

    /**
     * 获取
     *
     * @return bonus
     */
    public BigDecimal getBonus() {
        return bonus;
    }

    /**
     * 设置
     *
     * @param bonus
     */
    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    /**
     * 获取
     *
     * @return unemploymentInsurance
     */
    public BigDecimal getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    /**
     * 设置
     *
     * @param unemploymentInsurance
     */
    public void setUnemploymentInsurance(BigDecimal unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    /**
     * 获取
     *
     * @return housingFund
     */
    public BigDecimal getHousingFund() {
        return housingFund;
    }

    /**
     * 设置
     *
     * @param housingFund
     */
    public void setHousingFund(BigDecimal housingFund) {
        this.housingFund = housingFund;
    }

    /**
     * 获取
     *
     * @return incomeTax
     */
    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    /**
     * 设置
     *
     * @param incomeTax
     */
    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }

    /**
     * 获取
     *
     * @return otherDeductions
     */
    public BigDecimal getOtherDeductions() {
        return otherDeductions;
    }

    /**
     * 设置
     *
     * @param otherDeductions
     */
    public void setOtherDeductions(BigDecimal otherDeductions) {
        this.otherDeductions = otherDeductions;
    }

    /**
     * 获取
     *
     * @return totalEarnings
     */
    public BigDecimal getTotalEarnings() {
        return totalEarnings;
    }

    /**
     * 设置
     *
     * @param totalEarnings
     */
    public void setTotalEarnings(BigDecimal totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    /**
     * 获取
     *
     * @return totalDeductions
     */
    public BigDecimal getTotalDeductions() {
        return totalDeductions;
    }

    /**
     * 设置
     *
     * @param totalDeductions
     */
    public void setTotalDeductions(BigDecimal totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    /**
     * 获取
     *
     * @return netSalary
     */
    public BigDecimal getNetSalary() {
        return netSalary;
    }

    /**
     * 设置
     *
     * @param netSalary
     */
    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    public String toString() {
        return "Salary{salaryID = " + salaryID + ", empID = " + empID + ", year = " + year + ", month = " + month + ", baseSalary = " + baseSalary + ", benefits = " + benefits + ", bonus = " + bonus + ", unemploymentInsurance = " + unemploymentInsurance + ", housingFund = " + housingFund + ", incomeTax = " + incomeTax + ", otherDeductions = " + otherDeductions + ", totalEarnings = " + totalEarnings + ", totalDeductions = " + totalDeductions + ", netSalary = " + netSalary + "}";
    }
}
