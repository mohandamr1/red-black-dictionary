
package model;


public class RBNode<T> {
    private RBNode left;
    private RBNode right;
    private RBNode parent;
    private Color color;
    private T data;

    public RBNode getLeft() {
        return left;
    }

    public T getData() {
        return data;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
