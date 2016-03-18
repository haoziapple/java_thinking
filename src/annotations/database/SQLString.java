/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.database.SQLString
 * @description:TODO
 * @date:2016-3-17 下午5:27:21
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
package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString
{
	int value() default 0;
	String name() default "";
	Constraints constraints() default @Constraints;
}
