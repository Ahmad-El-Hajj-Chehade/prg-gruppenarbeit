package ch.hslu.prg.ledmuster.g02;

import java.util.InputMismatchException;
import java.util.Scanner;

import ch.hslu.prg.ledboard.proxy.BoardService;
import ch.hslu.prg.ledboard.proxy.Led;
import ch.hslu.prg.ledboard.proxy.LedColor;
import ch.hslu.prg.ledmuster.g02.exceptions.InputException;

public class Aufgabe1_1 {

	
	    
	 
	    
	    public static int readRowAmount(Scanner sc, int maxRows) throws InputException {
	    	try {
	    		int input = sc.nextInt();
	    		if(input < 1 || input > maxRows) {
	    			throw new InputException("Die Eingabe muss eine Zahl zwischen 1- " + maxRows + "sein");
	    		}
	    		return input;
	    	}catch(InputMismatchException e) {
	    		sc.nextLine();
	    		throw new InputException("Bitte eine ganze Zahl eingeben");
	    	}
	    }
	    
	    
	    public static Led[][] addLeds(int rowAmount, BoardService boardService, Led[][] leds) {
	    	leds = boardService.add(rowAmount);
	    	boardService.pauseExecution(2000);
	    	return leds;
	    }
	    
	    public static void executeLed(Led[][] leds, BoardService boardService) {
	    	for(int i = 0; i < 3; i++) {
	    	//turn on leds
	    	for(int rows = leds.length -1; rows >= 0; rows--) {
	    		for(int collumns = leds[rows].length -1; collumns >= 0; collumns-- ) {
	    			
	    			leds[rows][collumns].turnOn();
	    		}
	    	}
	    	boardService.pauseExecution(250);
	    	//turn off leds
	    	for(int rows = 0; rows < leds.length; rows++) {
	    		for(int collumns = 0; collumns < leds[rows].length; collumns++ ) {
	    			leds[rows][collumns].turnOff();
	    		}
	    	}
	    }
	    }
}
