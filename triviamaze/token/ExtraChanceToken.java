package triviamaze.token;

public class ExtraChanceToken extends Token{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExtraChanceToken() {
		this.description = "A token for an extra chance";
	}
	
	public String toString() {
		return this.description;
	}

}
