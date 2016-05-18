/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.VendingMachine
 * @description:TODO
 * @date:2016-3-17 下午3:09:00
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
package enumerated;

import java.util.EnumMap;
import static enumerated.Input.*;

//{Args: VendingMachineInput.txt}
enum Category
{
	MONEY(NICKEL, DIME, QUARTER, DOLLAR),
	ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
	QUIT_TRANSACTION(ABORT_TRANSACTION),
	SHUT_DOWN(STOP);
	
	private Input[] values;
	
	Category(Input... types)
	{
		values = types;
	}
	
	private static EnumMap<Input,Category> categories
	= new EnumMap<Input, Category>(Input.class);
	
	static
	{
		for(Category c: Category.class.getEnumConstants())
			for(Input type : c.values)
				categories.put(type, c);
	}
	
	public static Category categorize(Input input)
	{
		return categories.get(input);
	}
}
public class VendingMachine
{
	@SuppressWarnings("unused")
	private static State state = State.RESTING;
	private static int amount = 0;
	private static Input selection = null;
	enum StateDuration
	{
		TRANSIENT
	}//Tagging enum
	enum State
	{
		RESTING
		{
			void next(Input input)
			{
				switch(Category.categorize(input))
				{
				case MONEY:
					amount += input.amount();
					state = ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
				default:
				}
			}
		},
		ADDING_MONEY
		{
			void next(Input input)
			{
				switch(Category.categorize(input))
				{
				case MONEY:
					amount += input.amount();
					break;
				case ITEM_SELECTION:
					selection = input;
					if(amount < selection.amount())
						System.out.println("Insufficient money for " + selection);
					else state = DISPENSING;
					break;
				case QUIT_TRANSACTION:
					state = GIVING_CHANGE;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
					default:
				}
			}
		},
		DISPENSING(StateDuration.TRANSIENT)
		{
			void next()
			{
				System.out.println("here is your " + selection);
				amount -= selection.amount();
				state = GIVING_CHANGE;
			}
		},
		GIVING_CHANGE(StateDuration.TRANSIENT)
		{
			void next()
			{
				if(amount > 0)
				{
					System.out.println("Your change: " + amount);
					amount = 0;
				}
				state = RESTING;
			}
		},
		TERMINAL
		{
			void output()
			{
				System.out.println("Halted");
			}
		};
		
		@SuppressWarnings("unused")
		private boolean isTransient = false;
		State(){};
		State(StateDuration trans)
		{
			isTransient = true;
		}
		void next(Input input)
		{
			throw new RuntimeException("Only call " + 
					"next(Input input) for non-transient states");
		}
		void next()
		{
			throw new RuntimeException("Only call next() for " + 
					"StateDuration.TRANSIENT states");
		}
		void output()
		{
			System.out.println(amount);
		}
	}
	
	//TODO
}
