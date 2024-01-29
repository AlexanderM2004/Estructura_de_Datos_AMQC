package edd_parcial2_prueba_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class FirstCommonAncestorSolution {
    class AncestorNode {
        boolean nodeFound;
        Node ancestor;
    }
    public Node firstCommonAncestor(Node root, Node firstNode, Node secondNode) {
        return postOrderSearch(root, firstNode, secondNode).ancestor;
    }
    private AncestorNode postOrderSearch(Node current, Node firstNode, Node secondNode) {
        if (current == null) {
        return new AncestorNode();
        }
        
        AncestorNode leftResult = postOrderSearch(current.left, firstNode, secondNode);
        if (leftResult.ancestor != null) return leftResult;
        AncestorNode rightResult = postOrderSearch(current.right, firstNode, secondNode);
        if (rightResult.ancestor != null) return rightResult;
        AncestorNode result = new AncestorNode();
        if (leftResult.nodeFound && rightResult.nodeFound) {
            result.ancestor = current;
            return result;
        }
        result.nodeFound =
        current == firstNode
        || current == secondNode
        || leftResult.nodeFound
        || rightResult.nodeFound;
        return result;
    }

}
