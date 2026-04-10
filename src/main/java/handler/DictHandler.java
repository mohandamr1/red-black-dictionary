package handler;

import java.io.*;
import model.RBDict;
import model.RBNode;
import model.NodeColor;

public class DictHandler {
    
    private static RBDict tree;
    private static String filePath;
    
    public DictHandler(String filePath){
        tree = new RBDict();
        DictHandler.filePath = filePath;
    }
    public static void loadDictionary() {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;

            while ((word = br.readLine()) != null) {
                word = word.trim();
                if (!word.isEmpty()) {
                    insertWord(word);
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR: Could not load dictionary file.");
        }
    }

    public static String insertWord(String word) {
    word = word.trim();
    RBNode node = new RBNode();
    node.setData(word);
    node.setColor(NodeColor.RED);
 
    
    if (tree.search(tree.getRoot(), word))
        return "ERROR: Word already in dictionary!";
    tree.insert(tree.getRoot(), node);
    
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
        bw.write(word);
        bw.newLine();
    } catch (IOException e) {
        return "ERROR: Could not update dictionary file.";
    }
    return "OK";
}

   
    public static boolean lookupWord(String word) {
        return tree.search(tree.getRoot(),word.trim());
    }


    public static int getSize() {
        return tree.getSize(); 
    }
    
    public static int getHeight() {
        return tree.getHeight(tree.getRoot()); 
    }
    
    public static int getBlackHeight() {
        return tree.getBlackHeight(tree.getRoot());
    }
}