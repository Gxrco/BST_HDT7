package Controller;

import Model.BinaryTree;
import java.util.ArrayList;

public class Translator {
    public ArrayList<ArrayList<String>> getFromEnglish(BinaryTree<String, ArrayList<String>> ED, ArrayList<String> phrase){
        ArrayList<ArrayList<String>> translations = new ArrayList<>();
        ArrayList<String> fTranslation = new ArrayList<>();
        ArrayList<String> sTranslation = new ArrayList<>();
        translations.add(fTranslation); translations.add(sTranslation);
        for (String word:phrase) {
            if(ED.contains(word)){
                translations.get(0).add(ED.get(word).get(0));
            }else{
                translations.get(0).add("*"+word+"*");
            }
        }

        for (String word:phrase) {
            if(ED.contains(word)){
                translations.get(1).add(ED.get(word).get(1));
            }else{
                translations.get(1).add("*"+word+"*");
            }
        }
        return translations;
    }

    public ArrayList<ArrayList<String>> getFromFrench(BinaryTree<String, ArrayList<String>> FD, ArrayList<String> phrase){
        ArrayList<ArrayList<String>> translations = new ArrayList<ArrayList<String>>();
        ArrayList<String> fTranslation = new ArrayList<>();
        ArrayList<String> sTranslation = new ArrayList<>();
        translations.add(fTranslation); translations.add(sTranslation);
        for (String word:phrase) {
            if(FD.contains(word)){
                translations.get(0).add(FD.get(word).get(0));
            }else{
                translations.get(0).add("*"+word+"*");
            }
        }

        for (String word:phrase) {
            if(FD.contains(word)){
                translations.get(1).add(FD.get(word).get(1));
            }else{
                translations.get(1).add("*"+word+"*");
            }
        }
        return translations;
    }

}
