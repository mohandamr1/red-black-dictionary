package model;


public class RB<T> {
    private RBNode<T> root;
    private int height;
    private int size;

    public RB() {
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
