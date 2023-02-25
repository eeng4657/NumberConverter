import java.util.Scanner;
class ConverterRunner
{
    public static void main(String[] args)
    {
        System.out.print("Welcome to the Number Converter!\nWould you like to\n(1) Convert from base to base?\n(2) Convert a number of your choosing to any base of your choosing up to base 64?\nYour choice: ");
        Scanner s = new Scanner(System.in);
        String select = s.nextLine();

        if (select.equals("1"))
        {
            System.out.print("Enter the base of your number (2, 8, 10, or 16): ");
            String choice = s.nextLine();
            int base = Integer.parseInt(choice);
            while (!choice.equals("2") && !choice.equals("8") && !choice.equals("10") && !choice.equals("16"))
            {
                System.out.println("Sorry, this base is not available.");
                System.out.print("Enter the base of your number (2, 8, 10 or 16): ");
                choice = s.nextLine();
            }
    
            System.out.print("Enter your number: ");
            String n = s.nextLine();

            s.close();
    
            NumberConverter nc = new NumberConverter(n, base);
            Scanner scanner = new Scanner(System.in);

            if(base == 2)
            {
                for (int i = 0; i < n.length(); i ++)
                    {
                        while ((Integer.parseInt(n.substring(i,i+1)) > 1) || ((Integer.parseInt(n.substring(i,i+1)) < 0)))
                        {
                            System.out.println("Sorry, this number contains incorrect digit(s) for this base.");
                            System.out.print("Enter your number: ");
                            n = scanner.nextLine();
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
                            n = scanner.nextLine();
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
                            n = scanner.nextLine();
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

        else if (select.equals("2"))
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            String num = scanner.nextLine();
            NumberConverter nc = new NumberConverter(num, 10);
            System.out.print("Enter a desired base: ");
            int base = scanner.nextInt();
            System.out.println("Your number in base " + base + ": " + nc.genBaseRule(base));
        }

        else
        {
            System.out.println("That is not an available choice. Please try again.");
        }
    }
}