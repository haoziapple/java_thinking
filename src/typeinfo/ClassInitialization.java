/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.ClassInitialization
 * @description:TODO
 * @date:2016-2-14 下午4:36:10
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
package typeinfo;

import java.util.Random;

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = 
			ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initialization Initable");
	}
}
class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializating Initable2");
	}
}
class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializating Initable3");
	}
}
public class ClassInitialization
{
	public static Random rand = new Random(47);
	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		//Does not trigger initialization
		System.out.println(Initable.staticFinal);
		//Does trigger initialization
		System.out.println(Initable.staticFinal2);
		//Does trigger initialization
		System.out.println(Initable2.staticNonFinal);
		Class initable3 = Class.forName("typeinfo.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}

}
