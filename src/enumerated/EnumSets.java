/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.EnumSets
 * @description:TODO
 * @date:2016-3-17 下午1:29:31
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-17     WangHao       v1.0.0        create
 *
 *
 */
package enumerated;

import java.util.EnumSet;
import static enumerated.AlarmPoints.*;
//Operations on EnumSets
public class EnumSets
{
	public static void main(String[] args)
	{
		//Empty set
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(BATHROOM);
		System.out.println(points);
		points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		System.out.println(points);
		points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		System.out.println(points);
		points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
	}

}
