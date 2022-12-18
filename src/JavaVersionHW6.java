import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaVersionHW6 {
    public static void main(String[] Args) {
        System.out.println("Введите кол-во вводимых номеров: ");
        Map<String, String> listNumbersAndNames = new HashMap<>();
        int amountNumbers;
        do {
            try {
                var in = new Scanner(System.in);
                amountNumbers = in.nextInt();

                for (int i = 0; i < amountNumbers; i++) {
                    System.out.print("Введите номер телефона: ");
                    var inStr = new Scanner(System.in);
                    var number = inStr.next();
                    System.out.print("Введите имя: ");
                    var name = inStr.next();
                    listNumbersAndNames.put(number, name);
                }
            } catch (Exception e) {
                System.out.println("Введено некорректное значение. Повторите попытку...");
                System.out.println("Введите кол-во вводимых номеров: ");
                amountNumbers = -1;
            }
        } while (amountNumbers < 0);
        var numbersWithPlusSeven = new ArrayList<>();
        listNumbersAndNames.forEach((number, name) -> {
            char[] check = number.toCharArray();

            if (check[0] == '+' && check[1] == '7') numbersWithPlusSeven.add(number);
        });
        System.out.println("Номера с началом на +7: " + numbersWithPlusSeven);
        System.out.println("Количество уникальных номеров - " + listNumbersAndNames.size());
        var listNumbers = listNumbersAndNames.keySet();
        var check = 0;
        for (String i : listNumbers) check += i.length();
        System.out.println("Сумма символов во всех номерах - " + check);
        System.out.println(MapSortUtil.sortMapByKey(listNumbersAndNames));
        System.out.println(MapSortUtil.sortMapByValue(listNumbersAndNames));
    }

    public class MapSortUtil {
        public static Map<String, String> sortMapByKey(Map<String, String> anUnSortedMap) {
            List<Map.Entry<String, String>> myListOfEntrySet = getListOfEntrySetFromMap(anUnSortedMap);
            Collections.sort(myListOfEntrySet, new MapComparatorToSortByKey());
            Map<String, String> mySortedMap = getSortedMapFromSortedEntry(myListOfEntrySet);
            return mySortedMap;
        }
        public static Map<String, String> sortMapByValue(Map<String, String> anUnSortedMap) {
            List<Map.Entry<String, String>> myListOfEntrySet = getListOfEntrySetFromMap(anUnSortedMap);
            Collections.sort(myListOfEntrySet, new MapComparatorToSortByValue());
            Map<String, String> mySortedMap = getSortedMapFromSortedEntry(myListOfEntrySet);

            return mySortedMap;
        }
        private static List<Map.Entry<String, String>> getListOfEntrySetFromMap(Map<String, String> anUnSortedMap) {
            Set<Map.Entry<String, String>> myEntrySetOfMap = anUnSortedMap.entrySet();
            List<Map.Entry<String, String>> myListOfEntrySet = new LinkedList<Map.Entry<String, String>>(myEntrySetOfMap);

            return myListOfEntrySet;
        }
        private static Map<String, String> getSortedMapFromSortedEntry(List<Map.Entry<String, String>> myListOfEntrySetOfMap) {
            Map<String, String> mySortedLinkedHashMap = new LinkedHashMap<String, String>();
            for (Map.Entry<String, String> myOneByOneData : myListOfEntrySetOfMap) {
                mySortedLinkedHashMap.put(myOneByOneData.getKey(), myOneByOneData.getValue());
            }
            return mySortedLinkedHashMap;
        }
    }
    static class MapComparatorToSortByValue implements Comparator<Map.Entry<String, String>> {
        @Override
        public int compare(Map.Entry<String, String> aMap1, Map.Entry<String, String> aMap2) {
            return aMap1.getValue().compareTo(aMap2.getValue());
        }
    }
    static class MapComparatorToSortByKey implements Comparator<Map.Entry<String, String>> {
        @Override
        public int compare(Map.Entry<String, String> aMap1, Map.Entry<String, String> aMap2) {
            return aMap1.getKey().compareTo(aMap2.getKey());
        }
    }
}