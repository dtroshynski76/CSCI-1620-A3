//Name: Donovan Troshynski
//Class: 1620-002
//Program #: 3
//Due Date: 15 October 2015
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,I have neither given nor received unauthorized help on this homework assignment.
//NAME: Donovan Troshynski


//Partners: NONE
//This assignment will implement everything from the first assignment along with an employee manager system which the user can operate to add, delete, or alter different types of employees.

package employeeType.subTypes;
import employeeType.employee.Employee;
import java.util.Scanner;
import java.lang.Math;
public class HourlyEmployee extends Employee
{
    private double wage;
    private double hoursWorked;

    //Method Name: HourlyEmployee
    //Parameters: String fn, ln; char g; int en; double w, h
    //Return value(s): none
    //Partners: None
    //This method sets up the rest of the class by getting the variables from the superclass and initializing any variables need for this class
    public HourlyEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double w)
    {
        super(fn, ln, m, g, empNum, ft);
        wage = w;
    }

    //Method Name: increaseHours
    //Parameters: the increase in hours worked, double
    //Return value(s): the new amount of hours worked, double
    //Partners: None
    //This method calculates the new amount of hours worked based on a certain number of hours already worked plus an input to increase the hours worked. It will prompt the user to re-enter the increase in hours if said increase is negative.
    public void increaseHours(double hours)
    {
        Scanner u = new Scanner(System.in);
        while (hours < 0)
        {
            System.out.print("Increase in hours worked invalid, please re-enter: ");
            hours = u.nextDouble();
        }

        hoursWorked += hours;
    }

    //Method Name: calculateWeeklyPay
    //Parameters: the amount of hours worked, double h, and the set wage, double w
    //Return value(s): the amount to be payed to the HourlyEmployee, double
    //Partners: None
    //This method calculates the amount to be paid to the HourlyEmploye by taking the base pay and multiplying it by the hours worked, with double pay being given for any hours worked over 40
    public double calculateWeeklyPay()
    {
        double overtime = 0.0;
        double regular = 0.0;

        if (hoursWorked > 40)
        {
            regular = 40;
            overtime = (hoursWorked-40);
        }

        if (hoursWorked <= 40)
        {
            regular = hoursWorked;
        }
        
        return ((regular * wage) + ((2 * wage) * overtime));
    }

    //Method Name: annualRaise
    //Parameters: None
    //Return value(s): double, w
    //Partners: None
    //This method calculates the new wage based upon the 5% raise given by multiplying the original wage by .05 then adding that back to the original wage
    public void annualRaise()
    {
        wage = (Math.floor((wage * 1.05) * 100) / 100);
    }

    //Method Name: holidayBonus
    //Parameters: None
    //Return value(s): double
    //Partners: None
    //This method calculates the holiday bonus by multiplying the number of 40 hours worked by the wage
    public double holidayBonus()
    {
        return (wage * 40);
    }

    //Method Name: resetWeek
    //Parameters: None
    //Return value(s): None
    //Partners: None
    //This method resets the number of hours worked back to 0 in preparation for a new week of hours
    public void resetWeek()
    {
        hoursWorked = 0.0;
    }

    //Method Name: toString
    //Parameters: None
    //Return value(s): string
    //Partners: None
    //This method returns the output in the form of the HourlyEmployee's employee number, last name, first name, gender, status, wage, and hours worked
    @Override
    public String toString()
    {
        return String.format("%s%nWage: %.2f%nHours Worked: %.2f%n", super.toString(), wage, hoursWorked);
    }
}//end of class
