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

public class SqStack<E> implements Stack<E> {
    private final int initcapacity = 10;
    private int capacity;
    private E[] data;
    private int top;
    public SqStack(){
        data = (E[])new Object[initcapacity];
        capacity = initcapacity;
        top = -1;
    }
    public int getCapacity() {
        return capacity;
    }
    public void updataCapacity(int newcapacity) { //public方法允许手动控制栈的容量，支援自动扩容不支援自动减容
        if (newcapacity < 10)
            throw new IllegalArgumentException("操作非法:不支援的容量");
        E[] newdata = (E[])new Object[newcapacity];
        for(int i=0; i<capacity && i<newcapacity; i++)
            newdata[i] = data[i];
        capacity = newcapacity;
        data = newdata;
        top = newcapacity < top+1 ? newcapacity-1 : top;
    }
    public boolean empty() {
        return top == -1;
    }
    public int size() {
        return top + 1;
    }
    public void push(E item) {
        if (top == capacity-1) //自动扩容
            updataCapacity(capacity << 1);
        data[++top] = item;
    }
    public E remove() { //支援使用updatacapacity()方法 手动 减容
        if (empty())
            //return null;
            throw new IllegalArgumentException("操作错误:空栈");
        return (E)data[top--];
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
        return (E)data[top];
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
        int temp = 1;
        for (int i=top; -1<i; i--, temp++)
            if (item == (E)data[i])
                return temp;
        return -1;
    }
    public boolean contains(E item) {
        for (int i=top; -1<top; top--)
            if (item == (E)data[i])
                return true;
        return false;
    }
}
