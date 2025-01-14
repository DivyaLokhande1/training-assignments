import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class Solid_Principle_Assignment extends PaymentMethod{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("Enter Amount: ");
        Double amount = sc.nextDouble();
        }
        catch(Exception e){
            System.out.println("Error-Enter Valid Numerical amount!");
            System.exit(0);

        }
        PaymentProvider pprovider_object= new PaymentProvider();
        pprovider_object.choosePaymentProvider();

        PaymentMethod pmethod_object = new PaymentMethod();
        pmethod_object.choosePaymentMethod();


    }
}

interface PaymentProviderInterface {
    public void choosePaymentProvider();
}

class PaymentProvider implements PaymentProviderInterface{
    @Override
    public void choosePaymentProvider(){
        Scanner sc = new Scanner(System.in);

        for(int i =3;i>0;){
        System.out.println("Choose a payment provider out of:\n Paytm \n Amazon Pay \n PhonePe");
        String pp_name = sc.nextLine();

        if(pp_name.equalsIgnoreCase("Paytm")||pp_name.equalsIgnoreCase("Amazon Pay") ||pp_name.equalsIgnoreCase("PhonePe")){
            break;}
        else{
        i--;
        System.out.println("You have "+i+" tries \n Enter a valid Provider");
        if(i==0){ System.exit(0);}
        }
        }
    
    }
}

interface PaymentMethodInterface {
    public void choosePaymentMethod();
}

class PaymentMethod implements PaymentMethodInterface {
    @Override
    public void choosePaymentMethod(){
        for(int i =3;i>0;) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose the payment method from options: \n Wallet \n UPI \n Debit Card \n Credit Card");        
            String method_type = sc.nextLine();

        
            if(method_type.equalsIgnoreCase("wallet") ){
                Wallet object = new Wallet();
                object.getinput();
            }else if(method_type.equalsIgnoreCase("UPI")){
                Upi object = new Upi();
                object.getinput();
            }else if(method_type.equalsIgnoreCase("Debit Card")){
                DebitCard object = new DebitCard();
                object.getinput();
            }else if(method_type.equalsIgnoreCase("Credit Card")){
                CreditCard object = new CreditCard();
                object.getinput();
            }else {i--;
                System.out.println("Enter a valid number from 1 to 4 \n you have "+i+"tries left");
                if(i==0){ System.exit(0);}
            }

            
        }
    }
}

interface PaymentDetailsInterface{
    // public void wallet();
    // public void upi();
    // public void debitCard();
    // public void creditCard();
    default boolean checkValidation(String condition,String input){
        Pattern pattern = Pattern.compile(condition);
        Matcher matcher;
        matcher = pattern.matcher(input);
        boolean matchfind = matcher.find();
        return matchfind;  
    }

    public void getinput();
}

class Wallet implements PaymentDetailsInterface{
    Scanner sc = new Scanner(System.in);
    public void getinput(){
        for(int i =3;i>0;) {  
            System.out.println("Enter 10 digit Phone Number:");
            String number = sc.nextLine();
            String condition = "[0-9]{10}";
        
            if(checkValidation(condition, number)){
                System.out.println("\n Payment Successful");
                System.exit(0);
            break;
            }else{
                i--;
                System.out.println("Incorrect format! Enter a 10 digit number \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}
            }
        }
    }
   
}

class Upi implements PaymentDetailsInterface{
    Scanner sc = new Scanner(System.in);
    public void getinput(){
        for(int i =3;i>0;){
            System.out.println("Enter your upi id:");
            String upi = sc.nextLine();
            String condition = "[A-Za-z0-9]+@+[A-Za-z0-9]";


            if(checkValidation(condition, upi)){
                System.out.println("\n Payment Successful");
                System.exit(0);
            break;
            }else{
                i--;
                System.out.println("Incorrect format! Enter Alphanumeric id with '@' in between \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}

            }
        }
    }
}

class DebitCard implements PaymentDetailsInterface{
    Scanner sc = new Scanner(System.in);
    public void getinput(){
        for(int i =3;i>0;) {
        System.out.println("Enter your Debit Card number:");
        String dcn = sc.nextLine();
        String condition ="[0-9]{16}" ;
            if(checkValidation(condition, dcn)){
                // System.out.println("Payment Successful");
            break;
            }else{
                i--;
                System.out.println("Incorrect format! Enter a 16 digit number \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}

            }
        }

        for(int i =3;i>0;) {

            System.out.println("Enter its Expiry in MM/YY:");
            String exp = sc.nextLine();
            String condition ="[0-9]{2}+/+[0-9]{2}";

            int month = Integer.parseInt(exp.substring(0, 1));
            int year = Integer.parseInt(exp.substring(3));
            boolean valid_month = month>0 && month<=12;
            boolean valid_year = year >= 25;

            if(checkValidation(condition, exp) && valid_month && valid_year ){
                // System.out.println("Payment Successful");
            break;
            }else{
                i--;
                System.out.println("Incorrect format! Enter numbers in MM/YY format \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}

            }
        }

        for(int i =3;i>0;) {

            System.out.println("Enter your CVV:");
            String cvv = sc.nextLine();
            String condition = "[0-9]{3}";
            if(checkValidation(condition, cvv)){
                System.out.println("\n Payment Successful");
                System.exit(0);
            }else{
                i--;
                System.out.println("Incorrect format! Enter a 3 digit cvv \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}

            }
        }
    }
}

class CreditCard implements PaymentDetailsInterface{
    Scanner sc = new Scanner(System.in);
    public void getinput(){
        for(int i =3;i>0;) {
            System.out.println("Enter your Credit Card number:");
            String ccn = sc.nextLine();
            String condition ="[0-9]{16}" ;
            if(checkValidation(condition, ccn)){
                // System.out.println("Payment Successful");
            break;
            }else{
                i--;
                System.out.println("Incorrect format! Enter a 16 digit number \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}

            }
        }
    
        for(int i =3;i>0;) {
    
            System.out.println("Enter Expiry in MM/YY:");
            String exp = sc.nextLine();
            String condition ="[0-9]{2}+/+[0-9]{2}";

            int month = Integer.parseInt(exp.substring(0, 1));
            int year = Integer.parseInt(exp.substring(3));
            boolean valid_month = month>0 && month<=12;
            boolean valid_year = year >= 25;

            if(checkValidation(condition, exp) && valid_month && valid_year ){
                // System.out.println("Payment Successful");
            break;
            }else{
                i--;
                System.out.println("Incorrect format! Enter numbers in MM/YY format \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}

            }
        }
    
        for(int i =3;i>0;) {
    
            System.out.println("Enter your CVV:");
            String cvv = sc.nextLine();
            String condition = "[0-9]{3}";
            if(checkValidation(condition, cvv)){
                System.out.println("\n Payment Successful");
                System.exit(0);
            break;
            }else{
                i--;
                System.out.println("Incorrect format \n You have "+i+" tries left!");
                if(i==0){ System.exit(0);}

            }
        }
    }
}
