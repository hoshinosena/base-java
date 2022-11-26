/*
 * Copyright 2022 hoshinosena(github)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bjava.util.Tree;

import bjava.util.Queue.LinkedQueue;
import bjava.util.Queue.Queue;
import bjava.util.Stack.SqStack;
import bjava.util.Stack.Stack;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    protected BinaryTreeNode<E> root;
    public LinkedBinaryTree() {
        root = null;
    }
    public LinkedBinaryTree(E element) {
        root = new BinaryTreeNode<>(element);
    }
    public LinkedBinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
    }
    public LinkedBinaryTree(E element, BinaryTreeNode<E> leftNode, BinaryTreeNode<E> rightNode) {
        root = new BinaryTreeNode<>(element);
        root.left = leftNode;
        root.right = rightNode;
    }
    public void removeLeftTree() {
        root.left = null;
    }
    public void removeRightTree() {
        root.right = null;
    }
    public void removeAllTree() {
        root = null;
    }
    public boolean empty() {
        return root == null;
    }
    public BinaryTreeNode<E> search(E element) {
        Stack<BinaryTreeNode<E>> temp = new SqStack<>();
        BinaryTreeNode<E> point = root;
        while (!temp.empty() || point != null) {
            while (point != null) {
                if (point.data.equals(element))
                    return point;
                temp.push(point);
                point = point.left;
            }
            if (!temp.empty())
                point = temp.pop().right;
        }
        throw new IllegalArgumentException("元素非法");
    }
    public boolean contains(E element) {
        try {
            search(element);
        }
        catch (Exception IllegalArgumentException) {
            return false;
        }
        return true;
    }
   /**
    * 此处提供透过指定根节点计算size的方法
    * 此方法是线程安全的
    *
    * 我不认为有这样做的必要
    * 既然要指定了根节点就应该在节点对象中直接提供
    public int size(BinaryTreeNode<E> root) {
        Stack<BinaryTreeNode<E>> temp = new LinkedStack<>();
        BinaryTreeNode<E> point = root;
        int num = 0;
        while (!temp.empty() || point != null) {
            while (point != null) {
                num++;
                temp.push(point);
                point = point.left;
            }
            if (!temp.empty())
            point = temp.pop().right;
        }
        return ++num;
    }
    */
    public int size() {
       return root == null ? 0 : root.num();
   }
   /**
    * 此处提供透过指定根节点计算height的方法
    * 此方法是线程安全的
    *
    * 我不认为有这样做的必要
    * 既然要指定了根节点就应该在节点对象中直接提供
    public int height(BinaryTreeNode<E> root) {
        Queue<BinaryTreeNode<E>> temp = new LinkedQueue<>();
        BinaryTreeNode<E> point = root;
        int height = 0;
        temp.offer(point);
        temp.offer(null);
        while (true) {
            point = temp.poll();
            if (point == null) {
                height++;
                temp.offer(null);
                if (temp.peek() == null)
                    break;
                continue;
            }
            if (point.left != null)
                temp.offer(point.left);
            if (point.right != null)
                temp.offer(point.right);
        }
        return root == null ? 0 : height;
    }
    */
    public int height() {
       return root == null ? 0 : root.height();
    }
    public void preOrder() {
        BinaryTreeNode<E> point = root;
        BinaryTreeNode<E> last;
        while (point != null) {
            last = point.left;
            if (last != null) {
                while (last.right != null && last.right != point)
                    last = last.right;
                if (last.right == null) {
                    last.right = point;
                    System.out.print(point.data + " ");
                    point = point.left;
                    continue;
                }
                else
                    last.right = null;
            }
            else
                System.out.print(point.data + " ");
            point = point.right;
        }
    }
    public void inOrder() {
        BinaryTreeNode<E> point = root;
        BinaryTreeNode<E> last;
        while (point != null) {
            last = point.left;
            if (last != null) {
                while (last.right != null && last.right != point)
                    last = last.right;
                if (last.right == null) {
                    last.right = point;
                    point = point.left;
                    continue;
                }
                else
                    last.right = null;
            }
            System.out.print(point.data + " ");
            point = point.right;
        }
    }
    public void postOrder() {
        Stack<BinaryTreeNode<E>> temp = new SqStack<>();
        BinaryTreeNode<E> point = root, point1;
        boolean flag;
        do {
            while (point != null) {
                temp.push(point);
                point = point.left;
            }
            point1 = null;
            flag = true;
            while (!temp.empty() && flag) {
                point = temp.peek();
                if (point.right == point1) {
                    System.out.print(point.data + " ");
                    point1 = temp.pop();
                }
                else {
                    point = point.right;
                    flag = false;
                }
            }
        }while (!temp.empty());
    }
    public void leverOrder() {
        Queue<BinaryTreeNode<E>> temp = new LinkedQueue<>();
        BinaryTreeNode<E> point;
        if (root != null)
            temp.offer(root);
        while (!temp.isEmpty()) {
            point = temp.poll();
            System.out.print(point.data + " ");
            if (point.left != null)
                temp.offer(point.left);
            if (point.right != null)
                temp.offer(point.right);
        }
    }
   /**
    * 提供另外一个非递归的toString()方法
    * 默认使用的toString()方法
    * 相比递归能有10%的性能提升
    * 虽然时间复杂度是一致的
    *
    * 此处提供另一个toSting()方法
    * 空间复杂度只有默认toString()的 1/2
    * 请自行抉择
    public String toString() {
        String str = "";
        Stack<BinaryTreeNode<E>> temp = new SqStack<>();
        BinaryTreeNode<E> point = root;
        boolean flag = false;
        temp.push(root);
        while (!temp.empty()) {
            if (point == null)
                str += ")";
            else {
                if (flag) {
                    str += ",";
                    flag = false;
                }
                str += point.data;
                if (point.left != null || point.right != null) {
                    str += "(";
                    temp.push(null);
                    if (point.right != null)
                        temp.push(point.right);
                    if (point.left != null) {
                        point = point.left;
                        continue;
                    }
                }
                flag = true;
            }
            point = temp.pop();
        }
        return root == null ? "" : str;
    }
    */
    public String toString() {
        if (root == null)
            return "";
        else if (root.left == root.right)
            return "" + root.data;
        String str = "";
        Stack<BinaryTreeNode<E>> temp = new SqStack<>();
        Stack<Boolean> bool = new SqStack<>();
        BinaryTreeNode<E> point = root;
        bool.push(false);
        while(true) {
            if (point.left == point.right)
                str += point.data;
            else {
                temp.push(null);
                bool.push(false);
                str += point.data + "(";
                if (point.right != null) {
                    temp.push(point.right);
                    bool.push(true);
                }
                if (point.left != null) {
                    point = point.left;
                    continue;
                }
            }
            point = temp.pop();
            while (point == null || bool.peek()) {
                if (bool.pop()) {
                    str += ',';
                    break;
                }
                if (temp.empty())
                    return str + ")";
                str += ")";
                point = temp.pop();
            }
        }
    }
}
