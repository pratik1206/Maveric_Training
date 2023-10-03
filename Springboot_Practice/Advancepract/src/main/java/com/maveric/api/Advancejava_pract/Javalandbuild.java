package com.maveric.api.Advancejava_pract;

  import java.util.Scanner;

	public class Javalandbuild {
	    
	    public static int minimumJumps(int N, int K, int[] heights) {
	        int inf = Integer.MAX_VALUE;
	        int[] dp = new int[N];
	        dp[0] = 0;
	        
	        for (int i = 1; i < N; i++) {
	            int minJumps = inf;
	            for (int j = i - 1; j >= Math.max(0, i - K); j--) {
	                int diff = Math.abs(heights[i] - heights[j]);
	                if (diff <= K) {
	                    minJumps = Math.min(minJumps, dp[j] + 1);
	                }
	            }
	            dp[i] = minJumps;
	        }
	        
	        if (dp[N - 1] == inf) {
	            return -1;
	        } else {
	            return dp[N - 1]; 
	        }
	    }
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        int N = scanner.nextInt();
	        int K = scanner.nextInt();
	        
	        int[] heights = new int[N];
	        for (int i = 0; i < N; i++) {
	            heights[i] = scanner.nextInt();
	        }
	        
	        int result = minimumJumps(N, K, heights);
	        System.out.println(result);
	        
	        scanner.close();
	    }
	}


