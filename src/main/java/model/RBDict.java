package model;

public class RBDict {

    private RBNode<String> root;
    private int size;

    public RBDict() {
        this.root = null;
        this.size = 0;
    }

    public boolean search(RBNode<String> root, String key) {
        if (root == null) {
            return false;
        } else if (root.getData().equalsIgnoreCase(key)) {
            return true;
        } else if (root.getData().compareToIgnoreCase(key) > 0) {
            return search(root.getLeft(), key);
        } else {
            return search(root.getRight(), key);
        }

    }

    public void insert(RBNode<String> root, RBNode<String> node) {
        if (this.root == null) {
            node.setColor(NodeColor.BLACK);
            this.root = node;
            size++;
            return;
        }

        RBNode<String> current = this.root;
        RBNode<String> parent = null;

        while (current != null) {
            parent = current;
            int cmp = node.getData().compareToIgnoreCase(current.getData());
            if (cmp < 0) {
                current = current.getLeft();
            } else if (cmp > 0) {
                current = current.getRight();
            } else {
                return;
            }
        }

        node.setParent(parent);
        int cmp = node.getData().compareToIgnoreCase(parent.getData());
        if (cmp < 0) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        node.setColor(NodeColor.RED);
        node.setLeft(null);
        node.setRight(null);
        size++;

        fixInsert(node);
    }

    private void fixInsert(RBNode<String> node) {
        while (node != this.root && node.getParent().getColor() == NodeColor.RED) {
            RBNode<String> parent = node.getParent();
            RBNode<String> grandparent = parent.getParent();

            if (grandparent == null)
                break;

            if (parent == grandparent.getLeft()) {
                RBNode<String> uncle = grandparent.getRight();

                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    parent.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grandparent.setColor(NodeColor.RED);
                    node = grandparent;

                } else {
                    if (node == parent.getRight()) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.getParent();
                    }
                    parent.setColor(NodeColor.BLACK);
                    grandparent.setColor(NodeColor.RED);
                    rotateRight(grandparent);
                }

            } else {
                RBNode<String> uncle = grandparent.getLeft();

                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    parent.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grandparent.setColor(NodeColor.RED);
                    node = grandparent;

                } else {
                    if (node == parent.getLeft()) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.getParent();
                    }
                    parent.setColor(NodeColor.BLACK);
                    grandparent.setColor(NodeColor.RED);
                    rotateLeft(grandparent);
                }
            }
        }
        this.root.setColor(NodeColor.BLACK);
    }

    private void rotateLeft(RBNode<String> x) {
        RBNode<String> y = x.getRight();
        x.setRight(y.getLeft());

        if (y.getLeft() != null) {
            y.getLeft().setParent(x);
        }

        y.setParent(x.getParent());

        if (x.getParent() == null) {
            this.root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }

        y.setLeft(x);
        x.setParent(y);
    }

    private void rotateRight(RBNode<String> y) {
        RBNode<String> x = y.getLeft();
        y.setLeft(x.getRight());

        if (x.getRight() != null) {
            x.getRight().setParent(y);
        }

        x.setParent(y.getParent());

        if (y.getParent() == null) {
            this.root = x;
        } else if (y == y.getParent().getRight()) {
            y.getParent().setRight(x);
        } else {
            y.getParent().setLeft(x);
        }

        x.setRight(y);
        y.setParent(x);
    }

    public RBNode getRoot() {
        return this.root;
    }

    public int getHeight(RBNode<String> root) {
        if (root == null) {
            return 0;
        }
        int Lheight = getHeight(root.getLeft());
        int Rheight = getHeight(root.getRight());

        return 1 + Math.max(Lheight, Rheight);
    }

    public int getSize() {
        return this.size;
    }

    public int getBlackHeight(RBNode<String> root) {
        if (root == null)
            return 0;

        if (root.getColor() == NodeColor.BLACK)
            return 1 + getBlackHeight(root.getLeft());
        else
            return getBlackHeight(root.getLeft());
    }
}
