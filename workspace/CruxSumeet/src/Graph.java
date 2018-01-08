import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	public class Vertex {
		private HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vces = new HashMap<>();

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
		Vertex v2 = vces.get(v2name);
		v1.nbrs.put(v2name, weight);
		v2.nbrs.put(v1name, weight);
	}

	public void removeEdge(String v1name, String v2name) {
		if (!containsEdge(v1name, v2name)) {
			return;
		}
		Vertex v1 = vces.get(v1name);
		Vertex v2 = vces.get(v2name);

		v1.nbrs.remove(v2name);
		v2.nbrs.remove(v1name);
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

	public boolean hasPath(String v1name, String v2name) {
		if (!containsVertex(v1name) || !containsVertex(v2name)) {
			return false;
		}
		HashMap<String, Boolean> hm = new HashMap<>();
		return hasPathDFS(v1name, v2name, hm);
	}

	private boolean hasPathDFS(String v1name, String v2name, HashMap<String, Boolean> hm) {
		boolean rv = false;
		if (hm.containsKey(v1name)) {
			return false;
		}
		if (vces.get(v1name).nbrs.containsKey(v2name)) {
			return true;
		} else {

			Set<String> vt = vces.get(v1name).nbrs.keySet();
			for (String v : vt) {
				hm.put(v1name, true);
				rv = hasPathDFS(v, v2name, hm);
				if (rv == true) {
					return rv;
				}
			}
		}
		return rv;
	}

	public void PrinthasPathDFS(String v1name, String v2name) {
		if (!containsVertex(v1name) || !containsVertex(v2name)) {
			return;
		}
		HashMap<String, Boolean> hm = new HashMap<>();
		// PrinthasPathDFS(v1name, v2name, hm, "");
		System.out.println(PrinthasPathDFSI(v1name, v2name));
	}

	private boolean PrinthasPathDFS(String v1name, String v2name, HashMap<String, Boolean> hm, String osf) {
		boolean rv = false;
		if (hm.containsKey(v1name)) {
			return false;
		}
		hm.put(v1name, true);
		if (vces.get(v1name).nbrs.containsKey(v2name)) {
			System.out.println(osf + v1name + "-" + v2name);
			return true;
		} else {
			Set<String> vt = vces.get(v1name).nbrs.keySet();
			for (String v : vt) {

				rv = PrinthasPathDFS(v, v2name, hm, osf + v1name + "-");
				if (rv == true) {
					return rv;
				}
			}
		}
		return rv;
	}

	public boolean PrinthasPath_shortest(String v1name, String v2name) {
		if (!containsVertex(v1name) || !containsVertex(v2name)) {
			return false;
		}
		return PrinthasPathBFS(v1name, v2name);
	}

	private boolean PrinthasPathBFS(String v1name, String v2name) {
		LinkedList<pair> queue = new LinkedList<pair>();
		HashMap<String, Boolean> processed = new HashMap<>();
		queue.addLast(new pair(v1name, v1name, vces.get(v1name)));
		while (!queue.isEmpty()) {
			pair pr = queue.removeFirst();

			if (!processed.containsKey(pr.vnm)) {
				processed.put(pr.vnm, true);

				if (pr.vnm.equals(v2name)) {
					System.out.println(pr.psf);
					return true;
				}
				for (String vr : pr.vtx.nbrs.keySet()) {
					if (!processed.containsKey(vr)) {
						queue.addLast(new pair(vr, pr.psf + vr, vces.get(vr)));
					}
				}
			}
		}
		return false;
	}

	private boolean PrinthasPathDFSI(String v1name, String v2name) {
		LinkedList<pair> stack = new LinkedList<pair>();
		HashMap<String, Boolean> processed = new HashMap<>();
		stack.addFirst(new pair(v1name, v1name, vces.get(v1name)));
		while (!stack.isEmpty()) {
			pair pr = stack.removeFirst();

			if (!processed.containsKey(pr.vnm)) {
				processed.put(pr.vnm, true);

				if (pr.vnm.equals(v2name)) {
					System.out.println(pr.psf);
					return true;
				}
				for (String vr : pr.vtx.nbrs.keySet()) {
					if (!processed.containsKey(vr)) {
						stack.addFirst(new pair(vr, pr.psf + vr, vces.get(vr)));
					}
				}
			}
		}
		return false;
	}

	public void PrinthasPath_BFST(String v1name) {
		if (!containsVertex(v1name)) {
			return;
		}
		PrinthasPathBFT(v1name);
	}

	private void PrinthasPathBFT(String v1name) {
		LinkedList<pair> queue = new LinkedList<pair>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String vtx : vces.keySet()) {
			if (processed.containsKey(vtx)) {
				continue;
			}
			queue.addLast(new pair(vtx, vtx, vces.get(vtx)));
			while (!queue.isEmpty()) {
				pair pr = queue.removeFirst();

				if (!processed.containsKey(pr.vnm)) {
					processed.put(pr.vnm, true);

					System.out.println(pr.psf);

					for (String vr : pr.vtx.nbrs.keySet()) {
						if (!processed.containsKey(vr)) {
							queue.addLast(new pair(vr, pr.psf + vr, vces.get(vr)));
						}
					}

				}
			}
		}
		return;
	}

	private void PrinthasPathDFT(String v1name) {
		LinkedList<pair> stack = new LinkedList<pair>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String vtx : vces.keySet()) {
			if (processed.containsKey(vtx)) {
				continue;
			}
			stack.addLast(new pair(vtx, vtx, vces.get(vtx)));
			while (!stack.isEmpty()) {
				pair pr = stack.removeFirst();

				if (!processed.containsKey(pr.vnm)) {
					processed.put(pr.vnm, true);

					System.out.println(pr.psf);

					for (String vr : pr.vtx.nbrs.keySet()) {
						if (!processed.containsKey(vr)) {
							stack.addFirst(new pair(vr, pr.psf + vr, vces.get(vr)));
						}
					}

				}
			}
		}
		return;
	}

	public boolean isconnect(String v1name) {
		return isconnected(v1name);
	}

	private boolean isconnected(String v1name) {
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
					}
				}
				// System.out.println(pr.psf);
			}
		}
		for (String vtx : vces.keySet()) {
			if (!processed.containsKey(vtx)) {
				return false;
			}
		}
		return true;
	}

	public boolean isAcyclic(String v1name) {
		LinkedList<pair> queue = new LinkedList<pair>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String vtx : vces.keySet()) {
			if (processed.containsKey(vtx)) {
				continue;
			}
			queue.addLast(new pair(vtx, vtx, vces.get(vtx)));
			while (!queue.isEmpty()) {
				pair pr = queue.removeFirst();

				if (!processed.containsKey(pr.vnm)) {
					processed.put(pr.vnm, true);

					for (String vr : pr.vtx.nbrs.keySet()) {
						if (!processed.containsKey(vr)) {
							queue.addLast(new pair(vr, pr.psf + vr, vces.get(vr)));
						}
					}
					System.out.println(pr.psf);
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isTree(String v1name) {
		return isconnected(v1name) && isAcyclic(v1name);
	}

	public boolean isbipartite() {
		LinkedList<pair2> queue = new LinkedList<pair2>();
		HashMap<String, String> processed = new HashMap<>();

		for (String vtx : vces.keySet()) {
			if (processed.containsKey(vtx)) {
				continue;
			}
			queue.addLast(new pair2(vtx, vtx, vces.get(vtx), "red"));
			while (!queue.isEmpty()) {
				pair2 pr = queue.removeFirst();

				if (!processed.containsKey(pr.vnm)) {
					processed.put(pr.vnm, pr.color);
					String clr = null;
					if (pr.color.equals("red")) {
						clr = "green";
					} else {
						clr = "red";
					}
					for (String vr : pr.vtx.nbrs.keySet()) {
						if (!processed.containsKey(vr)) {
							queue.addLast(new pair2(vr, pr.psf + vr, vces.get(vr), clr));
						} else {
							if (!processed.get(vr).equals(clr)) {
								return false;
							}
						}
					}
				} else {
					if (!processed.get(pr.vnm).equals(pr.color)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void getConnectedComponenets(String v1name) {
		LinkedList<pair> queue = new LinkedList<pair>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> res = new ArrayList<>();
		int counter = 0;
		res.set(0, "");
		for (String vtx : vces.keySet()) {
			if (processed.containsKey(vtx)) {
				continue;
			}
			queue.addLast(new pair(vtx, vtx, vces.get(vtx)));
			while (!queue.isEmpty()) {
				pair pr = queue.removeFirst();

				if (!processed.containsKey(pr.vnm)) {
					processed.put(pr.vnm, true);

					System.out.println(pr.psf);

					for (String vr : pr.vtx.nbrs.keySet()) {
						if (!processed.containsKey(vr)) {
							queue.addLast(new pair(vr, pr.psf + vr, vces.get(vr)));
						}
					}

				}
				res.set(counter, pr.psf);
			}
			counter++;
		}
		System.out.println(res);
		return;
	}

	private class pair {
		String vnm;
		String psf;
		Vertex vtx;

		pair(String vnm, String psf, Vertex vtx) {
			this.vnm = vnm;
			this.psf = psf;
			this.vtx = vtx;
		}
	}

	private class pair2 {
		String vnm;
		String psf;
		Vertex vtx;
		String color;

		pair2(String vnm, String psf, Vertex vtx, String color) {
			this.vnm = vnm;
			this.psf = psf;
			this.vtx = vtx;
			this.color = color;
		}
	}

	private class pair3 implements Comparable<pair3> {
		String vname;
		int csf;
		String psf;

		public pair3(String vname, int csf, String psf) {
			this.vname = vname;
			this.csf = csf;
			this.psf = psf;
		}

		@Override
		public int compareTo(pair3 o) {
			// TODO Auto-generated method stub
			return o.csf - this.csf;
		}

		public String toString() {
			return "["+this.vname+"-->"+this.csf+"-->"+this.psf+"]";
		}
	}

	public HashMap<String, pair3> dijkstraPair(String vname) {
		HashMap<String, pair3> hm = new HashMap<>();
		Heap<pair3> hp = new Heap<>();
		for (String key : vces.keySet()) {
			pair3 temp = new pair3(key, Integer.MAX_VALUE, key);

			if (key.equals(vname)) {
				temp.csf = 0;
				temp.psf = vname;
			}

			hp.addHP(temp);
			hm.put(key, temp);
		}
		while (!hp.isEmpty()) {
			pair3 pr = hp.removeHP();

			for (String nbr : vces.get(pr.vname).nbrs.keySet()) {
				pair3 next = hm.get(nbr);
				int one = this.vces.get(nbr).nbrs.get(pr.vname) + pr.csf;
				if (one < next.csf) {
					next.csf = one;
					next.psf = pr.psf + next.vname;
					hp.update(next);
				}
			}

		}
		return hm;
	}

}
