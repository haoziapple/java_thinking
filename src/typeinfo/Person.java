/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.Person
 * @description:TODO
 * @date:2016-2-17 上午10:46:48
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-17     WangHao       v1.0.0        create
 *
 *
 */
package typeinfo;

import util.Null;

public class Person
{
	public final String first;
	public final String last;
	public final String address;
	//etc
	public Person(String first, String last, String address){
		this.first = first;
		this.last = last;
		this.address = address;
	}
	public String toString() {
		return "Person: " + first + " " + last + " " + address;
	}
	public static class NullPerson
	extends Person implements Null {
		private NullPerson() {super("None", "None", "None");}
		public String toString() {return "NullPerson";}
	}
	
	//空对象
	public static final Person NULL = new NullPerson();

}
