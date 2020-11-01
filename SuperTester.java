public class SuperTester {
    public static void main(String[] args) {
        SuperArray a = new SuperArray();
        a.add("a");
        a.add("b");
        System.out.println(a.size());
        System.out.println(a.get(1));
        SuperArray words = new SuperArray();
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
        words.add("12");
        words.add("13");
        words.add("uni");
        words.add("ebi");
        for(int i = 0; i < words.size(); i++){
            System.out.println( words.get(i) );
        }
    }
    

}
