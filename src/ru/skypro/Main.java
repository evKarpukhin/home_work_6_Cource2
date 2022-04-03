package ru.skypro;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Integer> numsAL = new ArrayList<>(List.of(51, 20, 4, 5, 30, 20, 42, 4, 42, 3, 3, 33));
        //  Task_1 - Напишите код, с помощью которого можно напечатать только нечетные числа в консоль.
        System.out.println("Task 1");
        System.out.println(numsAL);
        for (Integer num : numsAL) {
            if ((num % 2) != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        //  Task_2 - с помощью которого можно напечатать только четные числа без повторений в порядке возрастания.
        System.out.println("Task 2");
        Collections.sort(numsAL);
        System.out.println(numsAL);

        Set<Integer> numSet = new HashSet<>();
        for (Integer num : numsAL) {
            if (numSet.add(num)) {
                if ((num % 2) == 0) {
                    System.out.print(num + " ");
                }
            }
        }
        System.out.println();

        // Task 3
        System.out.println("Task 3");
        // Напишите код, который выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли.
        // В качестве отладочной информации возьмите произвольный набор слов или текст, в котором встречаются повторения.
        String text = "mama papa mama privet poka ok privet doma sun sun ok Sun DOMA PRIVET poka SuN";
        String[] words = text.toUpperCase().split(" ");
        Set<String> numSet1 = new HashSet<>(Arrays.asList(words));
        System.out.println(numSet1);

        // Task 4
        System.out.println("Task 4");
        // Напишите код, который выводит в консоль все количество дублей из списка слов.
        // Например, у вас есть текст из 6 слов, в котором есть одно слово, которое повторяется. В таком случае в
        // консоли выведется результат "2", то есть, то количество элементов, которые повторяются. *
        Map<String, Integer> mapWord = new HashMap<>();
        for (int i = 0; i <= words.length - 1; i++) {
            mapWord.merge(words[i], 1, (a, b) -> a + b);
        }
//        System.out.println(mapWord);
        for (Map.Entry<String, Integer> kvWord : mapWord.entrySet()) {
            if (kvWord.getValue() > 1) {
                System.out.println(kvWord.getKey() + " повторяется " + kvWord.getValue() + " раз(а)");
            }
        }
//        System.out.println(Arrays.toString(words));

        // Task 5
        System.out.println("Task 5");
        // Напишите код, который заменяет все уникальные значения **в списке** на 1, а дубли (число и его дубль) на 0.
        // Посчитайте и выведите в консоль сумму получившегося списка. Сумма должна быть равна количеству уникальных чисел в списке
        List<Integer> numsAL1 = new ArrayList<>(List.of(5, 2, 3, 5, 30, 20, 2, 5, 2, 3, 3, 33));
        System.out.println(numsAL1);
        Map<Integer, Integer> mapNum = new HashMap<>();
        for (int i = 0; i <= numsAL1.size() - 1; i++) {
            mapNum.merge(numsAL1.get(i), 1, (a, b) -> a + b);
        }
        System.out.println(mapNum);
        for (int i = 0; i <= numsAL1.size() - 1; i++) {
            if (mapNum.get(numsAL1.get(i)) > 1) {
                numsAL1.set(i, 0);
            } else {
                numsAL1.set(i, 1);
            }
        }
        System.out.println(numsAL1);

        int sum = numsAL1.stream()
                .mapToInt(a -> a)
                .sum();

        System.out.println("Сумма получившегося списка: " + sum);

        // Task 6
        System.out.println("Task 6");
        // В качестве исходных данных возьмите два любых слова.
        // С помощью коллекций проверьте, состоят ли слова из одних и те же букв или из разных.
        // В консоль выведите результат проверки в формате "true", если два слова состоят из одинаковых букв, и "false", если из разных.
        List<String> listS1 = new ArrayList<>(List.of("ab", "ab", "abc", "abc"));
        List<String> listS2 = new ArrayList<>(List.of("abba", "ab", "ab", "abccba"));
        for (int i = 0; i < listS2.size(); i++) {
            System.out.println(listS2.get(i).contains(listS1.get(i)));
        }

        // Task 7
        System.out.println("Task 7");
        // В качестве исходных данных возьмите два любых слова.
        // С помощью коллекций проверьте, являются ли эти два слова полными анаграммами друг друга или нет.
        // Условие: попробуйте решить задание без применения сортировки.
        // В консоль выведите результат проверки в формате "true", если два слова являются анаграммами, и "false", если таковыми не являются.
        List<String> listS3 = new ArrayList<>(List.of("abc", "abbc", "cat", "cat"));
        List<String> listS4 = new ArrayList<>(List.of("bca", "bca", "act", "dog"));

        for (int i = 0; i < listS3.size(); i++) {
            boolean isAnagramm = checkAnagramm(listS3.get(i), listS4.get(i));
            System.out.println(listS3.get(i) + "  " + listS4.get(i) + " " + " is Anagramm - " + isAnagramm);

        }
    }

    // `{b=3, c=1, a=2}` for the string "aabcbb"
    private static Map<Character, Integer> frequencyMap(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : str.toLowerCase().toCharArray()) {
            Integer frequency = map.get(c);
            map.put(c, frequency == null ? 1 : frequency + 1);
        }
        return map;
    }

    private static boolean checkAnagramm(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            // They're anagrams if both produce the same 'frequency map'
            return frequencyMap(s1).equals(frequencyMap(s2));
        }
    }

}
