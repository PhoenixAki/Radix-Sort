/*
    * This is a variation on Counting Sort that allows for a divisor and modulo value to be passed in, for usage by Radix Sort.
    * This can be used to perform a standalone Counting Sort, by passing 0 as the arguments for divisor and modulo.
    * The divisor and modulo arguments are used to pick out specific numbers from a larger number, for use by Radix Sort.
*/

class CountingSort {
    static int[] sort(int[] initial, int divisor, int modulo){
        int[] count = new int[10], sorted = new int[initial.length]; //java initializes int arrays to have 0 in all indexes

        //First, increment indexes of count based on values of initial.
        for(int num : initial){
            if(divisor != 0)
                num /= divisor;
            if(modulo != 0)
                num %= modulo;

            count[num]++;
        }

        //Next, sum the totals in count.
        for(int i = 0; i < count.length; ++i){
            if(i+1 < count.length)
                count[i+1] = count[i] + count[i+1];
        }

        //Lastly, sort the values from initial into sorted, using the information from count.
        //The initial implementations I referred to online progressed from 0 -> initial.length-1, but the sort was not stable as a result.
        //By traversing the array backwards from initial.length-1 -> 0, the sort becomes stable, which is fundamental for a working Radix Sort.
        for(int i = initial.length-1; i >= 0; --i){
            int storeNum = initial[i];

            if(divisor != 0)
                storeNum /= divisor;
            if(modulo != 0)
                storeNum %= modulo;

            int index = count[storeNum]-1;
            sorted[index] = initial[i];
            count[storeNum]--;
        }

        return sorted;
    }
}
