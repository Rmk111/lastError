import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class second {
    static boolean ex = false;
        public static String romanMain(String l){
            CharSequence space1 = " ";
            if(l.contains(space1)){
                l = l.replaceAll(" ", "");
            }
            CharSequence[] operator = {"+","-","*","/"};
            String[] oper = {"\\+","-","\\*","/"};
            String mainOperator = "";
            int[] numbers = new int[2];
            for(int i = 0; i< operator.length; i++) {
                if (l.contains(operator[i])) {
                    mainOperator = oper[i];
                    String[] numStr = l.split(mainOperator);
                    numStr[0] = RomanToInt(numStr[0]);
                    numStr[1] = RomanToInt(numStr[1]);
                    numbers[0] = Integer.parseInt(numStr[0]);
                    numbers[1] = Integer.parseInt(numStr[1]);
                    if(numbers[0]<numbers[1] && mainOperator.equals("-")){
                        try{
                            throw new IOException();
                        }catch(IOException e){
                            System.out.println("Roman numbers can't be negative");
                            break;
                        }
                    }
                }
            }
            int output = switch (mainOperator) {
                case "\\+" -> numbers[0] + numbers[1];
                case "-" -> numbers[0] - numbers[1];
                case "/" -> numbers[0] / numbers[1];
                case "\\*" -> numbers[0] * numbers[1];
                default -> 0;
            };
            if(output==0){
                try{
                    throw new IOException();
                }catch(IOException e){
                    System.out.println("Roman number can't be equal to zero");
                    ex = true;
                }
            }
            return IntToRoman(output);
        }

        public static String RomanToInt(String s)
        {
            Map<Character, Integer> map=new HashMap<Character, Integer>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);
            s = s.replace("IV","IIII");
            s = s.replace("IX","VIIII");
            s = s.replace("XL","XXXX");
            s = s.replace("XC","LXXXX");
            int number = 0;
            for (int i = 0; i < s.length(); i++)
            {
                number = number + (map.get(s.charAt(i)));
            }
            return Integer.toString(number);
        }

        public static String IntToRoman(int num)
        {
            int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuilder roman = new StringBuilder();
            for(int i=0;i<values.length;i++)
            {
                while(num >= values[i])
                {
                    num = num - values[i];
                    roman.append(romanLetters[i]);
                }
            }
            return roman.toString();
        }
    }


