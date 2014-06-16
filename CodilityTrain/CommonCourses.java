package com.Codility.Massimo;

	import java.util.Arrays;
	import java.util.HashSet;

public class CommonCourses {
	   public static void get_common_courses(Integer[] courses1, Integer[] courses2) {
	        // Write your code here
	        // To print results to the standard output please use System.out.println
	        // Example: System.out.println("Hello world!");
	        
		   HashSet<Integer> s = new HashSet<>(Arrays.asList(courses1));
		   s.retainAll(Arrays.asList(courses2));
		   Integer[] result = s.toArray(new Integer[0]);
		   
		   for(Integer elem : result){
			   System.out.println(elem);
		   }
		   
//		   SortedSet<Integer> c1 = new TreeSet<>(Arrays.asList(courses1));
//		   SortedSet<Integer> c2 = new TreeSet<>(Arrays.asList(courses2));
//
//		   for (int course : c1) {
//			   if (c2.contains(course)) {
//				   System.out.print(course + " ");
//			   }
//		   }
		   

//		   Arrays.sort(courses1);
//		   Arrays.sort(courses2);
//
//		   for (int i = 0, j = 0; i < courses1.length && j < courses2.length;) {
//			   if (courses1[i] < courses2[j]) {
//				   ++i;
//			   } else if (courses1[i] > courses2[j]) {
//				   ++j;
//			   } else {
//				   System.out.println(courses1[i]);
//				   ++i;
//				   ++j;
//			   }
//		   }
	        
	    }
}
