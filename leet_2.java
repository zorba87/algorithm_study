package hblee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class leet_2{
	public static void main(String args[]) throws Exception {
		String str = leet_2.class.getResource("").getPath();
		
		File file = new File(str+"leet2.txt");
		FileInputStream fis = new FileInputStream(file);
		
		InputStreamReader is = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(is);
		
		OutputStreamWriter os = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(os);
		
		
		Solution sol = new Solution();
	
		ListNode l1 = new ListNode(2);
		
		String value = "111";
		String value2 ="9";
		//1.인풋 받아서 저장
		//2.reverse 시키고
		//3.자리수마다 더함. 10초과시 나머지 자리에 1추가
		int length= value.length();
		int length2= value2.length();
		
		int maxlength = (length > length2)? length: length2;
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < maxlength ; i++) {
			//자리수 체크
			int sum = 0;
			int part=0,part2=0;
			
			if(i< length && i< length2) {
				part =  value.charAt(i)-'0';	
				part2 = value2.charAt(i)-'0';	

			
			}else {
				if(i >= length) {
					part=0;
					part2 = value2.charAt(i)-'0';	
				}else if( i >= length2) {
					part = value.charAt(i)-'0';	
					part2=0;					
				}
			}
			//공통
			if(flag) {
				sum =1;
				flag = false;
			}
//			System.out.print("part ="+part+", ");
//			System.out.print("part2 ="+part2);
			sum += part+part2;
//			System.out.println("part sum "+sum);
			if(sum >= 10) {
				list.add(0);
				flag = true;
			}else {
				list.add(sum);
			}
		}
		
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+"");
		}
		
		
	}
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        ListNode node = l1;
        int count =0;
        
        list1.add(l1.val);
            
        while(l1.next !=null){
            l1 = l1.next;
            list1.add(l1.val);
        }
        System.out.println("kk="+list1.size());
        
        for(int i =0; i<list1.size();i++){
            System.out.print("i="+i+"  ");
           System.out.println(list1.get(i));
            
        }
        //l1.next.val;
    
    
        return l1;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */