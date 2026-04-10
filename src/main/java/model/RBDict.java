package model;


public class RBDict {
    private RBNode<String> root;
    private int height;
    private int size;

    public RBDict() {
        this.root = null;
        this.height = 0;
        this.size = 0;
    }
    
    public boolean search(){
        return true;
    }
    public void insert(){
        
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public int getBlackHeight(){
        return 0;
    }
    
}
