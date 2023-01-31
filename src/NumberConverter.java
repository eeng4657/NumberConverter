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
        int i = 0;
        while (i < displayOriginalNumber().length() - 1)
        {
            int a = (Integer.parseInt(displayOriginalNumber().substring(displayOriginalNumber().length() - (displayOriginalNumber().length() - (1 + i)),displayOriginalNumber().length() - (1 + i)))) * (int)Math.pow(base, i);
            con += a;
            i++;
            //havent tested yet, need to test
        }
        if (newBase != 10)
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
 
    public int[] convertToDecimal()
    {
        return null;
    }
 
    public String convertToBinary()
    {
        String bi = "";
        if(base == 10)
        {
            bi = genBaseRule(2);
        }
        return bi;
    }
 
    public String convertToOctal()
    {
        String oct = "";
        if(base == 10)
        {
            oct = genBaseRule(8);
        }
        return oct;
    }
}