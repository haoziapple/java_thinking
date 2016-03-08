/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.Groundhog2
 * @description:TODO
 * @date:2016-3-7 下午3:23:26
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
public class Groundhog2 extends Groundhog
{

	/**
	 * @param n
	 */
	public Groundhog2(int n)
	{
		super(n);
		// TODO Auto-generated constructor stub
	}
	public int hashCode() {return number;}
	public boolean equals(Object o)
	{
		return o instanceof Groundhog2 && (number == ((Groundhog2)o).number);
	}

}
