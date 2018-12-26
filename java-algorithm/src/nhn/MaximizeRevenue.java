package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximizeRevenue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day_size = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] prices = new int[day_size];
        for(int i=0; i<arr.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        int result = benefit(prices);
        if(result < 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

    static int benefit(int[] prices) {
        int maxPriceIndex = maxPriceIndex(prices, 0);
        int count = 0;
        int completeIndex = -1; // completed index number
        int buyPrice = 0; // buy price
        int benefit = 0; // total benefit
        while (completeIndex + 1 <= prices.length - 1) {
            for (int i = completeIndex + 1; i < maxPriceIndex; i++) {
                buyPrice += prices[i];
                count++;
            }
            completeIndex = maxPriceIndex;
            benefit = benefit + count * prices[maxPriceIndex] - buyPrice;
            buyPrice = 0;
            count = 0;
            if (completeIndex + 1 <= prices.length - 1) {
                maxPriceIndex = maxPriceIndex(prices, completeIndex + 1);
            }
        }
        return benefit - soldCount;
    }

    static int soldCount = 0;

    static int maxPriceIndex(int[] prices, int startIndex) {
        int maxPriceIndex = startIndex;
        int maxPrice = prices[startIndex];
        if (startIndex != prices.length - 1) {
            soldCount++;
        }
        for (int i = startIndex; i < prices.length; i++) {
            if (prices[i] >= maxPrice) {
                maxPrice = prices[i];
                maxPriceIndex = i;
            }
        }
        return maxPriceIndex;
    }
}
