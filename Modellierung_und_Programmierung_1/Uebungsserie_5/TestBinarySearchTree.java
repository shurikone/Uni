public class TestBinarySearchTree {

    public static void main(String[] args){
        BinarySearchTree bsBaum1 = new BinarySearchTree();
        bsBaum1.add(50.0);
        bsBaum1.add(25.0);
        bsBaum1.add(75.0);
        bsBaum1.add(12.5);
        bsBaum1.add(87.5);
        bsBaum1.add(37.5);
        bsBaum1.add(62.5);
        //50.0, 25.0, 75.0, 12.5, 87.5, 37.5, 62.5.

        System.out.println("Die tiefe des Baums ist: " + bsBaum1.getDepth());

        BinarySearchTree bsBaum2 = new BinarySearchTree();
        bsBaum2.add(12.5);
        bsBaum2.add(25.0);
        bsBaum2.add(37.5);
        bsBaum2.add(50.0);
        bsBaum2.add(62.5);
        bsBaum2.add(75.0);
        bsBaum2.add(87.5);
        //12.5, 25.0, 37.5, 50.0, 62.5, 75.0, 87.5

        System.out.println("Die tiefe des Baums ist: " + bsBaum2.getDepth());


    }
}
