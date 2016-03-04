/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.holding.AdapterMethodIdiom
 * @description:TODO
 * @date:2016-2-1 上午11:09:39
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-1     WangHao       v1.0.0        create
 *
 *
 */
package innerclasses.holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T>
{
	
	 /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ReversibleArrayList(Collection<T> c)
	{
		super(c);
	}

	public Iterable<T> reversed()
	{
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;
					public boolean hasNext() {return current > -1;}
					public T next() {return get(current--);}
					public void remove() {
						
					}
				};
			}
		};
	}
}

public class AdapterMethodIdiom
{

}
