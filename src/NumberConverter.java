import java.util.ArrayList;

public class NumberConverter
{
    ArrayList<String> digits;
    int base;
    int num;

    public NumberConverter(String number, int base)
    {
        //String[] digits = new String[number.length()]; (old array)
        /*ArrayList <String>*/ digits = new ArrayList<String>();
        for (int i = 0; i < number.length(); i++)
        {
            //String single = number.substring(i,i+1);
            digits.add(number.substring(i,i+1));
        }
        this.base = base;
    }

    public NumberConverter(String number)
    {
        digits = new ArrayList<String>();
        for (int i = 0; i < number.length(); i++)
        {
            digits.add(number.substring(i,i+1));
        }
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

    public String genBaseRule(int newBase) //this would work for bases 1 to 64 if it actually worked,can only convert to hexa, can't convert from
    {
        String con = "";
        int i = 0;
        int a = 0;
        String[] tooBased = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};


        for(int m = 0; m < digits.size(); m++) //goes through every value of digits
        {
            for(int k = 0; k < tooBased.length; k++) //every value of tooBased is searched for every value of digits, could be made quicker with if statements
            {
                if(digits.get(m).equals(tooBased[k])) //if the current element at index m in digits is the same as the current element at index k in tooBased, the element at index m of digits is replaced k, the index of corresponding value from tooBased
                {
                    digits.set(m,Integer.toString(k));//not changing letter to number
                }
            }
        }


        while(i < digits.size()) //converts to decimal
        {
            a += Integer.parseInt(digits.get((digits.size()-1)-i))*Math.pow(base, i);
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

    public String anyBase(String first, int destBase)
    {
        String[] allBases = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
        String str = "";
        while (Integer.parseInt(first) > 0)
        {
            int i = Integer.parseInt(first) % destBase;
            first = Integer.toString(Integer.parseInt(first) / destBase);
            str = allBases[i] + str;
        }
        return str;
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