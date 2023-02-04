import java.util.Scanner;
//import java.util.Arrays;
 
class ConverterRunner
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");
 
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        while (!choice.equals("2") && !choice.equals("8") && !choice.equals("10") && !choice.equals("16"))
        {
            System.out.println("Sorry, this base is not available.");
            System.out.print("Enter the base of your number (2, 8 or 10): ");
            choice = s.nextLine();
        }
 
        System.out.print("Enter your number: ");
        String n = s.nextLine();

        s.close();
 
        NumberConverter nc = new NumberConverter(n, base);


        if(base == 2)
        {
            for (int i = 0; i < n.length(); i ++)
                {
                    while ((Integer.parseInt(n.substring(i,i+1)) > 7) || ((Integer.parseInt(n.substring(i,i+1)) < 0)))
                    {
                        System.out.println("Sorry, this number contains incorrect digit(s) for this base.");
                        System.out.print("Enter your number: ");
                        n = s.nextLine();
                    }
                }
            System.out.println("\nOctal Number: " + nc.genBaseRule(8));
            System.out.println("Decimal Number: " + nc.genBaseRule(10));
            System.out.println("Hexadecimal Number: " + nc.genBaseRule(16));
        }


        else if(base == 8)
        {
            for (int i = 0; i < n.length(); i ++)
                {
                    while ((Integer.parseInt(n.substring(i,i+1)) > 7) || ((Integer.parseInt(n.substring(i,i+1)) < 0)))
                    {
                        System.out.println("Sorry, this number contains incorrect digit(s) for this base.");
                        System.out.print("Enter your number: ");
                        n = s.nextLine();
                    }
                }
            System.out.println("\nBinary Number: " + nc.genBaseRule(2));
            System.out.println("Decimal Number: " + nc.genBaseRule(10));
            System.out.println("Hexadecimal Number: " + nc.genBaseRule(16));
        }
        else if(base == 10)
        {
            for (int i = 0; i < n.length(); i ++)
                {
                    while ((Integer.parseInt(n.substring(i,i+1)) > 9) || ((Integer.parseInt(n.substring(i,i+1)) < 0)))
                    {
                        System.out.println("Sorry, this number contains incorrect digit(s) for this base.");
                        System.out.print("Enter your number: ");
                        n = s.nextLine();
                    }
                }
            System.out.println("\nBinary Number: " + nc.genBaseRule(2));
            System.out.println("Octal Number: " + nc.genBaseRule(8));
            System.out.println("Hexadecimal Number: " + nc.genBaseRule(16));
        }

        else if(base == 16)
        {
            System.out.println("\nBinary Number: " + nc.genBaseRule(2));
            System.out.println("Octal Number: " + nc.genBaseRule(8));
            System.out.println("Decimal Number: " + nc.genBaseRule(10));
        }
    }
}