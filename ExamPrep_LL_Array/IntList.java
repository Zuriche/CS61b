package ExamPrep_LL_Array;

/* Suppose we have the following IntList class, as defined in lecture and lab, with an
added skippify function.
Suppose that we define two IntLists as follows.
1 IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
2 IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
Fill in the method skippify such that the result of calling skippify on A and B
are as below:
- After calling A.skippify(), A: (1, 3, 6, 10)
- After calling B.skippify(), B: (9, 7, 4)   */


public class IntList {
    public int first;
    public IntList rest;

    /*@Override
    /* public boolean equals(Object o) { } */
    /* public static IntList list(int... args) {  } */

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }

            p.rest = next;
            p = p.rest;
            n++;
        }
    }
}
