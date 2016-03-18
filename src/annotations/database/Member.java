/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.database.Member
 * @description:TODO
 * @date:2016-3-17 下午5:41:59
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

@DBTable(name = "Member")
public class Member
{
	@SQLString(30)
	String firstName;
	
	@SQLString(50)
	String lastName;
	
	@SQLInteger
	Integer age;
	
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;
	
	static int memberCount;
	public String getHandle()
	{
		return handle;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String toString()
	{
		return handle;
	}
	public Integer getAge()
	{
		return age;
	}
}
