public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
    }
    public LabBinarySearchTree(BTNode<T> root) {
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BTNode<T> root = getRoot();
        if(root == null)
            return new LabBinarySearchTree<T>();

        return new LabBinarySearchTree<T>(cln(root));
    }

    private <T extends Comparable<T>> BTNode<T> cln(BTNode<T> node){
    BTNode<T> Cnode = new BTNode<T>(node.value,null,null);
    if(node.left != null)
        Cnode.left=cln(node.left);
    if(node.right != null)
        Cnode.right = cln(node.right);
        return Cnode;
    }
    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> current = find(getRoot(),value);
        if(current == null)
            return null;
        if(current.right != null){
        current = current.right;

        while(current.left != null)
          current= current.left;
        }
        else
          return null;
        return current;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        BTNode<T> current = find(getRoot(),value);
        if(current == null)
            return null;
        if(current.left != null){
        current = current.left;

        while(current.right != null)
           current= current.right;
        }
        else
          return null;
        return current;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        BTNode<T> root = getRoot();
        if (root == null || root == node)
            return null;
        while (root.left != node && root.right != node && root.left != null && root.right != null) {
            if (root.value.compareTo(node.value) < 0)
                root = root.right;
            else
                root = root.left;
        }
        return root;
    }


}
