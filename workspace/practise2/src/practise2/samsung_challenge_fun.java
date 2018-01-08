package practise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class samsung_challenge_fun {

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner in = new FastScanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			Graph gp = new Graph();
			for (int i = 1; i <= n; i++) {
				gp.addVertex(Integer.toString(i));
			}
			for (int i = 1; i <= m; i++) {
				String v1name = Integer.toString(in.nextInt());
				String v2name = Integer.toString(in.nextInt());
				if (gp.containsEdge(v1name, v2name)) {
					gp.addEdge(v1name, v2name, gp.vces.get(v1name).nbrs.get(v2name) + 1);
				} else {
					gp.addEdge(v1name, v2name, 1);
				}
			}
			System.out.println(gp.pathnumber(gp));
		}
	}
}
	class Graph {
		public class Vertex {
			public HashMap<String, Integer> nbrs = new HashMap<>();
		}

		public HashMap<String, Vertex> vces = new HashMap<>();

		public int numVertices() {
			return vces.size();
		}

		public boolean containsVertex(String vname) {
			return vces.containsKey(vname);
		}

		public void addVertex(String name) {
			if (containsVertex(name)) {
				return;
			}
			Vertex vtx = new Vertex();
			vces.put(name, vtx);
		}
		public int pathnumber(Graph gp) {
			int count = 0;
			for (String key : gp.vces.keySet()) {
				if (!gp.isAcyclic(key)) {
					Set<String> nbkeys = gp.vces.get(key).nbrs.keySet();
					for (String nbkey : nbkeys) {
						if (!gp.isAcyclic(nbkey)) {
							count += gp.vces.get(key).nbrs.get(nbkey);
						}
					}
				}
			}
			return count;
		}
		public void removeVertex(String name) {
			if (!containsVertex(name)) {
				return;
			}
			Vertex vtx = vces.get(name);
			Set<String> vt = vtx.nbrs.keySet();
			for (String v : vt) {
				vces.get(v).nbrs.remove(name);
			}
			vces.remove(name);
		}

		public int numEdges() {
			int rv = 0;
			Set<String> vt = vces.keySet();
			for (String v : vt) {
				rv += vces.get(v).nbrs.size();
			}
			return rv / 2;
		}

		public boolean containsEdge(String v1name, String v2name) {
			Vertex v1 = vces.get(v1name);
			Vertex v2 = vces.get(v2name);
			if (v1 == null || v2 == null) {
				return false;
			}
			return v1.nbrs.containsKey(v2name);
		}

		public void addEdge(String v1name, String v2name, int weight) {
			if (!containsVertex(v1name) || !containsVertex(v2name)) {
				return;
			}
			Vertex v1 = vces.get(v1name);
			// Vertex v2 = vces.get(v2name);
			v1.nbrs.put(v2name, weight);
			// v2.nbrs.put(v1name, weight);
		}

		public void removeEdge(String v1name, String v2name) {
			if (!containsEdge(v1name, v2name)) {
				return;
			}
			Vertex v1 = vces.get(v1name);
			// Vertex v2 = vces.get(v2name);

			v1.nbrs.remove(v2name);
			// v2.nbrs.remove(v1name);
		}

		public void display() {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Set<String> vt = vces.keySet();
			for (String v : vt) {
				String str = "{" + v + "=> ";
				Set<String> vx = vces.get(v).nbrs.keySet();
				for (String nb : vx) {
					str += nb + ", ";
				}
				str += "END}";
				System.out.println(str);
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}

		public boolean isAcyclic(String v1name) {
			LinkedList<pair> queue = new LinkedList<pair>();
			HashMap<String, Boolean> processed = new HashMap<>();
			queue.addLast(new pair(v1name, v1name, vces.get(v1name)));
			while (!queue.isEmpty()) {
				pair pr = queue.removeFirst();

				if (!processed.containsKey(pr.vnm)) {
					processed.put(pr.vnm, true);

					for (String vr : pr.vtx.nbrs.keySet()) {
						if (!processed.containsKey(vr)) {
							queue.addLast(new pair(vr, pr.psf + vr, vces.get(vr)));
						}else{
							return false;
						}
					}
				} else {
					return false;
				}
			}
			return true;
		}

		private class pair {
			String vnm;
			String psf;
			Vertex vtx;
			boolean acyclic = false;

			pair(String vnm, String psf, Vertex vtx) {
				this.vnm = vnm;
				this.psf = psf;
				this.vtx = vtx;
			}
		}

	}

	class FastScanner {
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