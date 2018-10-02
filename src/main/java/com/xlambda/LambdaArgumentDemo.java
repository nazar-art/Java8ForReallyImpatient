package com.xlambda;

@FunctionalInterface
interface StringFunc {
    String func(String str);
}

public class LambdaArgumentDemo {

    static String changeStr(StringFunc stringFunc, String stringToChange) {
        return stringFunc.func(stringToChange);
    }

    public static void main(String[] args) {
        String inStr = "Functional interfaces extends Java";
        String outStr;

        System.out.println("input string: " + inStr);

        StringFunc reverse = str -> {
            StringBuilder result = new StringBuilder();
            char[] chars = str.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                result.append(chars[i]);
            }
            return result.toString();
        };

        outStr = changeStr(reverse, inStr);
        System.out.println("Reversed string: " + outStr);

        StringFunc replaceSpaces = str -> str.replaceAll(" ", "-");

        outStr = changeStr(replaceSpaces, inStr);
        System.out.println("Updated string: " + outStr);

        StringFunc changeCapital = str -> {
            char[] chars = str.toCharArray();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i <= chars.length - 1; i++) {
                char aChar = chars[i];
                if (Character.isUpperCase(aChar))
                    result.append(Character.toLowerCase(aChar));

                if (Character.isLowerCase(aChar))
                    result.append(Character.toUpperCase(aChar));

                if (Character.isSpaceChar(aChar))
                    result.append(" ");
            }
            return result.toString();
        };

        outStr = changeStr(changeCapital, inStr);
        System.out.printf("\nChanged capitalisation: %s\n", outStr);
    }
}
