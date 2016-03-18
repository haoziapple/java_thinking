/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.UseCase
 * @description:TODO
 * @date:2016-3-17 下午4:25:59
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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase
{
	public int id();

	public String description() default "no description";
}
