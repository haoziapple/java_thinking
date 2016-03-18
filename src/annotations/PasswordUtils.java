/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.PasswordUtils
 * @description:TODO
 * @date:2016-3-17 下午4:33:15
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

import java.util.List;

public class PasswordUtils
{
	@UseCase(id = 47, description = "Passwords must contain at least one numeric")
	public boolean validatePassword(String password)
	{
		return (password.matches("\\w*\\d\\w*"));
	}
	
	@UseCase(id = 48)
	public String encrypyPassword(String password)
	{
		return new StringBuilder(password).reverse().toString();
	}
	@UseCase(id = 49, description = "New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password)
	{
		return !prevPasswords.contains(password);
	}
}
