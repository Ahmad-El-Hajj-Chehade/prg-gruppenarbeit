package ch.hslu.prg.ledmuster.g02;

import ch.hslu.prg.ledboard.proxy.BoardService;
import ch.hslu.prg.ledboard.proxy.Led;
import ch.hslu.prg.ledboard.proxy.LedColor;
import ch.hslu.prg.ledmuster.g02.exceptions.InputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientApp {
	
	private static BoardService boardService = new BoardService();
    public static void main(String[] args) throws InputException {
    	
    	/*-1
		// Oeffnen der -jar Datei für Ansicht
		try {
			ProcessBuilder pb = new ProcessBuilder("java", "-jar", "gui.jar");
			pb.start();
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(" GUI konnte nicht gestartet werden. " + e.getMessage());
		}
    	*/
    	
        
        
       ledsOnOff(boardService);
       Aufgabe1_2.ledsColoredOnOff(boardService);
    }

    public static void ledsOnOff(BoardService boardService) {
    	Aufgabe1_1 aufgabe1_1 = new Aufgabe1_1();
    	int rowAmount = 0;
    	int maxRows = BoardService.MAX_ROWS;
    	Led[][] leds = null;
    	Scanner sc = new Scanner(System.in);
    	try {
    		System.out.println("Gib die Anzahl Reihen von: 1-" + maxRows + " ein:");
    	rowAmount = aufgabe1_1.readRowAmount(sc, maxRows);
    	
    	}catch(InputException i) {
    		System.out.println("Error " + i.getMessage());
    		ledsOnOff(boardService);
    	}
    	leds = aufgabe1_1.addLeds(rowAmount, boardService, leds);
    	
    	aufgabe1_1.executeLed(leds, boardService);
    	boardService.pauseExecution(2000);
    	boardService.removeAllLeds();
    }
 
}