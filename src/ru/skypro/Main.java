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
    }

}
