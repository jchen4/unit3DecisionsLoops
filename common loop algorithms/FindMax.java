import java.util.Scanner;
public class FindMax
{
    /** 
     * finds the maximum value in the specified series of numbers
     */
   public static void main(String[] args)
   {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter a series of numbers (q to quit)");
       
       double currentMax = in.nextDouble();
       
       do
       {
           double value = in.nextDouble();
           if (value > currentMax)
           {
               currentMax = value;
            }
        }
            
       while(in.hasNextDouble());
       System.out.println(currentMax);
   }
}
