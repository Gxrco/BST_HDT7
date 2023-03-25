package View;

import Controller.Translator;
import Controller.dividedWords;
import Model.Association;
import Model.BinaryTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) throws IOException {
        BinaryTree<String,ArrayList<String>> EnglishDict = new BinaryTree<>();
        BinaryTree<String,ArrayList<String>> FrenchDict = new BinaryTree<>();
        Scanner sc = new Scanner(System.in);

        setUpByFile("diccionario.txt", EnglishDict, FrenchDict);
        System.out.println("Bienvenido al sistema de traduccion");
        System.out.println("-".repeat(50));
        boolean check = true;
        while(check){
            System.out.println("Menu\nSeleccione el idioma que ingresara para traducir");
            System.out.println("-".repeat(50));
            System.out.println("1. Ingles\n2. Frances\n3. Salir");
            System.out.println("-".repeat(50));
            String opt = sc.nextLine();
            check = optionSelector(opt, EnglishDict, FrenchDict);
        }
    }

    public static void setUpByFile(String path, BinaryTree<String, ArrayList<String>> ED, BinaryTree<String, ArrayList<String>> FD){
            dividedWords FR = new dividedWords();
            ArrayList<String[]> values =FR.readingFile(path);
        for (String[] val:values) {
            ArrayList<String> newArray = new ArrayList<>();
            Association<String, ArrayList<String>> newAssoc;
            newArray.add(val[1]); newArray.add(val[2]);
            newAssoc = new Association<>(val[0], newArray);
            ED.insert(newAssoc);
        }

        for (String[] val: values){
            ArrayList<String> newArray2 = new ArrayList<>();
            Association<String, ArrayList<String>> newAssoc;
            newArray2.add(val[0]); newArray2.add(val[1]);
            newAssoc = new Association<>(val[2], newArray2);
            FD.insert(newAssoc);
        }
        }

        public static boolean optionSelector(String op, BinaryTree<String, ArrayList<String>> ED, BinaryTree<String, ArrayList<String>> FD) throws IOException {
            Translator trans = new Translator();
            dividedWords dW = new dividedWords();
            switch(op){
                case "1":
                    ArrayList<ArrayList<String>> translations = trans.getFromEnglish(ED, dW.getPhrase("frase.txt"));
                    showNewPhrase(translations);
                    break;
                case "2":
                    ArrayList<ArrayList<String>> tr = trans.getFromFrench(FD, dW.getPhrase("frase.txt"));
                    showNewPhrase(tr);
                    break;
                case "3":
                    return false;
                case "4":
                    System.out.println("Opcion no disponible");
                    break;
            }
            return true;
        }

        public static void showNewPhrase(ArrayList<ArrayList<String>> lists){
            ArrayList<String> phrases = new ArrayList<>();
            phrases.add(String.join(" ", lists.get(0)));
            phrases.add(String.join(" ", lists.get(1)));
            System.out.println(" ");
            System.out.println("Traducciones");
            System.out.println("-".repeat(50));
            for (String complete: phrases) {
                System.out.println(complete);
            }
            System.out.println("-".repeat(50));
        }
    }
