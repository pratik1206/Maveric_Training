package com.Test;
	import java.util.Arrays;

	public class sortArrrry {
	    public static void main(String[] args) {
	        int[] array = {5, 2, 8, 3, 1};
	        
	        System.out.println("Original array: " + Arrays.toString(array));
	                
	        for (int i = 0; i < array.length - 1; i++) {
	            for (int j = 0; j < array.length - i - 1; j++) {
	                if (array[j] > array[j + 1]) {
	                    int temp = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = temp;
	                }
	            }
	        }
	        
	        System.out.println("Sorted array in ascending order: " + Arrays.toString(array));
	    }
	}


