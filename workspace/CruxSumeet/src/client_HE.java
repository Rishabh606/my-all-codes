
public class client_HE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HEncoder hf = new HEncoder("aaaaaaaaabbbbbcccdd");
		System.out.println(hf.Encode("aaabbbccd"));
		System.out.println(hf.decode("000101010111111110"));
	}

}
