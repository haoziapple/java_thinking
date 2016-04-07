/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.collection.Item
 * @description:TODO
 * @date:2016-4-7 下午3:34:14
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-7     WangHao       v1.0.0        create
 *
 *
 */
package corejava.collection;

import java.util.Objects;

/**
 * An item with a description and a part number.
 */
public class Item implements Comparable<Item>
{
	private String description;
	private int partNumber;

	public Item(String desc, int partNum)
	{
		description = desc;
		partNumber = partNum;
	}

	public String getDescription()
	{
		return description;
	}

	public String toString()
	{
		return "[description=" + description + ", partNumber=" + partNumber + "]";
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		Item other = (Item) otherObject;
		return Objects.equals(description, other.description) && partNumber == other.partNumber;
	}
	
	public int hashCode()
	{
		return Objects.hash(description, partNumber);
	}

	@Override
	public int compareTo(Item other)
	{
		return Integer.compare(partNumber, other.partNumber);
	}

}
