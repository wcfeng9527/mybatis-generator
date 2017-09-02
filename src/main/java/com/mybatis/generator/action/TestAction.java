package com.mybatis.generator.action;

import java.util.Arrays;

import com.mysql.fabric.xmlrpc.base.Array;

public class TestAction {

	
	
	public static void main(String[] args) {
		
		
		 //定义二维数组  
//        int[ ] [ ] arr={{1,2,3},{4,5,6}};  
//        //静态初始化  
//           
//        //打印出二维数组  
//          
//        for(int i=0;i<arr.length;i++){  
//              
//            for(int j=0;j<arr[i].length;j++){  
//                      
//                System.out.print(arr[i][j]+" ");  
//                  
//            }  
//            //输出一列后就回车空格  
//            System.out.println();  
//              
//        }
        
        
//        int[]  aa = {1,2,3};
//        int[]  bb = {4,5,6};
//        int cc = 2;
//        
//        Integer[][] configs = new Integer[cc][aa.length];
//        int a = 1;
//        int b = 2;
//        int c = 3;
//        for(int i = 0; i <cc;i++){
//        	
//        	configs[i] = new Integer[]{a,b,c};
//        	
//        }
//        
//        for (int i = 0; i < configs.length; i++) {
//			for (int j = 0; j < configs[i].length; j++) {
//				
//				System.out.print(configs[i][j]+", ");
//				
//			}
//			//输出一列后就回车空格  
//            System.out.println();  
//		}
//		
		
        
        
        
        int[]  dd = {4,5,6};
        
        int v = 4;
        boolean contains = Arrays.asList(dd).contains(v);
        System.out.println(contains);
        boolean contains2 = Arrays.asList(dd).contains(1);
        System.out.println(contains2);
        
        
        
        String[] stringArray = { "a", "b", "c", "d", "e" };  
        boolean b = Arrays.asList(stringArray).contains("a");  
        System.out.println(b); 
        
	}
	
	
	
}
