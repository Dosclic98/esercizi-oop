package abr.exer.lez3110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import abr.exer.IndexBook;
import abr.exer.IndexBook.Number.Prefix;

public class Rubrica
		extends IndexBook
		implements IRubrica
{

	public static final int MAX_SIZE = 4;

	public Rubrica() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int numEl() {
		return this.size();
	}

	@Override
	public int aggiungi(String string) {
		String[] spl = string.split(" *= *");
		Number existing;

		if(spl.length != 2)
			throw new RuntimeException("invalid regex <- "+spl.length);

		printContent();

		existing = this.addNumber(
				spl[0],
				new Number(Prefix.ITALY, spl[1]));

		if(this.size() < MAX_SIZE)
			return (null == existing)? 1 : 0;
		return -1;
	}

	@Override
	public Collection<String> cerca(String string) {
		String[] found = this.find(string);
		ArrayList<String> matches = new ArrayList<>();

		for(String str : found)
			matches.add(str);

		return matches;
	}

	@Override
	public boolean elimina(String string) {
		boolean contained = false;
		String[] spl = string.split("\\s*=\\s*");

		String BEFORE = Arrays.toString(find(".*"));

		if(string.length() == 0) {
			this.clear();
		}
		else {
			spl[0] = "\\s*"+spl[0]+"\\s*";
			System.out.println(spl[0]+" ... "+this.find(string+".*").length);
			if(spl.length == 1) {
				for(String owner : this.find(spl[0]))
					this.removeNumber(owner);
			}
			else
			if(spl.length == 2) {
				for(String owner : this.find(string)) {
					if(this.getNumber(owner).digits.matches(spl[1]+".*"))
						this.removeNumber(owner);
				}
			}
		}

		printContent(BEFORE+" -> ","");

		return ! contained;
	}

	private void printContent() {
		printContent("","");
	}
	private void printContent(String before, String after) {
		System.out.println(before+"content is "+Arrays.toString(find(".*"))+after);
	}

}
