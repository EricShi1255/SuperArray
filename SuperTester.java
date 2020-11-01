public class SuperTester {
    public static int size(String[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                count ++;
            }
        }
        return count;
   }
    public static void main(String[] args) {
        String[] poo = new String[10];
        poo[0] = "a";
        poo[1]= "b";
        System.out.println(size(poo));
    }
    

}
