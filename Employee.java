//Name:
//Class: 1620-002
//Program #: 3
//Due Date: 15 October 2015
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,I have neither given nor received unauthorized help on this homework assignment.
//NAME:


//Partners: NONE
//This assignment will implement everything from the first assignment with the addition of an employee manager system, with which the user can add, delete, or alter employees however he/she wishes. It will make use of abstract classes and methods along with polymorphism and downcasting.

package employeeType.employee;
import java.util.Scanner;
public abstract class Employee
{
    private String firstName;
    private String lastName;
    private char gender;
    private int employeeNum;
    private char middleInitial;
    private boolean fulltime;

    //Method Name: Employee
    //Parameters: string fn, ln; char m, g; int empNum; boolean ft
    //Return value(s): none
    //Partners: None
    //This method sets up and uses the rest of the methods in the superclass Employee
    public Employee(String fn, String ln, char m, char g, int empNum, boolean ft)
    {
        setFirstName( fn );
        setLastName( ln );
        setGender( g );
        setEmployeeNumber( empNum );
        setMiddleI(m);
        fulltime = ft;
    }

    //Method Name: setFirstName
    //Parameters: string fn, the first name of the employee
    //Return value(s): none
    //Partners: None
    //This method assigns the private variable firstName to a shorter version (fn)
    public void setFirstName(String fn)
    {
        firstName = fn;
    }

    //Method Name: getFirstName
    //Parameters: none
    //Return value(s): string firstName
    //Partners: None
    //This method returns the first name of the employe, allowing its use in each subclass
    public String getFirstName()
    {
        return firstName;
    }

    //Method Name: setLastName
    //Parameters: string ln, the last name of the employee
    //Return value(s): none
    //Partners: None
    //This method sets the private variable lastName as a shorter version (ln)
    public void setLastName(String ln)
    {
        lastName = ln;
    }

    //Method Name: getLastName
    //Parameters: none
    //Return value(s): string lastName
    //Partners: None
    //This method returns the last name of the employee, allowing its use in the subclasses
    public String getLastName()
    {
        return lastName;
    }

    //Method Name: getMiddleInitial
    //Parameters: none
    //Return value(s): char middleInitial, the middle initial of the employee
    //Partners: None
    //This method returns the middle initial of the employee, allowing its use in the subclasses
    public char getMiddleInitial()
    {
        return middleInitial;
    }

    //Method Name: setMiddleI
    //Parameters: char m, the middle initial of the employee
    //Return value(s): none
    //Partners: None
    //This method sets the private variable middleInitial as a shorter version of itself (m)
    public void setMiddleI(char m)
    {
        middleInitial = m;
    }

    //Method Name: setGender
    //Parameters: char g, the gender of the employee
    //Return value(s): none
    //Partners: None
    //This method sets the gender of each employee, only allowing the gender to be set if it's a capital "M" or capital "F" and defaulting to a capital "F" if the variable g is anything else
    public void setGender(char g)
    {
        switch( g ) {
            case 'M':
                gender = g;
            break;
            case 'F':
                gender = g;
            break;
            default:
                gender = 'F';
            break;
        }
    }

    //Method Name: getGender
    //Parameters: none
    //Return value(s): char gender, the gender of the employee
    //Partners: None
    //This method returns the gender of the employee, allowing its use in the subclasses
    public char getGender()
    {
        return gender;
    }

    //Method Name: setEmployeeNumber
    //Parameters: int empNum, the unique employee number of each employee
    //Return value(s): none
    //Partners: None
    //This method sets the employee number, checking whether it's a valid employee number, returning an error if it isn't, and allowing for re-entry until a valid employee number is received
    public void setEmployeeNumber(int empNum)
    {
        Scanner scan = new Scanner(System.in);
        while (empNum <= 10000 || empNum >= 99999)
        {
            System.out.println("Employee Number invalid, please re-enter:");
            empNum = scan.nextInt();
        }

        employeeNum = empNum;
    }

    //Method Name: getEmployeeNumber
    //Parameters: none
    //Return value(s): int employeeNum, the employee number for each employee
    //Partners: None
    //This method returns the valid employee number, allowing for its use in the subclasses
    public int getEmployeeNumber()
    {
        return employeeNum;
    }

    //Method Name: equals
    //Parameters: Object e2
    //Return value(s): boolean true or false
    //Partners: None
    //This method checks to see if the employee number of two employees are equal to each other or not, if they are it returns a true value and if they aren't it returns false
    @Override
    public boolean equals(Object e2)
    {
        if (this.employeeNum == ((Employee)e2).employeeNum)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Method Name: toString
    //Parameters: none
    //Return value(s): String.format
    //Partners: None
    //This method returns part of the output for each employee, allowing the subclasses to add in their specific information relevant to each type of employee
    @Override
    public String toString()
    {
        String status = "Part Time";
        if (fulltime)
        {
            status = "Full Time";
        }
        return String.format("%d%n%s, %s %s.%nGender: %s%nStatus: %s", getEmployeeNumber(), getLastName(), getFirstName(), getMiddleInitial(), getGender(), status);
    }

    //abstract methods to be implemented by the subclasses
    public abstract double calculateWeeklyPay();
    public abstract void annualRaise();
    public abstract double holidayBonus();
    public abstract void resetWeek();
} //end of class
