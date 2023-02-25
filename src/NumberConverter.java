import java.util.ArrayList;
public class NumberConverter
{
    ArrayList<String> digits;
    int base;
    int num;

    public NumberConverter(String number, int base)
    {
        digits = new ArrayList<String>();
        for (int i = 0; i < number.length(); i++)
        {
            digits.add(number.substring(i,i+1));
        }
        this.base = base;
    }
 
    public String displayOriginalNumber()
    {
        String o = "";
        for (int i = 0; i < digits.size(); i++)
        {
            o = o + digits.get(i);
        }
        o = o + "\n";
        return o;
    }

    public String genBaseRule(int newBase)
    {
        String con = "";
        int i = 0;
        int a = 0;
        String[] tooBased = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        for(int m = 0; m < digits.size(); m++)
        {
            for(int k = 0; k < tooBased.length; k++)
            {
                if(digits.get(m).equals(tooBased[k]))
                {
                    digits.set(m,Integer.toString(k));
                }
            }
        }

        while(i < digits.size())
        {
            a += Integer.parseInt(digits.get((digits.size()-1)-i))*Math.pow(base, i);
            i++;
        }
        con = Integer.toString(a);
        if (newBase != 10)
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

    public ArrayList<String> getDigits()
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