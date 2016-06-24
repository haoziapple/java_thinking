/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.rmi.myfirstrmi.IService
 * @description:TODO
 * @date:2016-6-24 下午3:12:40
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-24     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.rmi.myfirstrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @className:haozijava.rmi.myfirstrmi.IService
 * @description:IService接口
 * @version:v1.0.0
 * @date:2016-6-24 下午3:12:45
 * @author:WangHao
 */
public interface IService extends Remote
{
	// 声明服务器端必须提供的服务
	String service(String content) throws RemoteException;
}
