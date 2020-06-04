
public class TokenCreator {

	public static Token createToken(int n) {
		if(n == 4)
			return new AddAChanceToken();
		
		else if(n == 5)
			return new ExtraChanceToken();
		
		else if(n == 6)
			return new SkipQuestion();
		
		return null;
	}
}
