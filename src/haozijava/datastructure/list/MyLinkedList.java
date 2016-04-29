/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.datastructure.list.MyLinkedList
 * @description:TODO
 * @date:2016-4-29 下午4:14:01
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

public class MyLinkedList<E> implements List<E>
{
	/**
	 * 双向链表结构
	 */
	public class LinkNode
	{

		// 真正的数据域
		private E date;

		// 记录上一个节点
		private LinkNode prevLinkNode;

		// 记录下一个节点
		private LinkNode nextLinkNode;

		public LinkNode()
		{

		}

		public LinkNode(E date, LinkNode prevLinkNode, LinkNode nextLinkNode)
		{
			this.date = date;
			this.prevLinkNode = prevLinkNode;
			this.nextLinkNode = nextLinkNode;
		}
	}

	// 结点个数
	private int nodeSize;

	// 头结点
	private LinkNode headNode;

	// 尾巴节点
	private LinkNode tailNode;

	public MyLinkedList()
	{
		headNode = null;
		tailNode = null;
	}

	/**
	 * 采用尾端元素增加法，增加新元素
	 */
	@Override
	public boolean add(E element)
	{
		if (nodeSize == 0)
		{
			headNode = new LinkNode(element, null, tailNode);
		} else
		{

			if (tailNode == null)
			{
				tailNode = new LinkNode(element, headNode, null);
				headNode.nextLinkNode = tailNode;
				nodeSize++;
				return true;
			}

			LinkNode linkNode = tailNode;
			tailNode = new LinkNode(element, linkNode, null);
			linkNode.nextLinkNode = tailNode;

		}
		nodeSize++;
		return true;
	}

	/**
	 * 根据索引号查找节点
	 * 
	 * @param index
	 * @return
	 */
	public LinkNode findLinkNodeByIndex(int index)
	{

		LinkNode linkNodeNowTemp = headNode;

		for (int i = 0; i < nodeSize; i++)
		{

			if (i == index)
			{
				return linkNodeNowTemp;
			}

			linkNodeNowTemp = linkNodeNowTemp.nextLinkNode;
		}
		return null;
	}

	/**
	 * 按索引位置添加元素
	 */
	@Override
	public void add(int index, E element)
	{

		if (nodeSize == 0)
		{
			add(element);
		}

		// 按照元素先建立新的node
		LinkNode linkNodeNew = new LinkNode(element, null, null);

		// 找到索引处的节点
		LinkNode linkNodeNowTemp = findLinkNodeByIndex(index);

		// 找出索引处节点的上一个node
		LinkNode linkNodePrev = linkNodeNowTemp.prevLinkNode;

		// 上一个节点的下一个节点指向新node
		linkNodePrev.nextLinkNode = linkNodeNew;

		// 新节点的上一个节点指向原位置节点上一个节点
		linkNodeNew.prevLinkNode = linkNodePrev;

		// 新节点的下一个节点指向原位置节点
		linkNodeNew.nextLinkNode = linkNodeNowTemp;

		// 原节点的上一个节点指向新节点
		linkNodeNowTemp.prevLinkNode = linkNodeNew;

		nodeSize++;
	}

	/**
	 * 清除所有Node元素资源
	 */
	@Override
	public void clear()
	{

		LinkNode linkNodeNowTemp = headNode;

		for (int i = 0; i < nodeSize; i++)
		{

			if (linkNodeNowTemp != tailNode && linkNodeNowTemp != headNode)
			{
				linkNodeNowTemp = linkNodeNowTemp.nextLinkNode;
				linkNodeNowTemp.prevLinkNode.nextLinkNode = null;
				linkNodeNowTemp.prevLinkNode.prevLinkNode = null;
				linkNodeNowTemp.prevLinkNode.date = null;
				linkNodeNowTemp.prevLinkNode = null;
			} else if (linkNodeNowTemp == tailNode)
			{
				linkNodeNowTemp.prevLinkNode = null;
			} else if (linkNodeNowTemp == headNode)
			{
				linkNodeNowTemp.nextLinkNode = null;
			}

		}
		headNode = null;
		tailNode = null;
		nodeSize = 0;

	}

