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
        size = count;
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
        if (!added) {
            size();
            resize();
            data[size]= element;
        }

    return true;
    }
    public String get(int index) {
        //-Returns the element at the specified position in this list. [For Now Assume the index is 0 to size-1]
        return(data[index]);
    }

    public String set(int index, String element) {
        //-Replaces the element at the specified position in this list with the specified element.
        //Return the value you replaced. [Assume the index is 0 to size-1]
        //note: This is not to add new values, it is only to replace old ones. 
        String sea = data[index];
        data[index] = element;
        return sea;
    }

    private void resize() {
        //-Increase the capacity by :
        //creating a larger array
        //copy the values from the original array to the new one.
        //assign the new one to the instance variable.
        String[] arr = new String[size+10];
        for (int i = 0; i < data.length; i++){
            arr[i] = data[i];   
        }
        data = arr;
    }
    
}