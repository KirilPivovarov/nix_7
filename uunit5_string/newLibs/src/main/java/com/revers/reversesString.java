package com.revers;

public class reversesString {

    public static String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        String[] words = input.split(" ");
        String[] var3 = words;
        int var4 = words.length;
        for (int var5 = 0; var5 < var4; ++var5) {
            String word = var3[var5];
            for (int i = word.length() - 1; i >= 0; --i) {
                reversed.append(word.charAt(i));
            }
            reversed.append(" ");
        }
        return reversed.toString().trim();
    }

    public static String reverse(String input, String dest) {
        return input.replaceAll(dest, reverse(dest));
    }

    public static String reverse(String source, int firstIndex, int lastIndex) {
        int lastIndexForSubstring = lastIndex + 1;
        return source.replaceAll(source.substring(firstIndex, lastIndexForSubstring), reverse(source.substring(firstIndex, lastIndexForSubstring)));
    }
}