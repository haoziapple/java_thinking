/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.reusing.FinalArguments
 * @description:TODO
 * @date:2016-6-20 下午6:00:43
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-20     WangHao       v1.0.0        create
 *
 *
 */
package base.reusing;

/**
 * @className:base.reusing.FinalArguments
 * @description:将参数指明为final
 * @version:v1.0.0
 * @date:2016-6-20 下午6:00:49
 * @author:WangHao
 */
class Gizmo
{
	public void spin()
	{

	}
}

public class FinalArguments
{
	void with(final Gizmo g)
	{
		// ! g = new Gizmo(); //Illegal--g is final
	}

	void without(Gizmo g)
	{
		g = new Gizmo(); // OK--g not final
		g.spin();
	}

	// void f(final int i){i++;} //Can't change
	// You can only read from a final primitive:

	int g(final int i)
	{
		return i + 1;
	}

	public static void main(String[] args)
	{
		FinalArguments bf = new FinalArguments();
		bf.without(null);
		bf.with(null);
	}
}
