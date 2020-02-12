package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[]  map = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char[]  arr_xo = {'X', 'O'};
        int     i = 1;

        printMap(map);
        while (checkMap(map,arr_xo[i % 2])) {
            i++;
//            System.out.println(arr_xo[i % 2]);
//            System.out.println(i);
            readCoordinates(map, arr_xo[i % 2]);
            printMap(map);
//            i++;
        }
    }

    private static void readCoordinates(char[] map ,char xo) {
        Scanner sc = new Scanner(System.in);
        int val_x = 0;
        int val_y = 0;

        while (val_x == 0) {
            System.out.print("Enter the coordinates: ");
            if (sc.hasNextInt()) {
                val_x = sc.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (sc.hasNextInt()) {
                val_y = sc.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                val_x = 0;
                continue;
            }
            if (val_x > 3 || val_x < 1 || val_y > 3 || val_y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                val_x = 0;
                continue;
            }
            if (map[(3 - val_x) * 3 + val_y - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                val_x = 0;
                continue;
            } else {
                map[(3 - val_x) * 3 + val_y - 1] = xo;
                break;
            }
        }
    }

    private static boolean checkMap(char[] map, char xo) {
        int val_x = 0;
        int val_y = 0;

        val_x = valuesXO(map, 'X');
        val_y = valuesXO(map, 'O');
        if (checkColums(map, xo) || checkRows(map, xo) || checkDio(map, xo)) {
            System.out.println(xo + " wins");
            return false;
        }
        if (val_x + val_y == 9) {
            System.out.println("Draw");
            return false;
        }
        return true;
    }

    private static int valuesXO(char[] map, char xo) {
        int res = 0;

        for (int i = 0; i < map.length; i++) {
            if (map[i] == xo) {
                res++;
            }
        }
        return (res);
    }

    private static boolean checkColums(char[] map, char xo) {

        for (int i = 0; i < 3; i++) {
            if (map[i] == xo && map[3 + i] == xo && map[6 + i] == xo) {
                return (true);
            }
        }
        return (false);
    }

    private static boolean checkRows (char[] map,char xo) {

        for (int i = 0; i < 3; i++) {
            if (map[3 * i] == xo && map[i * 3 + 1] == xo && map[i * 3 + 2] == xo) {
                return (true);
            }
        }
        return (false);
    }

    private static boolean checkDio(char[] map, char xo) {

        if (map[0] == xo && map[4] == xo && map[8] == xo) {
            return (true);
        } else if (map[2] == xo && map[4] == xo && map[6] == xo) {
            return (true);
        } else {
            return (false);
        }
    }
    private static void printMap(char[] map) {
        System.out.println("---------");
        System.out.println("|" + " " + map[0] + " " + map[1] + " " + map[2] + " " + "|");
        System.out.println("|" + " " + map[3] + " " + map[4] + " " + map[5] + " " + "|");
        System.out.println("|" + " " + map[6] + " " + map[7] + " " + map[8] + " " + "|");
        System.out.println("---------");
    }
}