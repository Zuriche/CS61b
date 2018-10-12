package IntList;



public class List1Exercise {
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */

        IntList Q = new IntList(L.first + x, null);
        IntList ptr = Q;
        L = L.rest;
        while (L != null) {
            ptr.rest = new IntList(L.first + x, null);
            L = L.rest;
            ptr = ptr.rest;
        }

        return Q;


    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList Q = L;
        L.first = L.first + x;
        L = L.rest;
        while (L != null) {
            L.first = L.first + x;
            L = L.rest;
        }

        return Q;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        //System.out.println(IntList.squareListIterative(L));
        //IntList.dSquareList(L);
        //System.out.println(L);
        IntList L1 = new IntList(1, null);
        L1.rest = new IntList(2, null);
        L1.rest.rest = new IntList(3, null);
        IntList.dcatenate(L, L1);
        System.out.println(L);
        //System.out.println(IntList.catenate(L, L));




        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        //System.out.println(incrList(L, 3));
        //System.out.println(dincrList(L, 3));
        //System.out.println(L);
        // System.out.println(dincrList(L, 3));
    }

}
