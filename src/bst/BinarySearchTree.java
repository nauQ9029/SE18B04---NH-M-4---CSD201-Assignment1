/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bst;

/**
 *
 * @author TRUNG KIEN
 */
class Node {

    String name;
    double equatorialDiameter;
    double mass;
    double au;
    double julianYear;
    Node left, right;

    Node(String name, double equatorialDiameter, double mass, double au, double julianYear) {
        this.name = name;
        this.equatorialDiameter = equatorialDiameter;
        this.mass = mass;
        this.au = au;
        this.julianYear = julianYear;
        left = right = null;
    }
}

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    Node search(Node p, double equatorialDiameter) {
        if (p == null) {
            return null;
        }
        if (p.equatorialDiameter == equatorialDiameter) {
            return p;
        }
        if (equatorialDiameter < p.equatorialDiameter) {
            return search(p.left, equatorialDiameter);
        } else {
            return search(p.right, equatorialDiameter);
        }
    }

    void insert(String name, double equatorialDiameter, double mass, double au, double julianYear) {
        if (root == null) {
            root = new Node(name, equatorialDiameter, mass, au, julianYear);
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (equatorialDiameter == p.equatorialDiameter) {
                System.out.println(" The object with equatorial diameter " + equatorialDiameter + " already exists, no insertion");
                return;
            }
            f = p;
            if (equatorialDiameter < p.equatorialDiameter) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (equatorialDiameter < f.equatorialDiameter) {
            f.left = new Node(name, equatorialDiameter, mass, au, julianYear);
        } else {
            f.right = new Node(name, equatorialDiameter, mass, au, julianYear);
        }
    }

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.println("Name: " + p.name + ", Equatorial Diameter: " + p.equatorialDiameter);
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

}

public class BinarySearchTree {

    public static void main(String[] args) {
        BSTree tree = new BSTree();

        // Inserting objects with equatorial diameter information
        tree.insert("Mercury", 0.383, 0.06, 0.39, 0.24);
        tree.insert("Venus", 0.949, 0.81, 0.72, 0.62);
        tree.insert("Earth", 1.000, 1.00, 1.00, 1.00);
        tree.insert("Mars", 0.532, 0.11, 1.52, 1.88);
        tree.insert("Jupiter", 11.209, 317.83, 5.20, 11.86);
        tree.insert("Saturn", 9.449, 95.16, 9.54, 29.45);
        tree.insert("Neptune", 3.883, 17.15, 30.07, 164.79);
        tree.insert("Uranus", 4.007, 14.54, 19.19, 84.02);

        // Processing in order of equatorial diameter
        System.out.println("\nProcessing in order of equatorial diameter:");
        tree.inOrder(tree.root);
    }
}
