public class Answer {
    static void arrayOutOfBoundsException() {
        
      
}

    static void divisionByZero() {
        int a = 5;
        int b = 0;
        int result = a / b;
      
}

    static void numberFormatException() {
        String f = "Our world";
        Integer formattedRandom = Integer.parseInt(f);
       
 }

 public int[] subArrays(int[] a, int[] b){
    int[] result;
    if (a == null || b == null || a.length != b.length){
        result = new int[]{0};
        return result; 
    }
    result = new int[a.length];
    for (int i = 0; i < a.length; i++) {
        result[i] = a[i] / b[i];
    }
    return result;
 }    
}