	/**
	 * 是否包含此元素
	 */
	@Override
	public boolean contains(Object object)
	{

		LinkNode linkNodeNowTemp = headNode;

		for (int i = 0; i < nodeSize; i++)
		{

			if (object == linkNodeNowTemp.date)
			{
				return true;
			}

			linkNodeNowTemp = linkNodeNowTemp.nextLinkNode;
		}

		return false;
	}

	@Override
	public E get(int index)
	{

		LinkNode linkNode = findLinkNodeByIndex(index);

		if (linkNode != null)
		{
			return linkNode.date;
		}

		return null;
	}

	@Override
	public boolean isEmpty()
	{
		return nodeSize == 0;
	}

	/**
	 * 删除元素
	 */
	@Override
	public boolean remove(Object o)
	{

		LinkNode linkNodeNowTemp = headNode;

		for (int i = 0; i < nodeSize; i++)
		{

			if (linkNodeNowTemp.date == o)
			{

				if (linkNodeNowTemp != tailNode && linkNodeNowTemp != headNode)
				{
					LinkNode linkNewPrev = linkNodeNowTemp.prevLinkNode;
					LinkNode linkNewNext = linkNodeNowTemp.nextLinkNode;
					linkNewPrev.nextLinkNode = linkNewNext;
					linkNewNext.prevLinkNode = linkNewPrev;

					linkNodeNowTemp.nextLinkNode = null;
					linkNodeNowTemp.prevLinkNode = null;
					linkNodeNowTemp.date = null;
					linkNodeNowTemp = null;
					nodeSize--;
					return true;
				} else if (linkNodeNowTemp == tailNode)
				{
					tailNode = linkNodeNowTemp.prevLinkNode;

					linkNodeNowTemp.prevLinkNode = null;
					linkNodeNowTemp.date = null;
					linkNodeNowTemp = null;
					nodeSize--;
					return true;
				} else if (linkNodeNowTemp == headNode)
				{
					headNode = linkNodeNowTemp.nextLinkNode;

					linkNodeNowTemp.nextLinkNode = null;
					linkNodeNowTemp.date = null;
					linkNodeNowTemp = null;
					nodeSize--;
					return true;
				}

			}

			linkNodeNowTemp = linkNodeNowTemp.nextLinkNode;
		}

		return false;
	}

	/**
	 * 删除位置标记下的元素
	 */
	@Override
	public E remove(int index)
	{

		LinkNode linkNodeNowTemp = headNode;

		for (int i = 0; i < nodeSize; i++)
		{

			if (index == i)
			{
				LinkNode linkNewPrev = linkNodeNowTemp.prevLinkNode;
				LinkNode linkNewNext = linkNodeNowTemp.nextLinkNode;
				linkNewPrev.nextLinkNode = linkNewNext;
				linkNewNext.prevLinkNode = linkNewPrev;

				linkNodeNowTemp.nextLinkNode = null;
				linkNodeNowTemp.prevLinkNode = null;
				linkNodeNowTemp.date = null;
				linkNodeNowTemp = null;
				break;
			}

			linkNodeNowTemp = linkNodeNowTemp.nextLinkNode;
		}

		return null;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return nodeSize;
	}

	@Override
	public String toString()
	{

		StringBuffer str = new StringBuffer("[");
		LinkNode linkNode = null;
		for (int i = 0; i < nodeSize; i++)
		{

			linkNode = findLinkNodeByIndex(i);

			str.append("[" + linkNode.date + "],");

		}

		if (nodeSize > 0)
		{
			return str.substring(0, str.lastIndexOf(",")) + "]";
		}

		return str.append("]").toString();
	}

	/* (non-Javadoc)
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.List#iterator()
	 */
	@Override
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	@Override
	public int lastIndexOf(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	@Override
	public ListIterator<E> listIterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	@Override
	public ListIterator<E> listIterator(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	@Override
	public E set(int index, E element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.List#subList(int, int)
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.List#toArray()
	 */
	@Override
	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.List#toArray(T[])
	 */
	@Override
	public <T> T[] toArray(T[] a)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
