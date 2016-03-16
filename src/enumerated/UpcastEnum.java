/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.UpcastEnum
 * @description:TODO
 * @date:2016-3-14 上午10:53:48
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-14     WangHao       v1.0.0        create
 *
 *
 */
package enumerated;
enum Search{HITHER, YON}
public class UpcastEnum
{
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args)
	{
		Search[] vals = Search.values();
		Enum e =Search.HITHER; //Upcast;
		//e.values(); //No values() in Enum
		for(Enum en : e.getClass().getEnumConstants())
			System.out.println(en);
	}
}
