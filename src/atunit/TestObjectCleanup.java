/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:atunit.TestObjectCleanup
 * @description:TODO
 * @date:2016-3-17 下午7:45:43
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
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//The @Unit @TestObjectCleanup tag
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestObjectCleanup
{

}
