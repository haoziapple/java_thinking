/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.ExtractInterface
 * @description:TODO
 * @date:2016-3-17 下午6:27:44
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

//APT-based annotation processing.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface
{
	public String value();
}
