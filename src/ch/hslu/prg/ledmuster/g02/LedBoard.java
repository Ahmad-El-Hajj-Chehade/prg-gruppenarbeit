package ch.hslu.prg.ledmuster.g02;

import java.util.InputMismatchException;
import java.util.Scanner;

import ch.hslu.prg.ledboard.proxy.BoardService;
import ch.hslu.prg.ledboard.proxy.Led;
import ch.hslu.prg.ledboard.proxy.LedColor;
import ch.hslu.prg.ledmuster.g02.exceptions.InputException;

public class LedBoard {

	   public static void ledsOnOff(BoardService boardService) {
	    	int rowAmount = 0;
	    	int maxRows = BoardService.MAX_ROWS;
	    	Led[][] leds = null;
	    	Scanner sc = new Scanner(System.in);
	    	try {
	    		System.out.println("Gib die Anzahl Reihen von: 1-" + maxRows + " ein:");
	    	rowAmount = readRowAmount(sc, maxRows);
	    	
	    	}catch(InputException i) {
	    		System.out.println("Error " + i.getMessage());
	    		ledsOnOff(boardService);
	    	}
	    	leds = addLeds(rowAmount, boardService, leds);
	    	
	    	executeLed(leds, boardService);
	    	boardService.pauseExecution(2000);
	    	boardService.removeAllLeds();
	    }
	    
	    private static void ledsColoredOnOff(BoardService boardService) {
	    	int rowAmount = 0;
	    	int maxRows = BoardService.MAX_ROWS;
	    	Led[][] leds = null;
	    	Scanner sc = new Scanner(System.in);
	    	try {
	    		System.out.println("Gib die Anzahl Reihen von: 1-" + maxRows + " ein:");
	    	rowAmount = readRowAmount(sc, maxRows);
	    	
	    	}catch(InputException i) {
	    		System.out.println("Error " + i.getMessage());
	    		ledsOnOff(boardService);
	    	}
	    	leds = addLeds(rowAmount, boardService, leds);
	    	
	    	executeLed(leds, boardService);
	    	boardService.pauseExecution(2000);
	    	boardService.removeAllLeds();
	    }
	    
	    
	    private static int readRowAmount(Scanner sc, int maxRows) throws InputException {
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
	    
	    private static LedColor readColor(BoardService boardService, Scanner sc) {
	    	
	    	return LedColor.RED;
	    }
	    private static Led[][] addLeds(int rowAmount, BoardService boardService, Led[][] leds) {
	    	leds = boardService.add(rowAmount);
	    	boardService.pauseExecution(2000);
	    	return leds;
	    }
	    
	    private static void executeLed(Led[][] leds, BoardService boardService) {
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
