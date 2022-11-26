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
import bjava.util.Stack.LinkedStack;
import bjava.util.Stack.Stack;

public class BinaryTreeNode<E> {
    public E data;
    public BinaryTreeNode<E> left, right;
    public BinaryTreeNode(E element) {
        data = element;
        left = right = null;
    }
    public int num() { // 返回以该节点为根的树的节点数量
        Stack<BinaryTreeNode<E>> temp = new LinkedStack<>();
        BinaryTreeNode<E> point = left;
        boolean flag = false;
        int num = 0;
        if (left == right)
            return 1;
        while (point == left || flag) {
            while (!temp.empty() || point != null) {
                while (point != null) {
                    num++;
                    temp.push(point);
                    point = point.left;
                }
                if (!temp.empty())
                    point = temp.pop().right;
            }
            point = right;
            flag = !flag;
        }
        return ++num;
    }
    public int height() { // 返回以该节点为根的树的深度
        BinaryTreeNode<E> point = left;
        boolean flag = false;
        int height = 0, heightMax = 0;
        if (left == right)
            return 1;
        while (point == left || flag) {
            Queue<BinaryTreeNode<E>> temp = new LinkedQueue<>();
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
            heightMax = heightMax < height ? height : heightMax;
            height = 0;
            point = right;
            flag = !flag;
        }
        return ++heightMax;
    }
}
