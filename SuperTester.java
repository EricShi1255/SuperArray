import java.util.*;
public class SuperTester {
    public static void main(String[] args) {
        SuperArray a = new SuperArray(5);
        a.add("a");
        a.add("b");
        System.out.println(a.size());
        System.out.println(a.get(1));
        SuperArray words = new SuperArray();
        words.add("0");
        words.add("1");
        words.add("2");
        words.add("3");
        words.add("4");
        words.add("5");
        words.add("6");
        words.add("7");
        words.add("8");
        words.add("9");
        words.add("10");
        words.add("11");
        words.add("0");
        words.add("ebi");
        words.add(2,"APPLE");
        words.remove(5);
        //words.clear();
        System.out.println(words.toString());
        System.out.println(words.contains("uni"));
        System.out.println(words.indexOf("APPLE"));
        System.out.print(Arrays.toString(words.toArray()));
    }
    
}
