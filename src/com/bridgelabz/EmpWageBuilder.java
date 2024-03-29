/*Ability to get the
Total Wage when
queried by Company - Create Method in
EmpWageBuilder to get total
wage by Company
*/
package com.bridgelabz;
import com.bridgelabz.IEmpWageBuilder;
import com.bridgelabz.companyEmpWage;

import java.util.Random;
import java.util.ArrayList;//importing ArrayList class
import java.util.HashMap;// importing hasmap from package
import java.util.Scanner;

public class EmpWageBuilder  implements IEmpWageBuilder {
    // instance variables
    int noOfCompanies, index;
    ArrayList<companyEmpWage> companies; //ArrayList declaration
    //hasmap Declaration using variable String=company name,Integer is FullMonthWage
    HashMap<String, Integer> fullDailyWage;
    static HashMap<String, Integer> fullTotalWage;
    // contructor for EmpWageBuilder  class
    public EmpWageBuilder(){
        companies=new ArrayList<>();//arrylist
        fullDailyWage = new HashMap<>(); //Hash Map for daily wage
        fullTotalWage = new HashMap<>(); //Hash Map for total wage
    }
    //Assigning to the array and hashmap
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        companyEmpWage company = new companyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        fullDailyWage.put(companyName,0);
        fullTotalWage.put(companyName,0);
        companies.add(company);


    }
    //print company wage
    int companyWage(companyEmpWage companyEmpWage) {
        System.out.println("* Total wage of " + companyEmpWage.COMPANY_NAME + " employee:\n");
        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
            int empType = generateEmployeeType(); //random value(0,1,2)
            workingHrs = getWorkingHrs(empType); //Full time, Part time or Absent
            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
            fullDailyWage.put(companyEmpWage.COMPANY_NAME, wage); // insert an entry in the map. V put(Object key, Object value)
            totalWage += wage;
            System.out.print("* Day "+day+": Working hrs -"+workingHrs+", Total Wage -"+ wage+", Total working hour -" +totalWorkingHrs +"\n");
            System.out.println(" * DailyWage:");
            printotalwage();
        }
        fullTotalWage.put(companyEmpWage.COMPANY_NAME, totalWage); // insert an entry in the map. V put(Object key, Object value)
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
    public  void printotalwage(){
        for (String companyName : fullDailyWage.keySet()) //Returns a Set view of the keys contained in this map
            System.out.print("* "+companyName + " company daily wage per emp : " + fullDailyWage.get(companyName)+"\n");//Get method to get the value of key value.
        System.out.println("                                                                 ");
    }
    public static int getTotalEmpWage(String companyName) {
        return fullTotalWage.get(companyName);
    }

    //Starting of main method.


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //Welcome message
        System.out.println("Welcome to Employee Wage Builder. \n");
        EmpWageBuilder emp = new EmpWageBuilder(); //creating an object and declaring number of companies = 3
        emp.addCompany("Bridgelabz", 20, 20, 100);
        emp.addCompany("TATA", 34, 23, 130);
        emp.addCompany("BAJAJ", 10, 15, 99);
        emp.printotalwage();
        emp.companyWage();
        System.out.println("Enter company name to get TotalWage( Bridgelabz ,TATA, BAJAJ ) :");
        String comp =sc.nextLine();
        int totalWage =EmpWageBuilder.getTotalEmpWage(comp);
        System.out.println("The Total Wage of employee for " + comp + " Company is " + totalWage + " for this month.");

    }
}