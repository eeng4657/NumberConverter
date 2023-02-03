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
 
        System.out.print("Enter your number: ");
        String n = s.nextLine();

        s.close();
 
        NumberConverter nc = new NumberConverter(n, base);


        if(base == 2)
        {
            System.out.println("\nOctal Number: " + nc.genBaseRule(8));
            System.out.println("Decimal Number: " + nc.genBaseRule(10));
            System.out.println("Hexadecimal Number: " + nc.genBaseRule(16));
        }


        else if(base == 8)
        {
            System.out.println("\nBinary Number: " + nc.genBaseRule(2));
            System.out.println("Decimal Number: " + nc.genBaseRule(10));
            System.out.println("Hexadecimal Number: " + nc.genBaseRule(16));
        }


        else if(base == 10)
        {
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