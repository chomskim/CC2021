package straight.line.calcul;

public class TokenTester implements StraightLineParserConstants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Token t;

		// create token manager
		StraightLineParserTokenManager tm = 
				new StraightLineParserTokenManager(new SimpleCharStream(System.in));

		// display each token's image
		t = tm.getNextToken();
		while (t.kind != EOF)
		{
			System.out.println(tokenImage[t.kind] + " " + t.image);
			t = tm.getNextToken();
		}
	}
}


