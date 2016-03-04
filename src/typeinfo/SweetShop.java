/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.SweetShop
 * @description:TODO
 * @date:2016-2-14 下午4:01:21
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
class Candy {
	static { SweetShop.print("Loading Candy");}
}
class Gum {
	static { SweetShop.print("Loading Gum");}
}
class Cookie {
	static { SweetShop.print("Loading Cookie");}
}
public class SweetShop
{
	public static void print(String s){
		System.out.println(s);
	}
	
	public static void main(String args[]) {
		print("inside main");
		new Candy();
		print("After creating Candy");
		try {
			Class.forName("typeinfo.Gum");
			print(Gum.class.toString());
		} catch (ClassNotFoundException e) {
			print("Coldn't find Gum");
		}
		print("After Class.forName(\"Gum\")");
		new Cookie();
		print("After creating Cookie");
	}
	

}
