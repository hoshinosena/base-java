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

package bjava.util.Queue;

import bjava.util.List.LinkedNode;

public class LinkedQueue<E> implements Queue<E> {
    private int size;
    private LinkedNode<E> head, tail;
    public LinkedQueue() {
        size = 0;
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
    public boolean add(E element) {
        if (isEmpty())
            head = tail = new LinkedNode<>(element);
        else {
            tail.next = new LinkedNode<>(element);
            tail = tail.next;
        }
        size++;
        return true;
    }
    public boolean offer(E element) {
        return add(element);
    }
    public E remove() {
        E element;
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");
        element = (E)head.data;
        if (head == tail)
            head = tail = null;
        else
            head = head.next;
        size--;
        return element;
    }
    public E poll() {
        try {
            return remove();
        }
        catch (Exception IllegalArgumentException) {
            return null;
        }
    }
    public E element() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");
        return (E)head.data;
    }
    public E peek() {
        try {
            return element();
        }
        catch (Exception IllegalArgumentException) {
            return null;
        }
    }
}
