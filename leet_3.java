package hblee;

import java.util.ArrayList;
import java.util.List;

public class leet_3{
	public static void main(String args[]) {
		
		Solution2 sol = new Solution2();
		
		int[] nums = {1,2,3,4};
		sol.subsets(nums);
	}
}

//GET power Set

class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
    	
    	int cnt =0;
    	
    	List<Integer> list = new ArrayList<>();
    	List<List<Integer>> result = new ArrayList<>();
   
    
    	int len = nums.length;
    	
    	for(int i=1; i <= len ;i++) {

    		for(int m=0; i<= len-m; m++) {
    			System.out.print("m =");
    			System.out.print(m+" ");
    			for(int n=m;n<m-n+1;n++) {
    				System.out.print("n =");
    				System.out.print(n+" ");
    				
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
    	
    	return null;
    }
}