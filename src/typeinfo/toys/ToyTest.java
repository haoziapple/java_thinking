/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.toys.ToyTest
 * @description:TODO
 * @date:2016-2-14 下午5:14:25
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
import typeinfo.*;
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy {
	//Comment out the following default constructor
	//to see NoSuchMethodError from (*1*)
	Toy() {}
	Toy(int i){}
}
class FancyToy extends Toy
implements HasBatteries, Waterproof, Shoots {
	FancyToy(){super(1);}
}
public class ToyTest
{
	@SuppressWarnings("rawtypes")
	static void printInfo(Class cc) {
		SweetShop.print("Class name: " + cc.getName() + " is interface? [" 
				+ cc.isInterface() + "]");
		SweetShop.print("Simple name: " + cc.getSimpleName());
		SweetShop.print("Canonical name: " + cc.getCanonicalName());
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("typeinfo.toys.FancyToy");
		} catch(ClassNotFoundException e) {
			SweetShop.print("Cant't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face : c.getInterfaces())
			printInfo(face);
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			//Requires default constructor
			obj = up.newInstance();
		} catch (InstantiationException e) {
			SweetShop.print("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			SweetShop.print("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}

}
