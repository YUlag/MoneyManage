package event;

import SQL.Select;
import accountingGUI.UpdateAndDeleteSalaryGUI;
import atom.Salary;
import managerGUI.UpdateAndDeleteEmpGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSalaryByIDEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String salaryID = UpdateAndDeleteSalaryGUI.getSalaryIDText();

        if (salaryID.equals("")) {
            numberEmpty();
        } else {
            try {
                Salary salary = Select.selectSalaryById(Integer.parseInt(salaryID));

                UpdateAndDeleteSalaryGUI.setNameText(Select.selectEmpById(salary.getEmpID()).getName());
                UpdateAndDeleteSalaryGUI.setBaseSalaryText(String.valueOf(salary.getBaseSalary()));
                UpdateAndDeleteSalaryGUI.setBenefitsText(String.valueOf(salary.getBenefits()));
                UpdateAndDeleteSalaryGUI.setBonusText(String.valueOf(salary.getBonus()));
                UpdateAndDeleteSalaryGUI.setUnemploymentInsuranceText(String.valueOf(salary.getUnemploymentInsurance()));
                UpdateAndDeleteSalaryGUI.setHousingFundText(String.valueOf(salary.getHousingFund()));
                UpdateAndDeleteSalaryGUI.setIncomeTaxText(String.valueOf(salary.getIncomeTax()));
                UpdateAndDeleteSalaryGUI.setOtherDeductionsText(String.valueOf(salary.getOtherDeductions()));
                UpdateAndDeleteSalaryGUI.setMonthText(String.valueOf(salary.getMonth()));
                UpdateAndDeleteSalaryGUI.setYearText(String.valueOf(salary.getYear()));
            } catch (NumberFormatException t1) {
                numberFormatError();
                UpdateAndDeleteEmpGUI.setEmpIDText("");
            } catch (IndexOutOfBoundsException t2) {
                numberOutError();
                UpdateAndDeleteEmpGUI.setEmpIDText("");
            }
        }
    }


    private void numberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工资号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }

    private void numberOutError() {
        JOptionPane.showMessageDialog(null, "未找到指定工资号,请重新输入", "输入错误", JOptionPane.WARNING_MESSAGE);
    }

    private void numberFormatError() {
        JOptionPane.showMessageDialog(null, "输入格式有误，请重新输入", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
