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

    public static void insertWord(String word) {
        word = word.trim();

        if (tree.search(word)) {
            System.out.println("ERROR: Word already in dictionary!");
            return;
        }

      
        tree.insert(word);

       
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(word);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("ERROR: Could not update dictionary file.");
        }
    }

    // Lookup word
    public static void lookupWord(String word) {
        if (tree.search(word.trim())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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