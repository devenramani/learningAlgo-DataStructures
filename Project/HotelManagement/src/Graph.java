public class Graph {
	public static class Node implements Comparable {
		private Comparable info;
		private Vector edges;

		public Node(Comparable label) {
			this.info = label;
			this.edges = new Vector(50);
		}

		public void addEdge(Edge e) {
			edges.addLast(e);
		}

		public int compareTo(Object o) {
			// two nodes are equal if they have the same label
			Node n = (Node) o;
			return n.info.compareTo(info);
		}

		public Comparable getLabel() {
			return info;
		}
		
		public Vector getEdges() {
			return this.edges;
		}

	}

	public static class Edge implements Comparable {
		private Node toNode;
		private double distance;

		public Edge(Node to, double distance) {
			this.toNode = to;
			this.setDistance(distance);
		}

		public int compareTo(Object o) {
			// two edges are equal if they point
			// to the same node.
			// this assumes that the edges are
			// starting from the same node !!!
			Edge n = (Edge) o;
			return n.toNode.compareTo(toNode);
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}
	}

	private Vector nodes;

	public Graph() {
		nodes = new Vector(50);
	}

	public void addNode(Node label) {
		nodes.addLast(label);
	}

	public Node findNode(Comparable nodeLabel) {
		Node res = null;
		for (int i = 0; i < nodes.size(); i++) {
			Node n = (Node) nodes.get(i);
			if (n.getLabel() == nodeLabel) {
				res = n;
				break;
			}
		}
		return res;
	}

	public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, double distance) {
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		n1.addEdge(new Edge(n2, distance));
	}

}