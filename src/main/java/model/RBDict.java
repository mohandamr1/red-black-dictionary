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
    
    public boolean search(String word){
        return true;
    }
    public void insert(String word){
        
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getSize(){
        return this.size;
    }
    
    
    public RBNode<String> getRoot(){
        return this.root;
    }
    
    
    public static int getBlackHeight(RBNode root){
        if(root == null || root.getLeft() == null){
            return 1;
        }
        
        if(root.getLeft().getColor() == Color.BLACK){
            return getBlackHeight(root.getLeft()) + 1;
        }
        else{
            return getBlackHeight(root.getLeft());
        }
       
    }
    
}
