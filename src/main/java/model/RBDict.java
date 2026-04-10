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
        if(root==null)
            return false;
        else if( root.getData().equalsIgnoreCase( key ) )
            return true;
        else if ( root.getData().compareToIgnoreCase(key)>0 )
             return search(root.getLeft(),key);

        else
           return search(root.getRight(),key);

    }
    public void insert(){
        
    }
    
    public int getHeight(RBNode<String> root){
        if(root==null)
            return 0;
        int Lheight=getHeight( root.getLeft() );
        int Rheight=getHeight( root.getRight() );
        
        return 1+ Math.max(Lheight,Rheight);
    }
    
    public int getSize(){
        return this.size;
    }
    
    public int getBlackHeight ( RBNode<String> root){
        if(root==null)
            return 0;
        int Lheight=getBlackHeight( root.getLeft() );
        int Rheight=getBlackHeight( root.getRight() );

        if(Lheight== Rheight && root.getColor()==Color.BLACK)
            return 1+ Lheight ;


        return Lheight;


    }
    
}
