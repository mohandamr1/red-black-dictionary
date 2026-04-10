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
    
    public boolean search(RBNode<String> root,String key ){
        if(root.getData()==null)
            return false;
        else if( root.getData().equalsIgnoreCase( key ) )
            return true;
        else if ( root.getData().compareToIgnoreCase(key)>0) {
            search(root.getLeft(),key);
        }
        else
            search(root.getRight(),key);
        return false;
    }
    public void insert(){
        
    }
    
    public int getHeight(RBNode<String> root){
       
    }
    
    public int getSize(){
        return this.size;
    }
    
    public int getBlackHeight ( ){



    }
    
}
