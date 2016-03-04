/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.DatabaseException
 * @description:TODO
 * @date:2016-2-5 下午2:34:25
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-5     WangHao       v1.0.0        create
 *
 *
 */
package strings;
public class DatabaseException extends Exception
{

	
	 /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(int transactionID, int queryID, String message)
	{
		super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
	}

	public static void main(String[] args) {
		try {
			throw new DatabaseException(3, 7, "Write failed");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
