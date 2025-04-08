package ch.hslu.prg.ledmuster.g02;

import java.util.InputMismatchException;
import java.util.Scanner;

import ch.hslu.prg.ledboard.proxy.BoardService;
import ch.hslu.prg.ledboard.proxy.Led;
import ch.hslu.prg.ledboard.proxy.LedColor;
import ch.hslu.prg.ledmuster.g02.exceptions.InputException;


public class Aufgabe1_2 {

    public static void ledsColoredOnOff(BoardService boardService) throws InputException {
        int rowAmount = readRowAmount();
        LedColor color = readColor();
        Led[][] leds = addLeds(rowAmount, color, boardService);
        executeLed(leds, boardService);
        boardService.pauseExecution(2000);
        boardService.removeAllLeds();
        
    }

    private static int readRowAmount() throws InputException {
        Scanner sc = new Scanner(System.in);
        int maxRows = BoardService.MAX_ROWS;

        System.out.println("Gib die Anzahl Reihen von: 1-" + maxRows + " ein:");
        try {
            int input = sc.nextInt();
            sc.nextLine();
            if (input < 1 || input > maxRows) {
                throw new InputException("Die Eingabe muss eine Zahl zwischen 1-" + maxRows + " sein");
                
            }
            return input;
        } catch (InputException | InputMismatchException i ) {
        	readRowAmount();
            throw new InputException("Bitte eine ganze Zahl eingeben");
        }
    }

    private static LedColor readColor() throws InputException {
        Scanner sc = new Scanner(System.in);

        

        try {
        	System.out.println("Wählen Sie bitte eine Farbe zwischen folgende: [RED], [BLUE], [GREEN], [RANDOM]");
            String colorInput = sc.nextLine().trim().toUpperCase();
            return LedColor.valueOf(colorInput);
        } catch (IllegalArgumentException e) {
        	readColor();
            throw new InputException("Ungültige Farbeingabe");
        }
    }

    private static Led[][] addLeds(int rowAmount, LedColor color, BoardService boardService) {
        boardService.pauseExecution(500);
        return boardService.add(rowAmount, color);
    }

    private static void executeLed(Led[][] leds, BoardService boardService) {
        for (int i = 0; i < 3; i++) {
            for (int rows = leds.length - 1; rows >= 0; rows--) {
                for (int collumns = leds[rows].length - 1; collumns >= 0; collumns--) {
                    leds[rows][collumns].turnOn();
                    boardService.pauseExecution(50);
                }
            }

            boardService.pauseExecution(250);

            for (int rows = 0; rows < leds.length; rows++) {
                for (int collumns = 0; collumns < leds[rows].length; collumns++) {
                    leds[rows][collumns].turnOff();
                    boardService.pauseExecution(50);
                }
            }

            boardService.pauseExecution(250);
        }
    }
}