package leetcode;

import java.io.BufferedReader;
import java.io.FileReader;

public class Medium_11_ContainerWithMostWater {

    public static void main(String[] args) {
        String filePath = Medium_11_ContainerWithMostWater.class.getClassLoader().getResource("leetcode/11.txt").getPath();
        int[] values = read(filePath);
        long start = System.currentTimeMillis();
//        int result = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int result = maxArea(values);
        long stop = System.currentTimeMillis();
        System.out.println("result: " + result);
        System.out.println("completed in " + (stop - start) + " ms");
    }

    public static int maxArea(int[] height) {
        int maxVolume = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int currentVolume = Math.min(height[i], height[j]) * (j - i);
            if (currentVolume > maxVolume) {
                maxVolume = currentVolume;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxVolume;
    }

    private static int[] read(String fileName) {
        int[] values = new int[100000];
        int currentValue = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                if (!line.isEmpty()) {
                    values[currentValue++] = Integer.valueOf(line);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return values;
    }

}
