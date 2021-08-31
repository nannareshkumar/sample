package probs;

// Program to find best buying and selling days
import java.util.*;

/**
 * Created by home on 11/5/2020.
 */
public class BuyOrSell {

    public static void main(String args[]) {
        BuyOrSell stock = new BuyOrSell();

        // stock prices on consecutive days
        int price[] = {2,4,1};//{3,3,5,0,0,3,1,4}; //{3,2,6,5,0,3};
        int n = price.length;
        //Arrays.
        // fucntion call
        System.out.println(" result : " + stock.maxProfit(2, price));
    }

    public int maxProfit(int k, int[] prices) {

        int i =0, count=0;
        int n = prices.length;
        List<Interval> list = new ArrayList();

        while(i < n-1)   {

            while(i < n-1 && prices[i+1] <= prices[i])
                i++;

            if(i == n-1)
                break;

            Interval ter = new Interval();
            ter.buy = i++;

            while(i < n && prices[i] >= prices[i-1] )
                i++;

            ter.sell = i-1;

            list.add(ter);
            count++;
        }

        int max=0;
        Collections.sort(list, new Comparator(){
            public int compare(Object obj1, Object obj2){
                Interval v1 = (Interval) obj1;
                Interval v2 = (Interval) obj2;

                return (prices[v2.sell] - prices[v2.buy]) - (prices[v1.sell] - prices[v1.buy]);
            }
        });


        for(int j=0; j<k && j < list.size(); j++)  {
            Interval val = (Interval) list.get(j);
            max += prices[val.sell] - prices[val.buy];
        }
        return max;
    }

    // This function finds the buy sell schedule for maximum profit
    public void stockBuySell(int price[], int n) {

        ArrayList<Interval> sol = new ArrayList<Interval>();

        int i = 0, count=0;
        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i+1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima

            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i-1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }
            // print solution
            if (count == 0)
                System.out.println("There is no day when buying the stock "
                        + "will make profit");
            else
                for (int j = 0; j < count; j++)
                    System.out.println("Buy on day: " + sol.get(j).buy
                            + "        "
                            + "Sell on day : " + sol.get(j).sell);

            return;

    }

    // This code has been contributed by Mayank Jaiswal
// Solution structure
    class Interval {
        int buy, sell;
    }
}
