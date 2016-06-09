package com.coursera.quicksort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {

    private interface PivotStrategy {
        public void selectPivot(int[] a, int p, int r);
    }
    
    private final static PivotStrategy PIVOT_ON_FIRST = new PivotStrategy() {
        @Override
        public void selectPivot(int[] a, int p, int r) {
            //do nothing
        }
        
        @Override
        public String toString() {
            return "Pivot on first";
        }
    };
    
    private final static PivotStrategy PIVOT_ON_LAST = new PivotStrategy() {
        @Override
        public void selectPivot(int[] a, int p, int r) {
            swap(a, p, r);
        }
        
        @Override
        public String toString() {
            return "Pivot on last";
        }
    };
    public static int i = 0;
    private final static PivotStrategy PIVOT_ON_MEDIAN = new PivotStrategy() {
        @Override
        public void selectPivot(int[] a, int p, int r) {
            int f = a[p];
            int m = a[(p+r)/2];
            int l = a[r];
            //check medium
            if( ( f < m && m <= l ) || ( l <= m && m < f ) ) {
                swap(a, p, (p+r)/2);
            } 
            //check last
            else if( ( m <= l && l < f ) || ( f < l && l <= m ) ) {
                swap(a, p, r);
            }
        }
        
        @Override
        public String toString() {
            return "Pivot on median";
        }
    };
    
    private final static PivotStrategy PIVOT_AT_RANDOM = new PivotStrategy() {
        @Override
        public void selectPivot(int[] a, int p, int r) {
            
            swap(a, p, ((int) (p + Math.random() * (r - p + 1))));
        }
        
        @Override
        public String toString() {
            return "Pivot at random";
        }
    };
    
    private final static PivotStrategy PIVOT_AT_RANDOMQ = new PivotStrategy() {
        @Override
        public void selectPivot(int[] a, int p, int r) {
            
            swap(a, p, i);
        }
        
        @Override
        public String toString() {
            return "Pivot at random Q with i : "+i;
        }
    };
    
    private static int counter;
    private static PivotStrategy currentStrategy;
    
    public static void quicksort( int[] a ) {
        
        if( currentStrategy == null )
            throw new RuntimeException( "No pivoting strategy defined" );
        counter = 0;
        sort( a, 0, a.length-1);
    }
    
    private static void sort(int[] a, int p, int r) {
        
        if( p < r ) {
            counter += r-p;
            currentStrategy.selectPivot( a, p, r );
            int q = partitionByFirst2(a, p, r);
            sort(a, p, q-1);
            sort(a, q+1,r);
        }
    }
    
    //Leiserson
    @SuppressWarnings( "unused" )
    private static int partitionByFirst(int[] a, int p, int r) {
        int pivot = p;
        int i = p;
        for(int j = i+1; j <= r; j++) {
            if(a[j] <= a[pivot]) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i, pivot);
        return i;
    }
    
    //Roughgarden
    private static int partitionByFirst2(int[] a, int p, int r) {
        int pivot = p;
        int i = p+1;
        for(int j = i; j <= r; j++) {
            if(a[j] < a[pivot]) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i-1, pivot);
        return i-1;
    }
    
    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
    
    private static boolean isSorted( int[] a ) {
    
        for( int i = 1; i < a.length; i++ ) {
            if( a[i-1] > a[i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param args
     */
    public static void main( String[] args ) {
        
        int[] arr = getArrayFromFile();
        //int[] arr = new int[]{1,2,2,4,5};
        for(int j=0 ; j<=9 ; j++){
        	i++;
        	 testQsWithStrategy(arr.clone(), PIVOT_AT_RANDOMQ); //162085
        }
//        testQsWithStrategy(arr.clone(), PIVOT_ON_FIRST); //162085
//        testQsWithStrategy(arr.clone(), PIVOT_ON_LAST);  //164123
//        testQsWithStrategy(arr.clone(), PIVOT_ON_MEDIAN);//138382
//        testQsWithStrategy(arr.clone(), PIVOT_AT_RANDOM);//not better that pivoting on a median
    }
    
    private static void testQsWithStrategy(int[] arr, PivotStrategy str) {
        System.out.println( "Sorting with strategy: " + str);
        currentStrategy = str;
        
        System.out.println( "sorted: " + isSorted( arr ) );
        long start = System.currentTimeMillis();
        
        quicksort( arr );
        
        System.out.println((System.currentTimeMillis() - start));
        System.out.println( "sorted: " + isSorted( arr ) );
        System.out.println("comparisons: " + counter);
    }
    public static int[] getArrayFromFile() {
        Scanner s;
        ArrayList<Integer> list = null;
        try {
            s = new Scanner(new File("C:\\Users\\suresh.gupta\\Desktop\\QuickSort.txt"));
            list = new ArrayList<Integer>();
            while (s.hasNext()) {
                list.add(Integer.parseInt(s.next()));
            }
            s.close();
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] inArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            inArr[i] = list.get(i);
        }
        return inArr;
    }
}
