package com.stang.game.server.handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import sun.security.provider.MD5;
import com.stang.game.entity.detail.*;

public class Test {
	
	
	public static void main(String[] args) {
//		String str = new Test().randomString(32);
//		System.out.println(str);
		List<StatetostateDetail> list = new ArrayList<StatetostateDetail>();
		for(int i = 1; i < 16; i++){
			StatetostateDetail s = new StatetostateDetail();
			s.setId(i);
			s.setStatue(0);
			s.setTime(System.currentTimeMillis() + (i + i * 100));
			list.add(s);
		}
		list.get(3).setStatue(1);
		list.get(5).setStatue(1);
		list.get(10).setStatue(1);
		list.get(14).setStatue(1);
		list.get(7).setStatue(2);
		list.get(9).setStatue(2);
		System.out.println("list:" + list);
	
		
		Collections.sort(list, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	Long t1 = null;
            	Long t2 = null;
            	try{
            		t1 = s1.getTime();
	            	t2 = s2.getTime();
            	}catch(Exception e){
            		e.printStackTrace();
            	}
      
                return t2.compareTo(t1);
            }
    });
		Collections.sort(list, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	return s1.getStatue()>s2.getStatue()?1:(s1.getStatue()==s2.getStatue()?0:(s2.getTime()>s1.getTime()?-1:0));
            }
    });
		
		System.out.println("list:" + list);
		
		
		
		
		
		
		
		
		
	}
	/**
	   * 产生随机字符串
	   * */
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;

	public static final String randomString(int length) {
	         if (length < 1) {
	             return null;
	         }
	         if (randGen == null) {
	                randGen = new Random();
	                numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
	                   "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	                  //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	                 }
	         char [] randBuffer = new char[length];
	         for (int i=0; i<randBuffer.length; i++) {
	             randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
	          //randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
	         }
	         return new String(randBuffer);
	}
	
	//调用此方法randomString(int),int是字符串的长度，即可产生指定长度的随机字符串。
}
