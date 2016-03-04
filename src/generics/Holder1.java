/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:generics.Holder1
 * @description:TODO
 * @date:2016-2-17 下午2:21:13
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-17     WangHao       v1.0.0        create
 *
 *
 */
package generics;
class Automobile {}
public class Holder1
{
	private Automobile a;
	public Holder1(Automobile a) {this.a = a;}
	Automobile get() {return a;}
}
