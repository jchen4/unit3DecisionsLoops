import java.util.Scanner;
public class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = s.nextInt();
        
        int fOne = 1;
        int fTwo = 1;
        int fThree = fOne+fTwo;
        for (int i = 4; i <= n; i++)
        {
            fOne = fTwo;
            fTwo = fThree;
            fThree = fOne+fTwo;

        }
        System.out.println(fThree);
    }
}