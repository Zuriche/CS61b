package ExamPrep_LL_Array;

public class RemoveDuplicates {
    class IntList {
        public int first;
        public IntList rest;
        public IntList (int f, IntList r) {
            this.first = f;
            this.rest = r;
        }
    }

    /**
     * Given a sorted linked list of items - remove duplicates.
     * For example given 1 -> 2 -> 2 -> 2 -> 3,
     * Mutate it to become 1 -> 2 -> 3 (destructively)
     */

    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }

        IntList curr = p.rest;
        IntList prev = p;

        while (curr != null) {
            if (curr.first == prev.first) {
                prev.rest = curr.rest;
            } else {
                prev = prev.rest;
            }
            curr = curr.rest;
        }
    }


}
