import java.util.Scanner; 

public class ATM_machine {

    // method to continue if yes or no
    static boolean doContinue(){
        Scanner input = new Scanner(System.in);
        while(true){
            String yesOrNo = input.next();
            if((yesOrNo.equals("y")) || yesOrNo.equals("Y")){
                return true;
            }
            else if((yesOrNo.equals("n")) || yesOrNo.equals("N")){
                return false;
            }
            return false;
        }
    }
    
    // method if you wanna perform another transaction
    static void anotherTransanction(){
        System.out.println("Do you wanna perform another transaction? :\ni. Y for yes\nii. N for no");
        while (true){
            boolean anotherTransanction = true;
            if(doContinue() == anotherTransanction){
            }
            else{
                System.out.println("Take you ATM card.");
                break;
            }
        }        
    }
    

    static int bankBalance = 100000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input your card");
        while(true){ 
            System.out.println("Input pin: ");
            String pin = input.next();
            if(pin.length() == 4){
                System.out.println("Assuming that you have " + bankBalance + " in your account.");
                System.out.println("1. withdrawal\n2. transfer\n3. recharge me \n4. recharge others \n5. end.\n\nInput any of the following number below the perform your desired function: \n");
                String userInput = input.next();  
                if (userInput.equals("1")){
                    withdrawal.withdrawMoney();
                    System.out.println("Do you wanna perform another transaction? :\ni. Y for yes\nii. N for no");
                    boolean anotherTransanction = true;
                    if(doContinue() == anotherTransanction){
                    }
                    else{
                        System.out.println("Take you ATM card.");
                        break;
                    }               
                }
                else if (userInput.equals("2")){   
                    transfer.transferMoney();
                    System.out.println("Do you wanna perform another transaction? :\ni. Y for yes\nii. N for no");
                    boolean anotherTransanction = true;
                    if(doContinue() == anotherTransanction){
                    }
                    else{
                        System.out.println("Take you ATM card.");
                        break;
                    }        
                }
                else if (userInput.equals("3")){
                    rechargeCard.rechargeMySelf();
                    System.out.println("Do you wanna perform another transaction? :\ni. Y for yes\nii. N for no");
                    boolean anotherTransanction = true;
                    if(doContinue() == anotherTransanction){
                    }
                    else{
                        System.out.println("Take you ATM card.");
                        break;
                    }     
                }
                else if (userInput.equals("4")){
                    rechargeCard.rechargeOthers();
                    System.out.println("Do you wanna perform another transaction? :\ni. Y for yes\nii. N for no");
                    boolean anotherTransanction = true;
                    if(doContinue() == anotherTransanction){
                    }
                    else{
                        System.out.println("Take you ATM card.");
                        break;
                    }      
                }
                else if(userInput.equals("5")){
                    break;
                }
                else{
                    System.out.println("Wrong command, Try again.");
                }
            }
            else{
                System.out.println("Incorrect pin, Try again.");
            }
        }
    }
}
 
class withdrawal extends ATM_machine {
    public static void withdrawMoney() {
        Scanner input = new Scanner(System.in);
        System.out.println("How much do you want to withdraw: ");
        int whatIWantToWithdraw = input.nextInt();
        System.out.println("withdrawing " + whatIWantToWithdraw + " now.");
        int balanceAfterWrithdrawal = bankBalance - whatIWantToWithdraw;  
        System.out.println("you now have " + balanceAfterWrithdrawal + ".");
    }
}

class transfer extends ATM_machine{
    public static void transferMoney(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input Ammount: ");
        int amount = input.nextInt();
        System.out.println("Input Recipient Account Number: ");
        while (true){
            String accountNumberOfRecipient = input.next();
            if(accountNumberOfRecipient.length() == 10){
                System.out.println("Input Recipient first name: ");
                String recipientFirstName = input.next();
                System.out.println("Input Recipient last name: ");
                String recipientLastName = input.next();
                int newBalance = bankBalance - amount;
                System.out.println("Successful\nYou just transfered " + amount + " to " + recipientFirstName + " " + recipientLastName + ".\nYour new balance is " + newBalance + ".");
                break;
            }
            else{
                System.out.println("Incorrect, Try again");
            }
        }  
    }
}

class rechargeCard extends ATM_machine{
    public static void rechargeMySelf(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input the ammount for your recharge: ");
        int ammountOfRecharge = input.nextInt();
        System.out.println("Your recharge was Successful.");
    }

    public static void rechargeOthers(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input the ammount of the recharge: ");
        int ammountOfRechargeOthers = input.nextInt();
        System.out.println("Phone Number: ");
        while(true){
            String phoneNumber = input.next();  
            if (phoneNumber.length() == 11 || phoneNumber.length() == 14){
                System.out.println("You Succesfully transfered " + ammountOfRechargeOthers + " to " + phoneNumber + ".");
                break;
            }
            else{
                System.out.println("Incorrect phone number, Try again\nInput Phone Number: ");
            }
        }
    }
}   