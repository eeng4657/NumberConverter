public class NumberConverter
{
    int[] digits;
    int base;
    int num;
 
    public NumberConverter(int number, int base)
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


    public String genBaseRule(int newBase)
    {
        String con = "";
        int i = 1;
        int a = 0;
        while (i < digits.length) //converts to decimal, incomplete //13base10 should return 1101base2, returns 11013 rn
        {
            a += digits[digits.length - i]*(Math.pow(base, i-1));  //sum of each digit times the original base to the power of the digit number
            con += a;
            i++;
        }
        if (newBase != 10)  //converts from decimal
        {
            while (num > 0)
            {
                int b = num % newBase;
                num /= newBase;
                con = b + con;
            }
        }
        return con;
    }
 
    public int[] getDigits()
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
        return genBaseRule(0);
    }
}
