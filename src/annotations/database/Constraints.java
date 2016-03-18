/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.database.Constraints
 * @description:TODO
 * @date:2016-3-17 下午5:23:52
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
public @interface Constraints
{
	boolean primaryKey() default false;
	boolean allowNull() default true;
	boolean unique() default false;
}
