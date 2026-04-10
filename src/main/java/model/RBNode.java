
package model;


public class RBNode<T> {
    private RBNode left;
    private RBNode right;
    private RBNode parent;
    private NodeColor color;
    private T data;

    public RBNode(){
        left = null;
        right = null;
        parent = null;
    }
    
    public RBNode getLeft() {
        return left;
    }

    public T getData() {
        return data;
    }
    
    public void setData(T data){
        this.data = data;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }
    
}
