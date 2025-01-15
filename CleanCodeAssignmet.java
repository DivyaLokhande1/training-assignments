import java.util.ArrayList;
import java.util.Scanner;

public class CleanCodeAssignmet {

   static ArrayList<String> list = new ArrayList<String>();

    private static void takeInput(){
        Scanner sc = new Scanner(System.in);
        boolean confirm_project= true;
        
        do{
            System.out.println("Do you want to enter new project details? (yes/no):");
            String input_project = sc.next();

            if(input_project.equalsIgnoreCase("yes")) {
                confirm_project= true;
                takeManagerDetails();
                boolean confirm_employee = true;
                do{
                System.out.println("Do you want to enter new Employee details? (yes/no):");
                String input_employee = sc.next();
                    if(input_employee.equalsIgnoreCase("yes")) {
                        takeEmployeeDetails();
                        confirm_employee = true;
                    }
                    else if(input_employee.equalsIgnoreCase("no")){
                        confirm_employee = false;
                    }
                    else {
                        System.out.println("Enter valid input");
                    }
                }while(confirm_employee);
            }
            else if(input_project.equalsIgnoreCase("no")){
                confirm_project= false;
            }
            else {
                System.out.println("Enter valid input");
            }
        }while(confirm_project);
    }


    private static void takeManagerDetails(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Manager's name:");
        String manager_name = sc.nextLine();
        list.add("Manager name: "+manager_name);

        System.out.println("Enter the Project name:");
        String project_name = sc.nextLine();
        list.add("Project: "+project_name);
    }

    private static void takeEmployeeDetails(){
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter the Employee's First name:");
         String first_name = sc.nextLine();
         System.out.println("Enter the Employee's Last name:");
         String last_name = sc.nextLine();
         list.add("Employee name: "+first_name+" "+last_name);
         System.out.println("Enter the Employee's Designation:");
         String designation = sc.nextLine();
         list.add("Designation: "+designation);
         
         list.add("Address: "+takeAddress());
     }

    private static String takeAddress(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Employee's Address Details:");
        
        System.out.println("Houseno.:");
        String address = sc.nextLine();

        System.out.println("Street Name:");
        address = address.concat(", "+sc.nextLine());

        System.out.println("City:");
        address = address.concat(", "+sc.nextLine());
        

        System.out.println("Pincode:");
        address = address.concat(", "+sc.nextLine());

        System.out.println("State:");
        address = address.concat(", "+sc.nextLine());

        return address;

    }

    private static void displayDetails(){
        System.out.println("\n Here is the list of all the Managers, and employees under them:");
        int i=0;
       while (i < list.size() && list.get(i)!=null) {
        System.out.println(list.get(i));
        i++;
       }
    }
    
    public static void main(String[] args) {

        takeInput();        //Takes input untill User says 'no'
        displayDetails();   // Displays the details entered.
    }
    
}
