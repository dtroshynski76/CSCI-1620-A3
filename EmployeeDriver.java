import java.util.Scanner;
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.SalaryEmployee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.employee.Employee;
import exceptions.InvalidCharacterException;

public class EmployeeDriver
{
    static Scanner in = new Scanner(System.in);
    public static int menu(String... options)
    {
        int choice;
        for(int line = 0; line < options.length; line++)
            System.out.printf("%d. %s\n", line+1,options[line]);
        do
        {
            System.out.print("Enter Choice: ");
            choice = in.nextInt();
        }while(!(choice > 0 && choice <= options.length));
        return choice;
    }

    public static void main(String args[])
    {
        int mainInput;//Input for main menu
        int subInput1;//Input for submenu
        int subInput2;//Input for sub-submenu
        int en;          //Inputting an employee number
        int index;
        double amount;
        EmployeeManager em = new EmployeeManager(); //The EmployeManager object

        //Main control loop, keep coming back to the
        //Main menu after each selection is finished
        do
        {
            //This is the main menu. Displays menu 
            //and asks for a choice, validaties that
            //what is entered is a valid choice
            System.out.println("\n\nMain Menu\n");
            em.listAll();
            mainInput = menu("Employee Submenu", "Add Employee", "Remove Employee", "Calculate Weekly Payout", "Calculate Bonus", "Annual Raises", "Reset Week", "Find Employee", "Quit");
            //Perform the correct action based upon Main menu input
            switch(mainInput)
            {
                //Employee Submenu
                case 1:
                    do
                    {
                        subInput1 = menu("Hourly Employees", "Salary Employee", "Comission Employees", "Back");
                        switch(subInput1)
                        {
                            case 1:
                                em.listHourly();
                                do
                                {
                                    subInput2 = menu("Add Hours", "Back");
                                    if( subInput2 == 1)
                                    {
                                        System.out.println("Employee Number: ");
                                        en = in.nextInt();
                                        index = em.getIndex(en);
                                        if(index != -1)
                                        {
                                            System.out.print("Enter Hours: ");
                                            amount = in.nextDouble();
                                            em.increaseHours(index, amount);
                                        }
                                        else
                                        {
                                            System.out.println("Employee not found!");
                                        }
                                    }
                                }while(subInput2 != 2);
                                break;
                            case 2:
                                em.listSalary();
                                subInput2 = menu("Back");
                                break;
                            case 3:
                                em.listCommission();
                                do
                                {
                                    subInput2 = menu("Add Sales", "Back");
                                    if( subInput2 == 1)
                                    {
                                        System.out.println("Employee Number: ");
                                        en = in.nextInt();
                                        index = em.getIndex(en);
                                        if(index != -1)
                                        {
                                            System.out.print("Enter Sales: ");
                                            amount = in.nextDouble();
                                            em.increaseSales(index, amount);
                                        }
                                        else
                                        {
                                            System.out.println("Employee not found!");
                                        }
                                    }
                                }while(subInput2 != 2);
                                break;
                        }
                    }while(subInput1 != 4);
                    break;
                    //Add Employee
                case 2:
                    String fn, ln;
                    char mi, g, f;
                    boolean ft = true;
                    subInput1 = menu("Hourly", "Salary", "Commission");
                    System.out.print("Enter Last Name: ");
                    ln = in.next();
                    System.out.print("Enter First Name: ");
                    fn = in.next();
                    System.out.print("Enter Middle Initial: ");
                    mi = in.next().charAt(0);
                    System.out.print("Enter Gender: ");
                    g = in.next().charAt(0);
                    System.out.print("Enter Employee Number: ");
                    en = in.nextInt();
                    System.out.print("Full Time? (y/n): ");
                    f = in.next().charAt(0);
                    if(f == 'n' || f == 'N')
                    {
                        ft = false;
                    }
                    if(subInput1 == 1)
                    {
                        System.out.print("Enter wage: ");
                    }
                    else if(subInput1 == 2)
                    {
                        System.out.print("Enter salary: ");
                    }
                    else
                    {
                        System.out.print("Enter rate: ");
                    }
                    amount = in.nextDouble();

                    em.addEmployee(subInput1, fn, ln , mi, g, en, ft, amount);
                    break;

                    //Remove Employee
                case 3:
                    System.out.print("Enter Employee Number to Remove: ");
                    en = in.nextInt();
                    index = em.getIndex(en);
                    em.removeEmployee(index);
                    break;

                    //Calculate Weekly Payout
                case 4:
                    System.out.printf("Total weekly payout is %.2f\n", em.calculatePayout());
                    break;

                    //Calculate Bonus
                case 5:
                    amount = em.holidayBonuses();
                    System.out.printf("Total holiday bonus payout is %.2f\n", amount);
                    break;

                    //Apply Annual Raises
                case 6:
                    em.annualRaises();
                    System.out.println("Annual Raises applied.");
                    break;

                    //Reset the weeks values
                case 7:
                    em.resetWeek();
                    System.out.println("Weekly values reset.");
                    break;

                    //Find Employee
                case 8:
                    System.out.print("Enter substring of Employee name: ");
                    String substring = in.next();
                    Employee[] ret = null;
                    try
                    {
                        ret = em.findAllBySubstring(substring);
                    }
                    catch(InvalidCharacterException ICE)
                    {
                        System.out.println("Invalid character found in search");
                        break;
                    }
                    System.out.println("Matches found:");
                    if(ret != null)
                        for(int i = 0; i < ret.length && ret[i] != null; i++)
                            System.out.println(ret[i]);
                    break;

                    //Exit
                case 9:
                    System.out.println("\nThank you for using the Employee Manager!\n");
            }
                                                                                                                                            }while(mainInput != 9);
    }
}
