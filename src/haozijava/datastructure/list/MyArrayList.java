/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.datastructure.list.MyArrayList
 * @description:TODO
 * @date:2016-4-29 下午4:00:47
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-29     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.datastructure.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @className:haozijava.datastructure.list.MyArrayList
 * @description:自实现的arrayList
 * @version:v1.0.0
 * @date:2016-4-29 下午4:00:51
 * @author:WangHao
 */
public class MyArrayList<E> implements List<E>
{

	// 默认的数组长度
	private final int DefSize = 16;

	// 记录实际的元素个数
	private int elementSize;

	// 临时变量数组
	private Object[] objects;

	public MyArrayList()
	{
		objects = new Object[DefSize];
	}

	@Override
	public boolean add(E e)
	{
		add(elementSize, e);
		return true;
	}

	/**
	 * 按位索引插入元素
	 */
	@Override
	public void add(int index, E element)
	{
		if (index == elementSize)
		{
			objects[index] = element;
			elementSize++;
			return;
		}

		for (int i = elementSize - 1; i >= 0; i--)
		{

			if (i == index)
			{

				int movedSize = elementSize - i - 1;

				System.arraycopy(objects, index + 1, objects, index, movedSize);
				objects[index] = element;
				elementSize++;
			}
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0)
	{
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1)
	{
		return false;
	}

	/**
	 * 清除所有元素
	 */
	@Override
	public void clear()
	{
		for (int i = 0; i < elementSize; i++)
		{
			objects[i] = 0;
		}
		elementSize = 0;
	}

	/**
	 * 判断集合是否包含了某个元素
	 */
	@Override
	public boolean contains(Object o)
	{
		for (Object object : objects)
		{
			if (object != null && object.equals(o))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0)
	{
		return false;
	}

	/**
	 * 获得某位置索引的元素
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index)
	{
		for (int i = 0; i < elementSize; i++)
		{
			if (i == index)
			{
				return (E) objects[index];
			}
		}
		return null;
	}

	/**
	 * 实现元素定位
	 */
	@Override
	public int indexOf(Object o)
	{
		for (int i = 0; i < elementSize; i++)
		{
			if (o.equals(objects[i]))
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * 是否是空集合
	 */
	@Override
	public boolean isEmpty()
	{
		if (elementSize == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator()
	{
		return null;
	}

	@Override
	public int lastIndexOf(Object o)
	{
		if (objects == null || objects.length == 0)
		{
			return -1;
		}

		for (int i = elementSize - 1; i >= 0; i--)
		{
			if (objects[i] == o)
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator()
	{
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0)
	{
		return null;
	}

	/**
	 * 删除某个元素
	 */
	@Override
	public boolean remove(Object o)
	{
		for (int i = 0; i < elementSize; i++)
		{

			if (o.equals(objects[i]))
			{
				objects[i] = null;

				int movedSize = elementSize - i - 1;
				System.arraycopy(objects, i + 1, objects, i, movedSize);
				elementSize--;
				return true;
			}

		}

		return false;
	}

	/**
	 * 删除某个索引下的元素
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index)
	{
		for (int i = 0; i < elementSize; i++)
		{

			if (objects[i].equals(objects[index]))
			{
				objects[i] = null;

				int movedSize = elementSize - i - 1;
				System.arraycopy(objects, i + 1, objects, i, movedSize);
				elementSize--;
				return (E) objects[index];
			}
		}
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0)
	{
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0)
	{
		return false;
	}

	/**
	 * 对已有位置设置新的元素值
	 */
	@Override
	public E set(int index, E element)
	{
		for (int i = 0; i < elementSize; i++)
		{
			if (i == index)
			{
				objects[index] = null;
				objects[index] = element;
				return element;
			}
		}
		return null;
	}

	@Override
	public int size()
	{
		return elementSize;
	}

	@Override
	public List<E> subList(int arg0, int arg1)
	{
		return null;
	}

	@Override
	public Object[] toArray()
	{
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0)
	{
		return null;
	}

	@Override
	public String toString()
	{

		StringBuffer str = new StringBuffer("[");

		for (int i = 0; i < elementSize; i++)
		{

			str.append("[" + objects[i].toString() + "],");

		}

		if (elementSize > 0)
		{
			return str.substring(0, str.lastIndexOf(",")) + "]";
		}

		return str.append("]").toString();
	}

	// 测试代码
	public static void main(String[] args)
	{
		MyArrayList<String> list = new MyArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list);
		list.remove("3");
		System.out.println(list);
		list.add("3");
		System.out.println(list);
		System.out.println(list.contains("2"));
		System.out.println(list.isEmpty());
		list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());
	}

}
