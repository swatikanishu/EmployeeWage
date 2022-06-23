package com.bridgelabz;
import java.util.Random;

public class EmployeeWageBuilder {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Builder");
        int IS_fULL_tIME = 1;
        int EMP_RATE_PER_HOUR=20;
        int empHours=0;
        int empWage=0;
        Random random = new Random();
        int empCheck = random.nextInt(2);

        if (empCheck == IS_fULL_tIME) {
            System.out.println("Employee is present");
            empHours=8;
        }
        else {
            System.out.println("Employee is absent");
            empHours=4;

        }
        empWage=empHours*EMP_RATE_PER_HOUR;
        System.out.println("The daliy wage of Empolyee is" + empWage);
    }
}