package ch.makery.coffee;

import java.util.ArrayList;
import java.util.Arrays;

public class Orders
{

	private ArrayList<Integer> m_currentOrder;
	private ArrayList<Integer> m_currentItems;
	private int m_orderNum;
	private boolean m_orderMade;

	// name of ingredients
	public static final Integer EMPTY_CUPS = 1;
	public static final Integer COFFEE = 2;
	public static final Integer ICE = 3;
	public static final Integer MILK = 4;
	public static final Integer ESPRESSO = 5;
	public static final Integer HAZEINUT = 6;
	public static final Integer CARAMEL = 7;

	// menus
	public static final Integer[] COFFEE_WITH_CREAM = { EMPTY_CUPS , COFFEE, MILK };
	public static final Integer[] CARAMEL_AMERICANO = { EMPTY_CUPS , ESPRESSO, CARAMEL };
	public static final Integer[] HAZELNUT_LATTE = { EMPTY_CUPS , ESPRESSO, MILK, HAZEINUT };
	public static final Integer[] CARAMEL_MOCCHIATO = { EMPTY_CUPS , ESPRESSO, CARAMEL };

	public Orders()
	{
		// first order is coffee with cream
		m_orderNum = 4;
		setM_orderMade(false);
		m_currentOrder = new ArrayList<Integer>( Arrays.asList(COFFEE_WITH_CREAM) );
		m_currentItems = new ArrayList<Integer>();
	}

	public String newOrder()
	{
		// return a random number between 1 and 4
		m_orderNum = (int)(Math.random() * 4) + 1;
		if( m_orderNum == 1 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( COFFEE_WITH_CREAM ) );
			return "New order is coffee with cream.";
		}
		else if ( m_orderNum == 2 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( CARAMEL_AMERICANO ) );
			return "New order is carmel americano.";
		}
		else if ( m_orderNum == 3 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( HAZELNUT_LATTE ) );
			return "New order is hazelnut latte.";
		}
		else if ( m_orderNum == 4 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( CARAMEL_MOCCHIATO ) );
			return "New order is caramel mecciato.";
		}
		return "ERROR";
	}

	public String submit()
	{
		if( !m_currentItems.containsAll(m_currentOrder ))
		{
			return "Order does not match, please check the current order and order items.";
		}
		m_currentItems.clear();
		setM_orderMade(true);
		return "Order is made.";
	}

	public String addItem( Integer ingredient )
	{
		if( m_currentItems.isEmpty() == true && ingredient != EMPTY_CUPS )
		{
			return "Please grab an empty cup first";
		}
		else if( m_currentItems.contains(ingredient) == true )
		{
			// second time click the same item will remove it.
			m_currentItems.remove(ingredient);
			return getIngredientName( ingredient) + " is removed.";
		}

		m_currentItems.add( ingredient );
		return "successfully added: " + getIngredientName( ingredient);
	}

	private String getIngredientName( Integer ingredient )
	{
		if( ingredient == EMPTY_CUPS )
		{
			return "empty cup";
		}
		else if( ingredient == COFFEE )
		{
			return "coffee";
		}
		else if( ingredient == ICE )
		{
			return "ice";
		}
		else if( ingredient == MILK )
		{
			return "milk";
		}
		else if( ingredient == ESPRESSO )
		{
			return "espresso";
		}
		else if( ingredient == HAZEINUT )
		{
			return "hazei nut";
		}
		else if( ingredient == CARAMEL )
		{
			return "caramel";
		}
		return "UNKNOW INGRIDIENT!!!!!!!!!";
	}

	private String getOrderName()
	{
		if( m_orderNum == 1 )
		{
			return "coffee with cream";
		}
		else if( m_orderNum == 2 )
		{
			return "caramel americano";
		}
		else if( m_orderNum == 3 )
		{
			return "hazelnut latte";
		}
		else if( m_orderNum == 4 )
		{
			return "caramel mocchiato";
		}
		return "Unknown Order";
	}

	public String printCurrentOrder()
	{
		return getOrderName();
	}

	public String printCurrentItems()
	{
		String ret = "Current items are: ";
		for ( Integer item: m_currentItems ) {
			ret += getIngredientName( item );
			ret += " ";
		}
		ret += ".";
		return ret;
	}

	public void clearCurrentItemsItems()
	{
		m_currentItems.clear();
	}

	public boolean isM_orderMade() {
		return m_orderMade;
	}

	public void setM_orderMade(boolean m_orderMade) {
		this.m_orderMade = m_orderMade;
	}


}
