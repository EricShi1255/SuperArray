public class SuperArray {
   private String[] data;
   private int size; //the current size
   
    public SuperArray() {
        data = new String[10];
   }
    public SuperArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        } 
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
        if ( (index < 0) || (index >= size()) ) {
            throw new IndexOutOfBoundsException("Index out of range of size()");
        }
        return(data[index]);
    }

    public String set(int index, String element) {
        //-Replaces the element at the specified position in this list with the specified element.
        //Return the value you replaced. [Assume the index is 0 to size-1]
        //note: This is not to add new values, it is only to replace old ones. 
        if ( (index < 0) || (index >= size()) ) {
            throw new IndexOutOfBoundsException("Index out of range of size()");
        }
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
        if ( (index < 0) || (index >= size()) ) {
            throw new IndexOutOfBoundsException("Index out of range of size()");
        }
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
        if ( (index < 0) || (index >= size()) ) {
            throw new IndexOutOfBoundsException("Index out of range of size()");
        }
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
    public int indexOf(String s) {
        //Returns the index of the first occurrence of the specified element in this list
        //-1 if this list does not contain the element. 
        for (int i = 0; i < data.length; i++) {
            if (s.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
    public String[] toArray() {
	    //Returns an array containing all of the elements in this list in proper sequence (from first to last element).
        //The returned array will be "safe" in that no references to it are maintained by this list. \
        //(In other words, this method must allocate a new array).
        String[] result = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i];
        }
        return result;
    }

    public static void removeDuplicates(SuperArray s){
        for (int i = 0; i < s.size(); i++) {
            int firsta = s.indexOf(s.get(i));
            for (int j = s.size()-1; j > 0; j--) {
                if (s.get(j) == s.get(firsta) && j != firsta) {
                    s.remove(j);
                }
            }
        }
    }

    public int lastIndexOf(String value){
        for (int i = size; i > 0; i--) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
    public boolean equals(SuperArray other){
        if (size == other.size()) {
            for (int i = 0; i < size; i++) {
                if (data[i] != other.get(i)) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }


    
}