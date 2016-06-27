/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.rmi.usezk.impl.IHelloService
 * @description:TODO
 * @date:2016-6-27 下午4:46:37
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-27     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.rmi.usezk.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @className:haozijava.rmi.usezk.impl.IHelloService
 * @description:定义一个RMI接口
 * @version:v1.0.0
 * @date:2016-6-27 下午4:46:50
 * @author:WangHao
 */
public interface IHelloService extends Remote
{
	String sayHello(String name) throws RemoteException;
}
