package abr.exer.lez3110;

import java.util.Collection;

import abr.exer.IndexBook;

/** Questa interfaccia è stata scritta al fine di adattare la classe
 * {@link IndexBook} senza doverne modificare il contenuto.
 * E' possibile differenziare gli identificatori 'originali' da quelli
 * imposti dalla classe Unit Test fornita notando che questi ultimi sono
 * termini in lingua Italiana, mentre i primi sono in lingua Inglese. */
public interface IRubrica {

	public int numEl();
	public int aggiungi(String string);
	public Collection<String> cerca(String string);
	public int size();
	public boolean elimina(String string);

}
