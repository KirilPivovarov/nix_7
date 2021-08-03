package ua.com.chess;

import ua.com.chess.option.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Controller {
	
	static Scanner user_input = new Scanner(System.in);

	
	public static void main(String[] args) {
		Chessboard myChessboard = new Chessboard();

		System.out.printf(" Start game  1\n "
				+ "Instruction 2 \n"
				+ " Exit 0 \n");

		int choose = user_input.nextInt();

		while (myChessboard.getGameRunning()) {
			switch (choose) {
				case 1:
					while (myChessboard.getGameRunning()) {
						myChessboard.printBoard();
						myChessboard.move();
					}
					break;
				case 2:
					instruction.printInstruction();
				case 0:
					System.out.println("Thanks for playing.");
					return;
				default:
					System.out.println("Incorrect value! Try again.\n");

			}

		}
	}

}
