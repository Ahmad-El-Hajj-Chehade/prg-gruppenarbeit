package ch.hslu.prg.ledmuster.g02;

import ch.hslu.prg.ledboard.proxy.BoardService;
import ch.hslu.prg.ledboard.proxy.Led;
import ch.hslu.prg.ledboard.proxy.LedColor;
import ch.hslu.prg.ledmuster.g02.exceptions.InputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientApp {
	
    public static void main(String[] args) throws InputException {
    	
        BoardService boardService = new BoardService();
        
       Aufgabe1_1.ledsOnOff(boardService);
       Aufgabe1_2.ledsColoredOnOff(boardService);
    }

 
}