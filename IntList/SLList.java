package IntList;

public class SLList<anytype> {

    private class StuffNode{
        private anytype item;
        private StuffNode next;
        private StuffNode(anytype item, StuffNode next) {
            this.item = item;
            this.next = next;
        }
    }


    private StuffNode sentinal;
    private int size;
    public SLList(anytype x) {
        sentinal = new StuffNode(null, null);
        sentinal.next = new StuffNode(x, null);
        size = 1;
    }
    public SLList(){
        sentinal = new StuffNode(null, null);
        size = 0;
    }
    public void addFirst(anytype x) {
        sentinal.next = new StuffNode(x, sentinal.next);
        size += 1;
    }
    public anytype getFirst(){

        return sentinal.next.item;
    }
    public void addLast(anytype x){
        StuffNode p = sentinal;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
        size += 1;
    }

//helper function: return the size of the list that starts at IntNode p.
    /*
    less efficient compared with size();

    public static int size(IntNode p) {

        if(p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size(){
        return size(first);
    }
    */
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList(5);
        L.addFirst(10);
        L.addFirst(15);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size());
        SLList<String> S = new SLList("am");
        S.addFirst("I");
        S.addLast("Lixue");
        System.out.println(S.size());
        System.out.println(S.getFirst());




    }
}