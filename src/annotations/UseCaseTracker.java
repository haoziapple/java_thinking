/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.UseCaseTracker
 * @description:TODO
 * @date:2016-3-17 下午5:02:16
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-17     WangHao       v1.0.0        create
 *
 *
 */
package annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker
{
	public static void trackUseCases(List<Integer> useCases, Class<?> cl)
	{
		for(Method m : cl.getDeclaredMethods())
		{
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null)
			{
				System.out.println("Found Use Case: " + uc.id() + 
						" " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for(int i : useCases)
		{
			System.out.println("Warning : Missing use case-" + i);
		}
	}
	public static void main(String[] args)
	{
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47, 48, 49, 50);
		trackUseCases(useCases, PasswordUtils.class);
	}
}
