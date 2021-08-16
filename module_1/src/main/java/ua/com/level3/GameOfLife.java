package ua.com.level3;

import java.util.Scanner;
import java.util.Random;

public class GameOfLife {

    private static int WIDTH;
    private static int HEIGHT;
    private static int AMOUNT;
    private static final int LIVE = 1;
    private static final int DEAD = 0;
    private static boolean isStopped = false;
    private static int[][] board;
    private static Scanner scanner = new Scanner(System.in);

    public static void startLife() {
        init();
        draw(board);
        play(board);
        System.out.println("Game over");
    }

    private static void draw(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("==============");
        System.out.println();
    }

    private static void init() {
        System.out.println("Enter Height of board:");
        HEIGHT = scanner.nextInt();
        System.out.println("Enter Width of board:");
        WIDTH = scanner.nextInt();
        System.out.println("Enter MAX_AMOUNT of live cell:");
        AMOUNT = scanner.nextInt();

        board = new int[HEIGHT][WIDTH];
        int count = 0;
        Random percent = new Random();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (percent.nextInt(100) < AMOUNT && count <= AMOUNT) {
                    board[i][j] = LIVE;
                    count++;
                }
            }
        }
    }


    public static void play(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);


                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
