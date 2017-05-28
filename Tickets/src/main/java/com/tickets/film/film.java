package com.tickets.film;


public class film {
	private film() {}
	private static volatile film instance;  

    public static film getistance() { 
        if (instance == null) {
            synchronized (film.class) {
                if (instance == null) {
                    instance = new film();
                }
            }
        }
        return instance;   
    }   
}
