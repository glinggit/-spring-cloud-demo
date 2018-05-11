package com.itmuch.cloud;

public class test {
	 public static boolean findANum(int[][] array, int target) {
	        int row = array.length;//行数
	        int cloumn = array[0].length;//列数
	        int i = 0;
	        int j = cloumn - 1;
	        boolean found = false;
	        while(i <= row-1 && j >= 0) {
	            if(target < array[i][j]) {
	                j--;
	            }
	            if(target > array[i][j]) {
	                i++;
	            }
	            if(target == array[i][j]) {
	                found = true;
	                break;
	            }
	        }
	        return found;
	    }
	    
	    public static void main(String[] args) {
	        int a[][]  = {{1,2,8,9},{2,4,9,12},{4,7,10,13}};
	        System.out.println(a.length);
	        System.out.println(a[0].length);
	        System.out.println(findANum(a, 7));
	        
	    }

}
