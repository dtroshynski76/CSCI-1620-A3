//Name: Donovan Troshynski
//Class: 1620-002
//Program #: 3
//Due Date: 15 October 2015
//Honor Pledge: On my honor as a student of the Univeristy of Nebraska at Omaha,I have neither given nor received unauthorized help on this homework assignment.
//NAME: Donovan Troshynski


//Partners: NONE
//This assignment will implement everything from the first assignment along with an employee manager system which the user can operate to add, delete, or alter different types of employees.

package employeeType.subTypes;
import employeeType.employee.Employee;
import java.util.Scanner;
public class CommissionEmployee extends Employee
{
    private double sales;
    private double rate;

    //Method Name: CommissionEmployee
    //Parameters: String fn, ln; char g; int en; double r, s
    //Return value(s): none
    //Partners: none
    //This method sets up the rest of the class for use of the superclass's methods/variables and renames variables in this class
    public CommissionEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double r)
    {
        super(fn, ln, m, g, empNum, ft);
        rate = r;
    }

    //Method Name: increaseSales
    //Parameters: double s
    //Return value(s): the increase in sales added to current sales, s
    //Partners: None
    //This method will increase the sales amount by a value greater than 0 and add that increase to the current number of sales
    public void increaseSales(double sales)
    {
        Scanner scan = new Scanner(System.in);
        while (sales < 0)
        {
            System.out.print("Increase in sales invalid, please re-enter: ");
            sales = scan.nextInt();
        }

        this.sales = sales;
    }

    //Method Name: calculateWeeklyPay
    //Parameters: none
    //Return value(s): the percent of sales commissioned, per
    //Partners: None
    //This method will calculate the pay going to the CommissionEmployee by multiplying the commission rate by the number of sales
    public double calculateWeeklyPay()
    {
        return ((rate/100) * sales);
    }

    //Method Name: annualRaise
    //Parameters: none
    //Return value(s): the increased commission rate, a double
    //Partners: None
    //This method will apply the annual raise amount of 0.2% to the commission rate
    public void annualRaise()
    {
        rate += 0.2;
    }

    //Method Name: holidaybonus
    //Parameters: none
    //Return value(s): the bonus amount, a double
    //Partners: none
    //This method will return the bonus amount for the CommissionEmployee (in this case, zero)
    public double holidayBonus()
    {
        return 0.00;
    }

    //Method Name: resetWeek
    //Parameters: none
    //Return value(s): none
    //Partners: None
    //This method will reset all sales to 0 to prepare for a new week of sales
    public void resetWeek()
    {
        sales = 0.00;
    }

    //Method Name: toString()
    //Parameters: none
    //Return value(s): the output, a string
    //Partners: None
    //This method will return the string output of the CommissionEmployee's employeeNumber, firstName, lastName, gender, status, sales rate, and number of sales
    @Override
    public String toString()
    {
        return String.format("%s%nRate: %.2f%nSales: %.2f%n", super.toString(), rate, sales);
    }
} //end of class
