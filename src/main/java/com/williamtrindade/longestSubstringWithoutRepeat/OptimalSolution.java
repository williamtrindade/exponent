package com.williamtrindade.longestSubstringWithoutRepeat;

import java.util.HashMap;

class OptimalSolution {
    static int longestSubstringWithoutRepeat(String s) {
        // Guarda o caractere e o ÍNDICE dele
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int windowStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Se já vimos esse caractere, pulamos o windowStart
            if (map.containsKey(c)) {
                // Math.max evita que o windowStart ande para trás
                // caso o caractere repetido tenha ficado fora da janela atual
                windowStart = Math.max(windowStart, map.get(c) + 1);
            }

            // Atualizamos a última posição conhecida do caractere
            map.put(c, i);

            // Calculamos o tamanho da janela
            max = Math.max(max, i - windowStart + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        // debug your code below
        System.out.println(longestSubstringWithoutRepeat("abcdeffghij")); // 10
        System.out.println(longestSubstringWithoutRepeat("abcabcbb")); // 3
        System.out.println(longestSubstringWithoutRepeat("pwwkew")); // 3
    }
}