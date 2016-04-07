/**
 *
 *
 * @className:corejava.collection.SetTest
 * @description:TODO
 * @date:2016-4-7 下午2:55:12
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-7     WangHao       v1.0.0        create
 *
 *
 */
package corejava.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @className:corejava.collection.SetTest
 * @description:This program uses a set to print all unique words in System.in.
 * @version:v1.0.0
 * @date:2016-4-7 下午2:55:36
 * @author:WangHao
 */
public class SetTest
{
	public static void main(String[] args)
	{
		Set<String> words = new HashSet<String>(); // HashSet implements Set
		long totalTime = 0;

		Scanner in = new Scanner(System.in);
		while (in.hasNext())
		{
			String word = in.next();
			long callTime = System.currentTimeMillis();
			words.add(word);
			callTime = System.currentTimeMillis() - callTime;
			totalTime += callTime;
		}

		Iterator<String> iter = words.iterator();
		for (int i = 1; i < 20 && iter.hasNext(); i++)
			System.out.println(iter.next());
		System.out.println(". . .");
		System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
	}
}
