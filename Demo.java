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
    
        System.out.println(words.toString());
        removeDuplicates(words);
        System.out.println(words);
        SuperArray intersection = findOverlap(words, word);
        System.out.println(intersection);
    }
}
