/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.SlowMap
 * @description:TODO
 * @date:2016-3-7 下午3:29:55
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

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// A Map implemented with ArrayLists.
public class SlowMap<K, V> extends AbstractMap<K, V>
{
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	public V put(K key, V value)
	{
		V oldValue = get(key); //The old value or null
		if(!keys.contains(key))
		{
			keys.add(key);
			values.add(value);
		}
		else
			values.set(keys.indexOf(key), value);
		return oldValue;
	}
	public V get(Object key)
	{
		if(!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractMap#entrySet()
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet()
	{
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while(ki.hasNext())
			set.add(new MapEntry<K, V>(ki.next(), vi.next()));
		return set;
	}

}
