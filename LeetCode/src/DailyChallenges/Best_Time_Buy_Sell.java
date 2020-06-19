package DailyChallenges;

public class Best_Time_Buy_Sell {
    public static void main(String[] args) {

        int[] arr = {7,6,4,3,1};

        System.out.print(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {

        int result = 0;
        boolean stock = false;
        for (int i = 0; i < prices.length - 1; i++) {

            if (!stock) {

                if (prices[i] < prices[i + 1]) {
                    stock = true;
                    result -= prices[i];
                }

            } else {

                if (prices[i] > prices[i + 1]) {
                    stock = false;
                    result += prices[i];
                }

            }

        }

        return stock ? result + prices[prices.length-1] : result;

    }
}
