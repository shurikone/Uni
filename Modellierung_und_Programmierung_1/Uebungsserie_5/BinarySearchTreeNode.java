
public class BinarySearchTreeNode {

    BinarySearchTreeNode linkesKind = null;
    BinarySearchTreeNode rechtesKind = null;
    Double hierZahl;



    public BinarySearchTreeNode() {}


    public void add(double zahl){
        if (hierZahl == null){
            hierZahl = zahl;
        }
        else if (hierZahl == zahl){
            //tue nichts
        }
        else if (hierZahl < zahl){
            if (rechtesKind == null){
                rechtesKind = new BinarySearchTreeNode();
                rechtesKind.add(zahl);
            }
            else
            {
                rechtesKind.add(zahl);
            }
        }
        else if (hierZahl > zahl) {
            if (linkesKind == null){
                linkesKind = new BinarySearchTreeNode();
                linkesKind.add(zahl);
            }
            else
            {
                linkesKind.add(zahl);
            }
        }
    }

    public int getDepth(){
        int linksTiefe = 0;
        int rechtsTiefe = 0;
        if (hierZahl == null){
            return 0;
        }
        else
        {
            if (linkesKind != null)
            linksTiefe = linkesKind.getDepth();
            else if (rechtesKind != null)
            rechtsTiefe = rechtesKind.getDepth();
        }
        return max(linksTiefe, rechtsTiefe) + 1;
    }

    private int max(int a, int b)
    {
        if (a>b)
            return a;
        else
            return b;
    }



}
