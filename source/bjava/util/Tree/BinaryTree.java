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

public interface BinaryTree<E> {
    // 删除树
    public void removeLeftTree();
    public void removeRightTree();
    public void removeAllTree();

    // 判断二叉树是否为空
    public boolean empty();

    // 查找二叉树元素
    // 存在则返回节点，否则抛出异常
    public BinaryTreeNode<E> search(E element);

    // 判断二叉树是否存在元素
    public boolean contains(E element);

    // 返回二叉树节点个数
    public int size();

    // 返回二叉树的深度
    // 当根节点非空从1计数，否则为0
    public int height();

    // 非递归遍历
    // *不* 保证线程安全
    public void preOrder();
    public void inOrder();

    // 非递归遍历
    public void postOrder();
    public void leverOrder();

    // 返回二叉树的括号表示串
    public String toString();
}
