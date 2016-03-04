/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.toys.GenericToyTest
 * @description:TODO
 * @date:2016-2-14 下午5:38:32
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-14     WangHao       v1.0.0        create
 *
 *
 */
package typeinfo.toys;
public class GenericToyTest
{
	@SuppressWarnings("unused")
	public static void main(String[] argss) throws Exception {
		Class<FancyToy> ftClass = FancyToy.class;
		//Producess exact type:
		FancyToy fancyToy = ftClass.newInstance();
		//某个类， 它是FancyToy超类
		Class<? super FancyToy> up = ftClass.getSuperclass();
		//This won't compile
		//Class<Toy> up2 = ftClass.getSuperclass();
		//Only produces Object
		Object obj = up.newInstance();
	}
}
