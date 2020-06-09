package triviamaze.token;

public class SkipQuestion extends Token{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SkipQuestion() {
		this.description = "A token to skip a question";
	}
	
	public String toString() {
		return this.description;
	}

}
