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

    public String genBase10(int newBase)
    {
        String con = "";
        while(num > 0)
            {
                int i = num % newBase;
                num /= newBase;
                con = i + con;
            }
        return con;
    }
 
    public int[] getDigits()
    {
        return digits;
    }
 
    public int[] convertToDecimal()
    {
        return null;
    }
 
    public String convertToBinary()
    {
        String bi = "";
        if(base == 10)
        {
            bi = genBase10(2);
        }
        return bi;
    }
 
    public String convertToOctal()
    {
        String oct = "";
        if(base == 10)
        {
            oct = genBase10(8);
        }
        return oct;
    }
}