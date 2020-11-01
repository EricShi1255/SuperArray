public class SuperArray {
   private String[] data;
   private int size; //the current size
   
    public SuperArray() {
        data = new String[10];
   }
    public int size() {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                count ++;
            }
        }
        return count;
   }
   public boolean add(String element) {
    //-Appends the specified element to the end of this list. 
    boolean added = false;
    for (int i = 0; i < data.length; i++) {
        if (data[i] == null && !added ) {
            added = true;
            data[i] = element;
        }
    }
    return true;
}
    
}