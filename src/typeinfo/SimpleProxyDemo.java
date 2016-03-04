/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.SimpleProxeyDemo
 * @description:TODO
 * @date:2016-2-16 上午9:17:10
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-16     WangHao       v1.0.0        create
 *
 *
 */
package typeinfo;
interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {SweetShop.print("doSomething");}
	public void somethingElse(String arg) {
		SweetShop.print("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	
	public void doSomething() {
		SweetShop.print("SimpleProxy doSomething");
		proxied.doSomething();
	}
	
	public void somethingElse(String arg) {
		SweetShop.print("SmipleProxy somethingElse" + arg);
		proxied.somethingElse(arg);
	}
}
public class SimpleProxyDemo
{
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bobobo");
	}
	
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}

}
