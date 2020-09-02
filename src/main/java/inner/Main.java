package main.java.inner;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (cheekArgument(args)) {
            List<Pair<Integer, String>> fistTable = loadingFromFile(args[0]);
            List<Pair<Integer, String>> secondTable = loadingFromFile(args[1]);
            System.out.println("-----------");
            ArrayLogic arrayLogic = new ArrayLogic(fistTable, secondTable);
            arrayLogic.showTable();
            System.out.println("------------");
            LinkedLogic linkedLogic = new LinkedLogic(fistTable, secondTable);
            linkedLogic.showTable();
            System.out.println("------------");
            MapLogic mapLogic = new MapLogic(fistTable, secondTable);
            mapLogic.showTable();


        }
    }

    static boolean cheekArgument(String[] args) {
        if (args.length != 2) return false;
        return true;
    }

    static List<Pair<Integer, String>> loadingFromFile(String path) {
        File file = new File(path);
        List<Pair<Integer, String>> table = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.split(" ").length != 2) {
                    // System.out.println("Таблица должна содержать два столбца!");
                    continue;
                }
                if (!line.split(" ")[0].matches("[0-9]")) {
                    // System.out.println("Id должно быть числом!");
                    continue;
                }

                table.add(new Pair<>(Integer.parseInt(line.split(" ")[0]), line.split(" ")[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return table;
    }
}
