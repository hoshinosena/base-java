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

public interface Queue<E> {
    // 判断列队是否为空
    public boolean isEmpty();

    // 返回列队中元素个数
    public int size();

    // 将元素入队列尾
    // 操作成功将返回true，否则抛出异常
    public boolean add(E element);

    // 将元素入队列尾
    // 操作成功将返回true，否则返回false
    public boolean offer(E element);

    // 弹出队首元素并返回
    // 队列为空则抛出异常
    public E remove();

    // 弹出队首元素并返回
    // 队列为空则返回null
    public E poll();

    // 取得队首元素但不出队列
    // 队列为空则抛出异常
    public E element();

    // 取得队首元素但不出队列
    // 队列为空则返回null
    public E peek();
}
