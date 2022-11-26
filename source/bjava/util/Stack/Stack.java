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

package bjava.util.Stack;

public interface Stack<E> {
    // 判断栈是否为空
    public boolean empty();

    // 返回栈中元素个数
    public int size();

    // 元素入栈
    public void push (E item);

    // 弹出栈顶元素并返回
    // 栈空则抛出异常
    public E remove();

    // 弹出栈顶元素并返回
    // 栈空则返回null
    public E pop();

    // 取得栈顶元素但不弹出
    // 栈空则抛出异常
    public E element();

    // 取得栈顶元素但不弹出
    // 栈空则返回null
    public E peek();

    // 查找栈中元素
    // 存在则返回伪指针，否则返回-1
    public int search(E item);

    // 判断栈中是否存在元素
    public boolean contains(E item);
}
