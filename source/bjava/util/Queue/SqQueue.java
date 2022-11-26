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

public class SqQueue<E> implements Queue<E> {
    private final int initcapacity = 100;
    private int capacity;
    private E[] data;
    private int head, tail;
    public SqQueue() {
        data = (E[])new Object[initcapacity];
        capacity = initcapacity + 1;
        head = tail = 0;
    }
    public SqQueue(int capacity) {
        data = (E[])new Object[++capacity];
        this.capacity = capacity;
        head = tail = 0;
    }
    public boolean isEmpty() {
        return head == tail;
    }
    public int size() {
        return (tail - head + capacity) % capacity;
    }
    public boolean add(E element) {
        if ((tail + 1) % capacity == head)
            throw new IllegalArgumentException("队列已满:容量为" + (capacity - 1));
        data[++tail%capacity] = element;
        return true;
    }
    public boolean offer(E element) {
        try {
            return add(element);
        }
        catch (Exception IllegalArgumentException) {
            return false;
        }
    }
    public E remove() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");
        return (E)data[++head%capacity];
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
        return (E)data[head+1];
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
