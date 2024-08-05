import java.util.Scanner;
class BankAcc{
    String name;
    String username;
    String password;
    String account_number;
    float balance=5000f;
    int transaction=0;
    String transactions_history="";
    
    public void register_acc(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Your Name");
        this.name=sc.nextLine();
        System.out.println("\nEnter Your Username");
        this.username=sc.nextLine();
        System.out.println("\nEnter Your Password");
        this.password=sc.nextLine();
        System.out.println("\nEnter Your Account Number");
        this.account_number=sc.nextLine();
        System.out.println("\nYour Account is registered successfully. Please Log in to get the details of your Bank Account.");

    }
    public boolean signin(){
        boolean is_signin=false;
        Scanner sc=new Scanner(System.in);
        while(!is_signin){
            System.out.println("\nEnter your Username");
            String user_name=sc.nextLine();
            if(user_name.equals(username)){
                while(!is_signin){
                    System.out.println("\nEnter your Password");
                    String password_check=sc.nextLine();
                    if(password_check.equals(password)){
                        System.out.println("\nLogin Successful.");
                        is_signin=true;
                    }
                    else{
                        System.out.println("\n Password is Incorrect");
                    }
                }
            }
            else{
                System.out.println("\nUsername not found");
            }
        }
        return is_signin;
    }
    public void withDraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Amount");
        float amt=sc.nextFloat();
        try{
            if(balance>=amt){
                transaction++;
                balance-=amt;
                System.out.println("\nWithdrawal is successsful.");
                String s=amt+"Rs Withdrawn\n";
                transactions_history=transactions_history.concat(s);
            }
            else{
                System.out.println("\nBalance is not sufficient.");
            }
        }
        catch(Exception e){

        }
    }
    public void Deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Amount  to deposit.");
        float amt=sc.nextFloat();
        try{
            if(amt<=5000f){
                transaction++;
                balance+=amt;
                System.out.println("\nDeposit of amount "+amt+" is successsful.");
                String s=amt+"Rs Deposited\n";
                transactions_history=transactions_history.concat(s);
            }
            else{
                System.out.println("\nThe limit to deposit amount is 5000.");
            }
        }
        catch(Exception e){
            
        }
    }
    public void Transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the name of Receipent.");
        String receipent_name=sc.nextLine();
        System.out.println("\nEnter Amount to send to "+receipent_name+" .");
        float amt=sc.nextFloat();
        try{
            if(balance>=amt){
                if(amt<=50000f){
                transaction++;
                balance-=amt;
                System.out.println("\nTransfer of amount "+amt+" to "+receipent_name+" is successsful.");
                String s=amt+"Rs Transferred to "+receipent_name+"\n";
                transactions_history=transactions_history.concat(s);
            }
            else{
                System.out.println("\nThe limit to transfer amount is 50000.");
            }

        }
            else{
                System.out.println("\nBalance is Insufficient.");
            }
        }
        catch(Exception e){
            
        }
    }
    public void check_balance(){
        System.out.println("\nThe balace is Rs"+balance);
    }
    public void transaction_history(){
        if(transaction==0){
            System.out.println("\nNo transaction done.");
        }
        else{
            System.out.println("\n"+transactions_history);
        }
    }
}

class ATM extends BankAcc{
    public static int takeInput(int lim){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();
                flag=true;

                if(flag && input>lim ||input < 1){
                    System.out.println("Choose the number between 1 to "+lim+" .");
                    flag=false;
                }
            }
            catch(Exception e){
                System.out.println("Enter Integer Value Only.");
            }
        }
        return input;
    }
    public static void main(String args[]){
        System.out.println("\nWELCOME TO ALLAHABAD BANK INTERFACE");
        System.out.println("\nEnter 1-Register\nEnter 2-Quit");
        System.out.println("\nChoose from above given options:");
        int choose=takeInput(2);
        if(choose==1){
            BankAcc bank=new BankAcc();
            bank.register_acc();
            while(true){
                System.out.println("\nEnter 1-Login\nEnter 2-Quit");
                System.out.println("Choose from above given options:");
                int c=takeInput(2);
                if(c==1){
                    if(bank.signin()){
                        System.out.println("\nWELCOME BACK "+bank.name);
                        boolean finished=false;
                        while(!finished){
                            System.out.println("\nEnter 1-Withdraw\nEnter 2-Deposit\nEnter 3-Transfer\nEnter 4-Check Balance\nEnter 5-Transaction History\nEnter 6-Quit");
                            System.out.println("\nChoose from above given options:");
                            int i=takeInput(6);
                            switch(i){
                               case 1:
                               bank.withDraw();
                               break;

                               case 2:
                               bank.Deposit();
                               break;

                               case 3:
                               bank.Transfer();
                               break;

                               case 4:
                               bank.check_balance();
                               break;

                               case 5:
                               bank.transaction_history();
                               break;

                               case 6:
                               finished=true;
                               break;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
            System.exit(0);
        }
    }
}
