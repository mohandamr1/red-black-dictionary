package filehandler;

import java.io.*;
import model.RBDict;

public class DictFileHandler {
    
    private static RBDict tree;
    private static String filePath;
    
    public DictFileHandler(String filePath){
        tree = new RBDict();
        DictFileHandler.filePath = filePath;
    }
    public static void loadDictionary() {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;

            while ((word = br.readLine()) != null) {
                word = word.trim();
                if (!word.isEmpty()) {
                    tree.insert(word);
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR: Could not load dictionary file.");
        }
    }

    public static String insertWord(String word) {
    word = word.trim();
    if (tree.search(word))
        return "ERROR: Word already in dictionary!";
    tree.insert(word);
    
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
        bw.write(word);
        bw.newLine();
    } catch (IOException e) {
        return "ERROR: Could not update dictionary file.";
    }
    return "OK";
}

   
    public static boolean lookupWord(String word) {
        return tree.search(word.trim());
    }


    public static int getSize() {
        return tree.getSize(); 
    }
    
    public static int getHeight() {
        return tree.getHeight(); 
    }
    
    public static int getBlackHeight() {
        return RBDict.getBlackHeight(tree.getRoot()); 
    }
}