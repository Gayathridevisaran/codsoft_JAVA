import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber
{
  public static void main(String args[])
  {
    Scanner scanner=new Scanner(System.in);
    Random random= new Random();
    
    int minRange=1;
    int maxRange=100;
    int maxAttempts=5;
    int score=0;

    boolean playAgain=true;
    while(playAgain)
    {
      int randomNumber=random.nextInt(maxRange-minRange+1) + minRange;
      int attempts=0;

      System.out.println("Guess a number between"+minRange+"and"+maxRange+".");

      while(attempts<maxAttempts)
      {
        System.out.println("Enter your guess:");
        int userGuess=scanner.nextInt();
        attempts++;

        if(userGuess==randomNumber)
        {
          System.out.println("Congratulations! You guessed the correct number in" + attempts +" attempts.");
          score+=maxAttempts-attempts+1;
          break;
        }
        else if(userGuess<randomNumber)
        {
          System.out.println("Too low! Try again.");
        }
        else
        {
          System.out.println("Too high! Try again.");
        }
  
        if(attempts==maxAttempts)
        {
          System.out.println("Sorry,you've reached the maximum number of attempts. The correct number was:" + randomNumber);
        }
     }
  
     System.out.println("Do you want to play again? (yes/no):");
     String playAgainResponse = scanner.next().toLowerCase();
     if(!playAgainResponse.equals("yes"))
     {
       playAgain = false;
     }
   }

   System.out.println("Your total score is:"+score);
   scanner.close();
 }
}