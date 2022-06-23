package com.bridgelabz;
import java.util.Random;
public class EmployeeWageBulider {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Builder");
        int IS_fULL_tIME = 1;
        Random random = new Random();
        int empCheck = random.nextInt(2);
        if (empCheck == IS_fULL_tIME) {
            System.out.println("Employee is present");
        } else {
            System.out.println("Employee is absent");

        }
    }

}
