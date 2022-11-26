public class testLinkedBinaryTree {
    public static void main(String[] args) {
/*
        BinaryTreeNode<Character> A = new BinaryTreeNode<>('A');
        BinaryTreeNode<Character> B = new BinaryTreeNode<>('B');
        BinaryTreeNode<Character> C = new BinaryTreeNode<>('C');
        BinaryTreeNode<Character> D = new BinaryTreeNode<>('D');
        BinaryTreeNode<Character> E = new BinaryTreeNode<>('E');
        BinaryTreeNode<Character> F = new BinaryTreeNode<>('F');
        A.left = B;
        A.right = C;
        B.left = D;
        D.right = E;
        E.right = F;
 */
        BTreeClass<Character> test = new BTreeClass<>();
        //test.CreateBTree("A(B(C(D(E(F(G(H(I)))))))");
        //test.CreateBTree("A(,B(,C(,D(,E(,F(,G(,H(,I)))))))");
        test.CreateBTree("A(B(D(H(P,Q),I(R,S)),E(J(T,U),K(V,W))),C(F(L(X,Y),M(Z,0)),G(N(1,2),O(3,4))))");
        int totalTime = 0, times = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i=0; i<times; i++) {
            for (int j = 0; j < 1; j++)
                test.toString();
        }
        long endTime = System.currentTimeMillis();
        totalTime += endTime - startTime;
        System.out.println(totalTime);
        System.out.println(test.toString());
        /*
        int totalTime = 0, times = 100;
        long startTime = System.currentTimeMillis();
        for (int i=0; i<times; i++) {
            for (int j = 0; j < 1000000; j++)
                test.height();
        }
        long endTime = System.currentTimeMillis();
        totalTime += endTime - startTime;
        System.out.println(totalTime / times);
        System.out.println(test.toString());
         */
    }
}
