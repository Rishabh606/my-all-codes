
public class client_tries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(bruteforcePS("aabcbaaadcbcdbaabddc", "bcdb"));
		Tries t = new Tries();
		t.addWord("sea");
		t.addWord("see");
		t.addWord("seen");
		t.addWord("as");
		t.addWord("art");
		t.addWord("and");
		t.addWord("arc");
		t.addWord("be");
		t.addWord("bet");
		t.addWord("been");
		t.display();
		System.out.println(t.find("se"));
	}

	public static int bruteforcePS(String src, String pat) {
		for (int i = 0; i < src.length() - pat.length(); i++) {
			int j = 0;
			for (j = 0; j < pat.length(); j++) {
				if (src.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == pat.length()) {
				return i;
			}
		}
		return -1;
	}
}
