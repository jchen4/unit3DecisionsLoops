import java.util.Scanner;
public class FindsFirstMatch
{
    /**
     * Finds the index of the first space in the string.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter a string: ");
        String input = in.nextLine();
        
        boolean found = false;
        int index = -1;
        
        while (!found && index < input.length())
        {
            char ch = input.charAt(index);
            if (ch == ' ')
            {
                found = true;
            }
            else
            {
                index++;
            }
        }
        
        if (found)
        {
        System.out.println(index);
    }
}
}