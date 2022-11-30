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

package bjava.util.List;

/**
 * 给予操纵LinkedList对象的节点的能力
 * 除first外的所有节点实际上都可以操纵
 *
 * 除非你知道你在干什么
 * 否则操纵节点请尽可能都过LinkedList中的方法
 *
 * setHead方法提供了更改头节点的能力
 * setTail方法提供了更改尾节点的能力
 * add方法提供了插入节点的能力
 * remove提供了削除节点的能力
 * get和set方法提供了修改节点元素的能力
 *
 * 以上方法对于LinkedList数据结构是完备的
 * 以追求性能最优解为目标直接操纵链表
 * 可以考虑使用下面的point成员变量，透过
 * x.point = x.getHead()
 * 也可以透过
 * LinkedNode<E> point = x.getHead()
 * 获取额外point
 * 必要时亦可使point指向其他LinkedList对象节点
 * 从而实现联表
 *
 * 一旦使用point修改LinkedList内节点的逻辑关系
 * size变量需要立刻更新，否则链表方法将发生错误
 * 使用point批量移除内部节点
 * 或使用getTail()方法高性能连结链表时
 * 务必记得透过setSize()方法修改size
 * 以及透过point修改tail
 */
public class LinkedList<E> implements List<E>{
    protected final LinkedNode<E> first;
    protected LinkedNode<E> head;
    protected LinkedNode<E> tail;
    public LinkedNode<E> point; // 提供直接操纵节点
    protected int size;
    public LinkedList() {
        first = new LinkedNode<>();
        head = tail = first;
        size = 0;
    }
    public boolean isEmpty() {
        return head == first;
    }
    public int size(){
        return size;
    }
    public boolean setSize(int len) {
        if (len < 0)
            return false;
        size = len;
        return true;
    }
    public void CreateListF(E[] array) {
        LinkedNode<E> temp;
        temp = new LinkedNode<>(array[0]);
        temp.next = first.next;
        first.next = temp;
        tail = temp; //头插法只需定义一次尾指针，单独拎出写可以省下判断降低复杂度
        for(int i=1; i<array.length; i++) {
            temp = new LinkedNode<>(array[i]);
            temp.next = first.next;
            first.next = temp;
        }
        head = first.next;
        size = array.length;
    }
    public void CreateListR(E[] array) {
        LinkedNode<E> temp1, temp2;
        temp1 = first;
        for(int i=0; i<array.length; i++) {
            temp2 = new LinkedNode<>(array[i]);
            temp1.next = temp2;
            temp1 = temp2;
        }
        head = first.next;
        tail = temp1;
        size = array.length;
    }
    public LinkedNode<E> getHead() {
        if (head == first)
            return null;
        return head;
    }
    public boolean setHead(LinkedNode<E> head) {
        int size = 0;
        LinkedNode<E> temp = this.head;
        //for (; temp!=head && temp!=null; temp=temp.next)
        //    size++;
        //if (temp == null)
        //    return false;
        try {
            for (; temp!=head; temp=temp.next)
                size++;
        }
        catch (Exception NullPointerException) {
            return false;
        }
        first.next = head;
        this.head = head;
        this.size -= size;
        return true;
    }
    public LinkedNode<E> getTail() {
        if (head == first)
            return null;
        return tail;
    }
    public boolean setTail(LinkedNode<E> tail) {
        int size = 1;
        LinkedNode<E> temp = head;
        //for (; temp!=tail && temp!=null; temp=temp.next)
        //    size++;
        //if (temp == null)
        //    return false;
        try {
            for (; temp!=tail; temp=temp.next)
                size++;
        }
        catch (Exception NullPointerException) {
            return false;
        }
        tail.next = null;
        this.tail = tail;
        this.size = size;
        return true;
    }
    /**
     * 给予浅拷贝的表的连结
     * 可以平替point和getTail()连表获得更优性能
     * @param node
     */
    public void LinkList(LinkedNode<E> node) {
        tail.next = node;
        for (; tail.next != null; tail = tail.next)
            size++;
    }
    /**
     * 给予浅拷贝的表的连结
     * 可以平替point和getTail()连表获得更优性能
     * @param list
     */
    public void LinkList(LinkedList<E> list) {
        if (list.size == 0)
            return;
        tail.next = list.head;
        tail = list.tail;
        size += list.size;
    }
    private LinkedNode<E> node(int index) {
        LinkedNode<E> temp = first;
        for (int j=-1; j<index; j++)
            temp = temp.next;
        return temp;
    }
    public LinkedNode<E> getNode(int index) {
        if (index < 0 || size <= index)
            throw new IllegalArgumentException("位置非法");
        return node(index);
    }
    public LinkedNode<E> getNode(E element) {
        LinkedNode<E> temp = head;
        while (temp != null && temp.data != element)
            temp = temp.next;
        return temp;
    }
    public void add(E element) {
        LinkedNode<E> temp1 = new LinkedNode<>(element);
        tail.next = temp1;
        tail = temp1;
        head = first.next;
        size++;
    }
    public void add(int index, E element) {
        if (index < 0 || size < index)
            throw new IllegalArgumentException("位置非法");
        LinkedNode<E> temp1 = new LinkedNode<>(element);
        LinkedNode<E> temp2 = node(index-1);
        temp1.next = temp2.next;
        temp2.next = temp1;
        head = first.next;
        if (temp1.next == null)
            tail = temp1;
        size++;
    }
    public E remove(int index) {
        if (index < 0 || size <= index)
            throw new IllegalArgumentException("位置非法");
        LinkedNode<E> temp = node(index-1);
        E element = temp.data;
        temp.next = temp.next.next;
        head = first.next;
        if (head == null)
            head = first;
        if(temp.next == null)
            tail = temp;
        size--;
        return element;
    }
    /**
     * 快速修改链表长度
     * 性能优于使用remove()逐个删除
     */
    public void removeAfterElem(int len) {
        if(len < 0 || size < len)
            throw new IllegalArgumentException("长度非法");
        LinkedNode<E> temp = node(len-1);
        temp.next = null;
        head = first.next;
        if (head == null)
            head = first;
        tail = temp;
        size = len;
    }
    public E get(int index) {
        if (index < 0 || size <= index)
            throw new IllegalArgumentException("元素非法");
        LinkedNode<E> temp = node(index);
        return temp.data;
    }
    public E set(int index, E element) {
        if (index < 0 || size <= index)
            throw new IllegalArgumentException("元素非法");
        LinkedNode<E> temp = node(index);
        E oldVal = temp.data;
        temp.data = element;
        return oldVal;
    }
    public int indexOf(E element) {
        int i = 0;
        LinkedNode<E> temp = head;
        //while(temp != null && temp.data != element) {
        //   temp = temp.next;
        //    i++;
        //}
        //if(temp == null)
        //    return -1;
        try {
            while(temp.data != element) {
                temp = temp.next;
                i++;
            }
        }
        catch (Exception NullPointerException) {
            return -1;
        }
        return i;
    }
    /**
     * 返回LinkedList *深拷贝* 副本
     * 相比透过clone.add()，逐个复制将获得更优性能
     */
    public LinkedList<E> clone() {
        LinkedList<E> clone = new LinkedList<>();
        LinkedNode<E> temp = head, temp1 = clone.first;
        for (int i=0; i<size; i++) {
            temp1.next = new LinkedNode<>();
            temp1 = temp1.next;
            temp1.data = temp.data;
            temp = temp.next;
        }
        clone.head = temp == first ? clone.first : clone.first.next;
        clone.tail = temp == first ? clone.first : temp1;
        clone.size = size;
        return clone;
    }
    /**
     * 返回LinkedList *深拷贝* 数组
     * 相比透过get()，逐个复制将获得更优性能
     */
    public E[] toArray() {
        E[] array = (E[])new Object[size];
        int i = 0;
        for (LinkedNode<E> temp = head; i<size; temp = temp.next)
            array[i++] = temp.data;
        return array;
    }
    public boolean swap(int i, int j) {
        LinkedNode<E> temp1;
        LinkedNode<E> temp2;
        try {
            temp1 = node(i);
            temp2 = node(j);
        }
        catch (Exception IllegalArgumentException) {
            return false;
        }
        E temp = temp1.data;
        temp1.data = temp2.data;
        temp2.data = temp;
        return true;
    }
    public String toString() {
        String ans ="";
        LinkedNode<E> temp = head;
        //while(temp != null) {
        //    ans += temp.data + " ";
        //    temp = temp.next;
        //}
        try {
            while(true) {
                ans += temp.data + " ";
                temp = temp.next;
            }
        }
        catch (Exception NullPointerException) {

        };
        return ans;
    }
}
