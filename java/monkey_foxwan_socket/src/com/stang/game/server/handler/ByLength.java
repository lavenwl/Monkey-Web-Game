package com.stang.game.server.handler;

import java.util.Comparator;
import java.util.Map;

import java.util.Comparator;

public class ByLength implements Comparator<Integer>{

	@Override
	 public int compare(Integer num1, Integer num2) {
	    return -(num1-num2);
	  }
	
}
