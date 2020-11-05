public class SuperArray {
   private String[] data;
   private int size; //the current size
   
    public SuperArray() {
        data = new String[10];
   }
    public SuperArray(int initialCapacity) {
        data = new String[initialCapacity];
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
            resize();
            data[size]= element;
        }
        size();
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
        size();
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
        size();
    }

    public void clear() {
        String[] clean = new String[data.length];
        data = clean;
        size();
    }


    public boolean isEmpty() {
        return(size() == 0);
    }

    public String toString() {
        if (data.length == 0 || size == 0) {
            return("[]");
          }
          String result = "[";
          for (int i = 0; i < data.length-1; i ++) {
            if (data[i] != null) {
            result= result + data[i] +  ", ";
            }
          }
        if (data[data.length-1] != null) {
            result +=  data[data.length-1];
        }
        else {
            result = result.substring(0, result.length()-2);
        }        
          return(result + "]");
    }
    public boolean contains(String s) {
        for (int i = 0; i < data.length; i++) {
            if (s.equals(data[i])) {
                return true;
            }
        }
        return false;
    }
    public void add(int index, String element) {
        //Inserts the specified element at the specified position in this list
        // Shifts the element currently at that position (if any) and any subsequent elements to the right.
        String[] result = new String[data.length+1];
        boolean shift = false;
        for (int i = 0; i < data.length; i++) {
            if (!shift && i != index) {
                result[i] = data[i];
            } 
            else if (i == index) {
                shift = true;
                result[i] = element;
            }
            else if (shift) {
                result[i+1] = data[i];
            }
        }
        data = result;
        size();
    }
    public String remove(int index) {
        //	Removes the element at the specified position in this list.
        //Shifts any subsequent elements to the left. The returned value is the element you remove.
        String[] result = new String[data.length-1];
        String removed = "";
        boolean shift = false;
        for (int i = 0; i < data.length-1; i++) {
            if (!shift && i != index) {
                result[i] = data[i];
            } 
            else if (i == index) {
                removed = data[i];
                shift = true;
            }
            else if (shift) {
                result[i-1] = data[i];
            }
        }
        data = result;
        size();
        return(removed);
    }
    
}