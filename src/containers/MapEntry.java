/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.MapEntry
 * @description:TODO
 * @date:2016-3-7 下午4:15:52
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-7     WangHao       v1.0.0        create
 *
 *
 */
package containers;

import java.util.Map;

// A simple Map.Entry for sample Map implementations.
public class MapEntry<K, V> implements Map.Entry<K, V>
{
	private K key;
	private V value;
	public MapEntry(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getKey()
	 */
	@Override
	public K getKey()
	{
		return key;
	}

	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getValue()
	 */
	@Override
	public V getValue()
	{
		return value;
	}

	/* (non-Javadoc)
	 * @see java.util.Map.Entry#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V v)
	{
		V result = value;
		value = v;
		return result;//返回旧的值
	}
	public int hashCode()
	{
		return (key==null ? 0 : key.hashCode()) ^
				(value == null ? 0 : value.hashCode());
	}
	@SuppressWarnings("rawtypes")
	public boolean equals(Object o)
	{
		if(!(o instanceof MapEntry)) return false;
		MapEntry me = (MapEntry) o;
		return
				(key==null ? me.getKey() == null : key.equals(me.getKey())) &&
				(value==null ? me.getValue() == null : value.equals(me.getValue()));
	}
	public String toString()
	{
		return key + "=" + value;
	}
}
