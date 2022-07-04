package com.bridgelabz;
import java.util.Random;
import java.util.ArrayList;
public class EmployeeWageBuilder {
    public class EmployeeWageBuilder  implements IEmpWageBuilder {
        // instance variables
        int noOfCompanies, index;
        ArrayList<companyEmpWage> companies; //ArrayList declaration

        // contructor for EmpWageBuilder  class
        public EmployeeWageBuilder() {
            companies = new ArrayList<>();
        }


        //Assigning to the array
        public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
            companyEmpWage company = new companyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
            companies.add(company);
        }

        //print company wage
        int companyWage(companyEmpWage companyEmpWage) {
            System.out.println("* Total wage of " + companyEmpWage.COMPANY_NAME + " employee:");
            int workingHrs, totalWage = 0;
            for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                    && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
                int empType = generateEmployeeType(); //random value(0,1,2)
                workingHrs = getWorkingHrs(empType); //Full time, Part time or Absent
                int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
                totalWage += wage;
                System.out.print("\n Day " + day + ": Working hrs -" + workingHrs + ", Total Wage -" + wage + ", Total working hour -" + totalWorkingHrs + "\n");
            }
            return totalWage;
        }

        int generateEmployeeType() {
            Random random = new Random();
            return random.nextInt(3);
        }

        int getWorkingHrs(int empType) {
            switch (empType) {
                case 1:
                    return 8; //Full time
                case 2:
                    return 4; //Part time
                default:
                    return 0; //Absent
            }
        }

        public void companyWage() {
            for (companyEmpWage company : companies) //for-each loop
            {
                int totalWage = companyWage(company);
                company.setTotalEmployeeWage(totalWage);
                System.out.println(company); //overriding the toString() method
            }
        }

        //Starting of main method.
        public static void main(String args[]) {
            //Welcome message
            System.out.println("Welcome to Employee Wage Builder. \n");
            EmployeeWageBuilder employee = new EmployeeWageBuilder(); //creating an object and declaring number of companies = 3
            employee.addCompany("Bridgeabz", 20, 20, 100);
            employee.addCompany("TATA", 34, 23, 130);
            employee.addCompany("BAJAJ", 10, 15, 99);
            employee.companyWage();
        }
    }