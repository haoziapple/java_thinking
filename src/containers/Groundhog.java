/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.Groundhog
 * @description:TODO
 * @date:2016-3-7 下午2:37:30
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
// Looks plausible, but doesn't work as as HashMap key.
public class Groundhog
{
	protected int number;
	public Groundhog(int n) {number = n;}
	public String toString()
	{
		return "Groundhog #" + number;
	}
}
