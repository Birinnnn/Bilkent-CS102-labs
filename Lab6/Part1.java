import java.util.Arrays;

public class Part1 {

    public static void main(String args[]) {
        int n = 10000;
        int k = 5;
        // Each element of the array is between 0 and 4n
        int[] arr = generateRandomArray(n);

        // Sorting is pre-condition of the search algorithms in this lab
        Arrays.sort(arr);

        // Insert appropriate code segments to calculate execution time
        // Checking if the method can correctly find already existing elements
        for (int elem : arr) {
            int res = 999999999;
            // call the search function and assign it to ``res``
            // Generalize the code so that you can experiment with different k values in a single execution
            try {
                if( k < 2){ throw new KIsLessThan2Exception("K should be bigger than 2");}
                res = genericSearch( arr,elem,0,9999,k);
                if (elem != arr[res]) {
                    throw new RuntimeException("Method works incorrectly (cannot properly locate elements)");
                }
            }
            catch( InputNotSortedException exception){
                exception = new InputNotSortedException("Array is not sorted.");
            }
            catch ( KIsLessThan2Exception exception2){
                exception2 = new KIsLessThan2Exception("K should be bigger than 2");
            }


        }


        // Checking if the method can correctly report absence of elements
        int[] nonExistingElements = {-90, -54, 5 * n + 5, 6 * n};
        for(int elem: nonExistingElements) {
            int res = 999999999;
            // call the search function and assign it to ``res``
            // Generalize the code so that you can experiment with different k values in a single execution
            try{
                if( k < 2 ){ throw new KIsLessThan2Exception("Error"); }
                res = genericSearch(nonExistingElements,res,0,4,k);
                if (res != -1) {
                    throw new RuntimeException("Method works incorrectly (cannot report absence of elements)");
                }

            }
            catch( KIsLessThan2Exception exception){
                exception = new KIsLessThan2Exception("Error");
            }
            catch( InputNotSortedException exception){
                exception = new InputNotSortedException("Error2");
            }

        }
    }

    public static int binarySearch(int[] arr, int target, int low, int high){
        if( low > high){ return -1; }
        int mid = low + (high-low)/2;
        if(arr[mid] == target){ return mid; }
        if( target < arr[mid] ){ return binarySearch(arr,target,low,mid-1); }
        return binarySearch(arr,target,mid+1,high);
    }

    public static int ternarySearch(int[] arr,int low, int high,int target){
            if(low > high ){return -1;}
            int mid1 = low + (high-low)/3;
            int mid2 = low + 2 * (high-low)/3;
            if(arr[mid1] == target ){ return mid1;}
            if(arr[mid2] == target ){ return mid2;}
            if(target < arr[mid1]){ return ternarySearch(arr,low,mid1-1,target);}
            if(target < arr[mid2]){ return ternarySearch(arr,mid1+1,mid2-1,target);}
            return ternarySearch(arr,mid2+1,high,target);
    }

    public static int genericSearch(int[] arr, int target, int low, int high, int k) throws InputNotSortedException, KIsLessThan2Exception{
        int mid;
        if( arr[0] == target){ return 0;}
        if( arr[high] == target){ return high; }


        for( int i = 1; i < k; i++){
            mid = low + i * (high-low)/k;
            if( arr[mid] == target){
                return mid;
            }
            if( target < arr[mid] ){ return genericSearch(arr,target,low+i*(high-low)/k +1,low+ (i+1) * (high - low)/k-1,k); }
        }

        return -1;
    }

    /**
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     */

    public static int[] generateRandomArray(int length)
    {
        int[] array = new int[length];

        for (int i = 0; i < length; ++i)
        {
            array[i] = (int)(Math.random() * length * 4);
        }

        return array;
    }

}
