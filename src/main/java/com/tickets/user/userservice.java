package com.tickets.user;

import java.util.HashMap;
import java.util.Map;

public class userservice {
	
	private static userservice instance = null;
	//private static Map<String, String> user;
	private static Map<String, String> user = new HashMap<String, String>();
	private userservice() {
	//	user.clear();
	}
    public static userservice getistance() {
    	if (instance == null) {
    		instance = new userservice();
    	}
        return instance;   
    }
    public int register(String a, String b) {
    	//return 1;
    	
    	if (user.containsKey(a)) {
    		return 0;
    	} else {
    		user.put(a, b);
    		return 1;
    	}
    	
    }
    public int login(String a, String b) {
    	if (!user.containsKey(a)) {
    		return 0;
    	} else {
    		String c = user.get(a);
    		if (c.equals(b))
    			return 2;
    		else
    			return 1;
    	}
    }
}
