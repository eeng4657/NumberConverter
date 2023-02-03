import java.util.ArrayList;

public class NumberConverter
{
    String[] digits;
    int base;
    int num;
 
    /*public NumberConverter(int number, int base)
    {
        num = number;
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++)
        {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }*/

    public NumberConverter(String number, int base)
    {
        //String numAsString = number;
        String[] digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++)
        {
            String single = number.substring(i,i+1);
            digits[i] = single;
        }
        this.base = base;
    }
 
    public String displayOriginalNumber()
    {
        String o = "";
        for (int i = 0; i < digits.length; i++)
        {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String genBaseRule(int newBase) //this would work for bases 1 to 64 if it actually worked,can only convert to hexa, can't convert from
    {
        String con = "";
        int i = 0;
        int a = 0;
        String[] tooBased = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        for(int m = 0; m < digits.length; m++) //goes through every value of digits
        {
            for(int k = 0; k < tooBased.length; k++) //every value of tooBased is searched for every value of digits, could be made quicker with if statements
            {
                if(digits[m] == tooBased[k]) //if the current element at index m in digits is the same as the current element at index k in tooBased, the element at index m of digits is replaced k, the index of corresponding value from tooBased
                {
                    digits[m] = Integer.toString(k); //not changing letter to number because its not an arralist, but if i make it an arraylist, the other parts of the method dont work
                }
            }
        }

        while(i < digits.length) //converts to decimal
        {
            a += Integer.parseInt(digits[(digits.length-1)-i])*Math.pow(base, i);
            i++;
        }
        con = Integer.toString(a);
        if (newBase != 10) //converts from decimal
        {
            con = "";
            while (a > 0)
            {
                int c = a % newBase;
                a /= newBase;
                con = tooBased[c] + con;
            }
        }
        return con;
    }


    public String[] getDigits()
    {
        return digits;
    }
 
    public String convertToDecimal()
    {
        return genBaseRule(10);
    }
 
    public String convertToBinary()
    {
        return genBaseRule(2);
    }
 
    public String convertToOctal()
    {
        return genBaseRule(8);
    }

    public String convertToHexa()
    {
        return genBaseRule(16);
    }
}