import java.util.Scanner;
import java.util.Arrays;
 
class ConverterRunner
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");
 
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
 
        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);
 
        s.close();
 
        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();


        if(base == 2)
        {
            System.out.println("\nOctal Number: " + nc.genBaseRule(8));
            System.out.println("Decimal Number: " + nc.genBaseRule(10));
        }


        else if(base == 8)
        {
            System.out.println("\nBinary Number: " + nc.genBaseRule(2));
            System.out.println("Decimal Number: " + nc.genBaseRule(10));
        }


        else if(base == 10)
        {
            System.out.println("\nBinary Number: " + nc.genBaseRule(2));
            System.out.println("Octal Number: " + nc.genBaseRule(8));
        }


        System.out.println("\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
    }
}