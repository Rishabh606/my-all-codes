package important_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastScanner {
	BufferedReader reader;
	StringTokenizer st;

	FastScanner(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		st = null;
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				String line = reader.readLine();
				if (line == null) {
					return null;
				}
				st = new StringTokenizer(line);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		return st.nextToken();
	}

	String nextLine() {
		String s = null;
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	char nextChar() {
		return next().charAt(0);
	}

	int[] nextIntArray(int n) {
		int[] a = new int[n];
		int i = 0;
		while (i < n) {
			a[i++] = nextInt();
		}
		return a;
	}

	long[] nextLongArray(int n) {
		long[] a = new long[n];
		int i = 0;
		while (i < n) {
			a[i++] = nextLong();
		}
		return a;
	}

	int[] nextIntArrayOneBased(int n) {
		int[] a = new int[n + 1];
		int i = 1;
		while (i <= n) {
			a[i++] = nextInt();
		}
		return a;
	}

	long[] nextLongArrayOneBased(int n) {
		long[] a = new long[n + 1];
		int i = 1;
		while (i <= n) {
			a[i++] = nextLong();
		}
		return a;
	}

	void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
