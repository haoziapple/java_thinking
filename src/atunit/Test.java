/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:atunit.Test
 * @description:TODO
 * @date:2016-3-17 下午4:12:52
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
package atunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

//The @Test tag.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test
{
	
}
