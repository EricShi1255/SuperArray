public class Demo {
    public static void removeDuplicates(SuperArray s){
        for (int i = 0; i < s.size(); i++) {
            int index = s.indexOf(s.get(i));
            String indexValue = s.get(index);
            for (int j = (index+1); j < s.size(); j++) {
                if (s.get(j).equals(indexValue)) {
                    s.remove(j);
                } 
            }
        }
    }
    public static SuperArray findOverlap(SuperArray a, SuperArray b) {
        SuperArray intersection = new SuperArray();
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i))) {
                intersection.add(a.get(i));
            }
        }
        removeDuplicates(intersection);
        return intersection;
    }

    public static SuperArray zip(SuperArray a, SuperArray b){
        //return a new SuperArray that contains all elements of a, and all elements of b in the following sequence:
        //[a0, b0, a1, b1, a2, b2 ... ]
        //When either SuperArray is longer and you run out of strings in one:
        // just fill the remaining elements with the rest of the longer SuperArray. 
        SuperArray merger = new SuperArray();
        if (a.size() <= b.size()) {
            for (int i = 0; i < a.size(); i++) {
                merger.add(a.get(i));
                merger.add(b.get(i));
            }
            if (b.size() > a.size()) {
                for (int i = a.size(); i < b.size(); i++) {
                    merger.add(b.get(i));
                }
            }
        }
        else {
            for (int i = 0; i < b.size(); i++) {
                merger.add(a.get(i));
                merger.add(b.get(i));
            }
            if (a.size() > b.size()) {
                for (int i = b.size(); i < a.size(); i++) {
                    merger.add(a.get(i));
                }
            }
        }
        return merger;
    }


    public static void main(String[]args){
        SuperArray words = new SuperArray();
        //grouped to save vertical space
        words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");     
        words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
        words.add("una");    words.add("ebi");     words.add("toro");    words.add("toro");

        SuperArray word = new SuperArray(); //no toro or ebi
        //grouped to save vertical space
        word.add("kani");   word.add("uni");     word.add("for");     word.add("una");     
        word.add("una");    word.add("kani");    word.add("una");     word.add("una");    

        SuperArray letters = new SuperArray();
        //grouped to save vertical space
        letters.add("a");   letters.add("b");     letters.add("c");     letters.add("d");     
        letters.add("e");    letters.add("f");    letters.add("g");     letters.add("h"); 
        
        SuperArray numbers = new SuperArray();
        //grouped to save vertical space
        numbers.add("0");   numbers.add("1");     numbers.add("2");     numbers.add("3");     
        //numbers.add("4");    numbers.add("5");    numbers.add("6");    numbers.add("7"); 
    
        System.out.println(words.toString());
        removeDuplicates(words);
        System.out.println(words);
        SuperArray intersection = findOverlap(words, word);
        System.out.println(intersection);
        System.out.println(zip(numbers, letters).toString());
    }
}
