import java.util.Scanner;
class BankAccount
{
  private double balance;
  private BankAccount(double balance)
  {
    this.balance = balance;
  }

  public boolean deposit(double amount)
  {
    if(amount > 0)
    {
      this.balance += amount;
      return true;
    }
    else
    {
      System.out.println("Invalid amount. Please enter a positive number.");
      return false;
    }
  }
  
  public boolean withdraw(double amount)
  {
    if(amount > 0 && this.balance >= amount)
    {
      this.balance -= amount;
      return true;
    }
    else if(amount > this.balance)
    {
      System.out.println("Insufficient funds.");
      return false;
    }
    else
    { 
      System.out.println("Invalind amount. Please enter a positive number.");
      return false;
    }
  }
  
  public void checkBalance()
  {
    System.out.println("Your balance is: $" + this.balance);
  }
}

class ATM
{
  private BankAccount account;
  private Scanner scanner;
  public ATM(BankAccount account)
  {
    this.account = account;
    this.scanner = new Scanner(System.in);
  }
   
  public void displayMenu()
  {
    System.out.println("Welcome to the ATM");
    System.out.println("1. Withdraw");
    System.out.println("2. Deposit");
    System.out.println("3. Check Balance");
    System.out.println("4. Exit");
  }

  public void run()
  {
    while (true)
    { 
      displayMenu();
      System.out.println("Please select an option:");
      String choice = scanner.nextLine();
   
      switch(choice)
      {
        case "1":
          System.out.println("Enter amount to withdraw:");
          double withdrawAmount = Double.parseDouble(scanner.nextLine());
          if(account.withdraw(withdrawAmount))
          {
            System.out.println("Withdrawl of $" + withdrawAmount + "successful.");
          }
          else
          {
            System.out.println("Withdrawl failed.");
          }
          break;
       case "2":
          System.out.println("Enter amount to deposit:");
          double depositAmount = Double.parseDouble(scanner.nextLine());
          if(account.deposit(depositAmount))
          {
            System.out.println("Deposit of $" + depositAmount + "successful.");
          }
          else            
          {   
            System.out.println("Deposit failed.");
          }
          break;
       case "3":
          account.checkBalance();
          break;
       case "4":
          System.out.println("Thank you for using the ATM. Goodbye!");
          scanner.close();
          return;
       default:
          System.out.println("Invalid choice.Please try again.");
          break;
      }
    }
  }
}

public class ATMInterface
{
  public static void main(String args[])
  {
    BankAccount account = new BankAccount(1000); //Starting balance of $1000
    ATM atm = new ATM(account);
    atm.run();
  }
}