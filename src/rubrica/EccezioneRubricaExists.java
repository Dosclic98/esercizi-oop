package rubrica;

public class EccezioneRubricaExists extends EccezioneRubrica{

	private static final long serialVersionUID = 1L;

	public EccezioneRubricaExists() {
		super("Elemento esiste già");
	}
}
