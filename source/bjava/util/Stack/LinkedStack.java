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

import bjava.util.List.LinkedNode;

public class LinkedStack<E> implements Stack<E> {
    private LinkedNode<E> head;
    private int size;
    public LinkedStack() {
        head = new LinkedNode<E>();
        size = 0;
    }
    public boolean empty() {
        return head.next == null;
    }
    public int size() {
        return size;
    }
    public void push(E item) {
        LinkedNode<E> temp = new LinkedNode<>(item);
        temp.next = head.next;
        head.next = temp;
        size++;
    }
    public E remove() {
        if (empty())
            //return null;
            throw new IllegalArgumentException("操作错误:空栈");
        E temp = head.next.data;
        head.next = head.next.next;
        size--;
        return temp;
    }
    public E pop() {
        try {
            return remove();
        }
        catch (Exception IllegalArgumentException) {
            return null;
        }
    }
    public E element() {
        if (empty())
            //return null;
            throw new IllegalArgumentException("操作错误:空栈");
        return head.next.data;
    }
    public E peek() {
        try {
            return element();
        }
        catch (Exception IllegalArgumentException) {
            return null;
        }
    }
    public int search(E item) {
        int i = 1;
        LinkedNode<E> temp = head.next;
        while(temp != null && temp.data != item) {
            temp = temp.next;
            i++;
        }
        return temp == null ? -1 : i;
    }
    public boolean contains(E item) {
        LinkedNode<E> temp = head.next;
        while(temp != null && temp.data != item)
            temp = temp.next;
        return temp != null;
    }
}
