package abr.exer;

import java.util.HashMap;
import java.util.HashSet;

public class IndexBook {

	 /** Oggetto 'inutile' usato per chiamare il metodo
	  * {@link HashSet#toArray(Object[])} */
	private final String[] STR_ARRAY = new String[0];
	private long idCounter = 0;
	final long id;
	final HashMap<String, IndexBook.Number> table;

	public IndexBook(IndexBook copy) {
		id = idCounter++;
		if(copy != null)
			table = new HashMap<>(copy.table);
		else
			table = new HashMap<>();
	}
	public IndexBook() {
		this(null);
	}

	public Number addNumber(String owner, IndexBook.Number num) {
		return table.put(owner, num);
	}
	public Number removeNumber(String owner) {
		return table.remove(owner);
	}
	public Number getNumber(String owner) {
		String found = findOne(owner);
		return (found == null)? null : table.get(found);
	}
	public Number[] getNumbers(String regex) {
		String[] found = find(regex);
		Number[] retn = new Number[found.length];

		for(int i = 0; i < found.length; i+=1)
			retn[i] = table.get(found[i]);

		return retn;
	}

	public void clear() { table.clear(); }

	public int size() { return table.size(); }

	public String findOne(String regex) {
		String[] got = find(regex);
		return (got.length > 0)? got[0] : null;
	}
	public String[] find(String regex) {
		HashSet<String> matches = new HashSet<>();
		for(String owner : table.keySet()) {
			if(owner.matches(regex))
				matches.add(owner);
		}
		//return matches.toArray(new String[matches.size()]);
		return matches.toArray(STR_ARRAY);
	}

	@Override
	public String toString() {
		return "[" + id + "] " + super.toString();
	}


	public final static class Number {
		//public final static int DIGITS = 9;
		public final Prefix prefix;
		public final String digits;

		public Number(CharSequence prefix, String digits) {
			this.prefix = Prefix.fromString(prefix);
			this.digits = digits;
		}

		public Number(Prefix prefix, String digits) {
			this.prefix = prefix;
			this.digits = digits;
		}

		public static enum Prefix {
			ITALY("39"),
			JAPAN("010");

			public CharSequence asDigitString;

			Prefix(CharSequence str) {
				asDigitString = str;
			}

			public static Prefix fromString(CharSequence n) {
				for(Prefix enumV : Prefix.values()) {
					if(enumV.asDigitString.equals(n))
						return enumV;
				}
				return null;
			}
		}
	}

}
