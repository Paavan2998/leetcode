public class sqrt {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(1));
    }
    public static int squareRoot(int x){
        if(x == 1 || x == 2 || x == 3 )
            return 1;
        else
            return (int)findSquareRoot(x, 0.0, x/2);
    }
    public static double findSquareRoot(double x, double min, double max){
        if(max*max == x) {
            return max;
        } else if (min*min == x) {
            return min;
        } else if (min+1==max && ((min*min)<=x) && ((max*max)>=x)) {
            return min;
        } else if(max*max > x){
            double median = Math.floor((max + min)/2);
            return findSquareRoot(x, min, median);
        }else if(max*max < x){
            double newMax = 2*max - min;
            return findSquareRoot(x, max, newMax);
        }
        return 0;
    }
    /*
    * problem:
    * if possible use for loop instead of recursion (space complexity is high in case of recursion)
    * above solution will not work data type integer because of integer overflow on (max*max)
    * */

    /*
    * solution:
    * use for/while instead of recursive call
    * use divide instead of multiplication to avoid integer overflow
    * */

    public static int findSquareRoot(int x){
        if(x<1) {
            return 0;
        }else{
            int low = 1;
            int high = x;
            int ans = 0;
            while(low<high){
                int mid = (low + high)/2;
                if(mid == (x/mid)){
                    return mid;
                } else if ((high == low + 1) && (low<=(x/low)) && (high>=(x/high))){
                    return low;
                }else if (mid < (x/mid)) {
                    low = mid;
                } else if(mid > (x/mid)){
                    high = mid;
                }
            }
        }
        return 0;
    }
}
