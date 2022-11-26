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

public interface List<E> {
    // 判断链表是否为空
    public boolean isEmpty();

    // 返回链表节点个数
    public int size();

    // 返回链表节点对象
    public LinkedNode<E> getNode(int index);

    // 将节点添加至链表末尾
    public void add(E element);

    // 将节点添加至链表指定位置
    // index不存在则抛出异常
    public void add(int index, E element);

    // 将指定节点削除
    // 成功将返回削除节点元素
    // 否则抛出异常
    public E remove(int index);

    // 取得指定节点元素
    // 成功将返回元素
    // 否则抛出异常
    public E get(int index);

    // 修改指定节点元素
    // 成功将返回修改前的元素
    // 否则抛出异常
    public E set(int index, E element);

    // 获取指定元素的首个下标
    // 不存在则抛出异常
    public int indexOf(E element);
}
