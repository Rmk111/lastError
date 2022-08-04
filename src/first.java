import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.Scanner;

public class first {
    static boolean ex1 = false;
    static CharSequence[] operator = {"+","-","*","/"};
    static char[] operants ={'+','-','/','*'};
        public static void main(String[] args) throws NullPointerException {
            Scanner scanner = new Scanner(System.in);
            CharSequence[] romanNumeric = {"I", "V", "X", "L", "C", "D", "M"};
            CharSequence[] exception = {"(",")","1","2","3","4","5","6","7","8","9","+","-","*","/"};
            while(true) {
                int count = 0;
                boolean RomanNum = false;
                boolean ArabicNum = false;
                boolean ArabicAdditionalBool = false;
                String input = scanner.nextLine();
                for(int z = 0; z<input.length();z++){
                    for(int x = 0; x<operants.length;x++) {
                        if(input.charAt(z)==operants[x]){
                            count++;
                        }
                    }
                }
                if(count>=2){
                    try{
                        throw new IOException();
                    }catch(IOException e){
                        System.out.println("Your string can't contain several operants");
                        break;
                    }
                }
                if(!(input.contains(exception[11]))&&!(input.contains(exception[12]))&&!(input.contains(exception[13]))&&!(input.contains(exception[14]))) {
                    ArabicAdditionalBool = true;
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Not supported");
                    }
                    break;
                }
                for (CharSequence charSequence : romanNumeric) {
                    if (input.contains(charSequence)) {
                        RomanNum = true;
                        for (int n = 2; n < 11; n++) {
                            if (input.contains(exception[n])) {
                                try {
                                    throw new IOException();
                                } catch (IOException ignored) {
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                if(input.charAt(0)=='-'){
                    try {
                        throw new IOException();
                    }catch (IOException e){
                        System.out.println("Romans system has no negative numbers");
                        break;
                    }
                }

                if(!RomanNum){
                    ArabicNum = true;
                }
                if (RomanNum) {
                    try {
                        String resultRoma = second.romanMain(input);
                        if(second.ex){
                            try{
                                throw new IOException();
                            }catch(IOException e){
                                break;
                            }
                        }
                        System.out.println(second.romanMain(input));
                    }catch (NullPointerException e){
                        System.out.println("NullPointerException");
                    }
                } else {
                    String result = toSolve(input);
                    if(ex1){
                        try{
                            throw new IOException();
                        }catch(IOException e){
                            break;
                        }
                    }
                    System.out.println(result);
                }
            }
        }
        public static String toSolve(String given){
            CharSequence space = " ";
            if(given.contains(space)){
                given = given.replaceAll(" ", "");
            }
            CharSequence[] operator = {"+","-","*","/"};
            String[] operators = {"\\+","-","\\*","/"};
            String mainOperator = "";
            int[] numbers = new int[2];
            for(int i = 0; i< operator.length; i++) {
                if (given.contains(operator[i])) {
                    mainOperator = operators[i];
                    String[] numStr = given.split(mainOperator);
                    numbers[0] = Integer.parseInt(numStr[0]);
                    numbers[1] = Integer.parseInt(numStr[1]);
                }
            }
            if(numbers[0]>10||numbers[1]>10){
                ex1 = true;
                try{
                    throw new IOException();
                }catch(IOException e){
                    System.out.println("numbers can't be bigger than 10");
                }
            }
            if(numbers[0]<=0||numbers[1]<=0){
                ex1 = true;
                try{
                    throw new IOException();
                }catch(IOException e){
                    System.out.println("numbers can't be smaller than 1");
                }
            }
            int output = switch (mainOperator) {
                case "\\+" -> numbers[0] + numbers[1];
                case "-" -> numbers[0] - numbers[1];
                case "/" -> numbers[0] / numbers[1];
                case "\\*" -> numbers[0] * numbers[1];
                default -> 0;
            };
            return Integer.toString(output);
        }


    }
