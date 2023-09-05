package dz_2;

import java.util.ArrayList;

public class parseMassive {
    public ArrayList broken(int[] massive, int maxSum) {
        ArrayList result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < massive.length - 1; i++) {
            sum += massive[i];
            if ((sum += massive[i + 1]) > maxSum){
                result.add(sum);
                sum = 0;
            }
        }
        return result;
    }
}
