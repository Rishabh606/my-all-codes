import java.util.HashMap;
import java.util.Set;

public class HEncoder {

	private class Node implements Comparable<Node> {
		Character data;
		int freq;
		Node lt;
		Node rt;

		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			// return arg0.freq-this.freq;
			return arg0.freq - this.freq;
		}
	}

	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	public HEncoder(String feeder) {
		HashMap<Character, Integer> fm = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char ch = feeder.charAt(i);
			if (fm.containsKey(ch)) {
				fm.put(ch, fm.get(ch) + 1);
			} else {
				fm.put(ch, 1);
			}
		}
		Heap<Node> hp = new Heap<>();
		Set<Character> st = fm.keySet();
		for (char ch : st) {
			Node nw = new Node();
			nw.data = ch;
			nw.freq = fm.get(ch);
			hp.addHP(nw);
		}

		while (hp.size() != 1) {
			Node nw = new Node();
			nw.data = '*';
			nw.lt = hp.removeHP();
			nw.rt = hp.removeHP();
			nw.freq = nw.lt.freq + nw.rt.freq;
			hp.addHP(nw);
		}
		Node BT = hp.removeHP();
		fillEncoderDecoder(BT, "");
	}

	private void fillEncoderDecoder(Node node, String osf) {
		if (node == null) {
			return;
		}
		if (node.lt == null && node.rt == null) {
			encoder.put(node.data, osf);
			decoder.put(osf, node.data);
		}

		fillEncoderDecoder(node.lt, osf + "0");
		fillEncoderDecoder(node.rt, osf + "1");
	}

	public String Encode(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			s += encoder.get(str.charAt(i));
		}
		return s;
	}

	public String decode(String str) {
		String s = "";
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			s = s + str.charAt(i);
			if (decoder.containsKey(s)) {
				res = res + decoder.get(s);
				s = "";
			}
		}
		return res;
	}
}
