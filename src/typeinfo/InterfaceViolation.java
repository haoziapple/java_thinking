/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.InterfaceViolation
 * @description:TODO
 * @date:2016-2-17 下午2:00:32
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
package typeinfo;

import typeinfo.interfacea.A;

class B implements A {
	public void f() {};
	public void g() {};
}
public class InterfaceViolation
{
	public static void main(String[] args)
	{
		A a = new B();
		a.f();
		//a.g(); //Compile error
		SweetShop.print(a.getClass().getName());
		if(a instanceof B) {
			B b = (B)a;
			b.g();
			SweetShop.print("b.g()");
		}
	}

}
