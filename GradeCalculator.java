import java.util.Scanner;
public class GradeCalculator
{
  public static void main(String args [])
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of subjects:");
    int numSubjects = scanner.nextInt();
    int totalMarks = 0;
    for(int i = 1; i<=numSubjects; i++)
    {
      System.out.println("Enter marks obtained in subject"+i+":");
      int marks = scanner.nextInt();
      totalMarks += marks;
    }
    double averagePercentage = (double) totalMarks / numSubjects;
    char grade = calculateGrade(averagePercentage);
    System.out.println("Average Percentage:"+averagePercentage + "%");
    System.out.println("Grade:"+grade);
    scanner.close();
  }

  public static char calculateGrade(double percentage)
  {
    if(percentage >= 90)
    {
      return 'A';
    }
    else if(percentage >= 80)
    {  
      return 'B';
    }
    else if(percentage >= 70)
    {
      return 'C';
    }
    else if(percentage >= 60)
    {
      return 'D';
    }
    else
    {
      return 'F';
    }
  }
}
