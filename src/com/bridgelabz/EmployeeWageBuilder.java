package com.bridgelabz;
import java.util.Random;

public class EmployeeWageBuilder {

    final static int FULL_TIME_WORKER = 1;
    final static int PART_TIME_WORKER = 2;

    public static void computeEmpWage(String company, int EMP_RATE_PER_HOUR, int Total_no_Working_Day, int EMP_TOTAL_HOURS) {
        int totalworkingdays = 0;
        int empHours = 0;
        int empWage = 0;
        int Totalemphrs = 0;
        System.out.println("Welcome to Employee Wage Builder");

        while (Totalemphrs <= EMP_TOTAL_HOURS && totalworkingdays <= Total_no_Working_Day) {
            totalworkingdays++;
            Random random = new Random();

            int empCheck = random.nextInt(2);

            switch (empCheck) {
                case FULL_TIME_WORKER:
                    empHours = 8;
                    System.out.println("Employee is present");
                    break;
                case PART_TIME_WORKER:
                    empHours = 4;
                    System.out.println("Employee is present");
                    break;
                default:
                    empHours = 0;
                    System.out.println("Employee is absent");
            }
            Totalemphrs = Totalemphrs + empHours;
            empWage = empHours * EMP_RATE_PER_HOUR;
            int Total_emp_wage = empWage + Totalemphrs;
            Total_emp_wage = Total_emp_wage * Total_no_Working_Day;
            System.out.println("The daily wage of Employee of " + company + " is" + empWage);
            System.out.println("The Monthly Wage of Employee of " + company + " is" + Total_emp_wage);

        }
    }

    public static void main(String[] args) {
        computeEmpWage("Bridgelabz", 20, 20, 200);
        computeEmpWage("HCL", 30, 30, 300);
        computeEmpWage("TCS", 50, 20, 220);

    }
}


