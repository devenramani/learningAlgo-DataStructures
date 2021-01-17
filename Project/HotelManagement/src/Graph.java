public class Graph
{
    public class Node implements Comparable<Node>
    {
        private Comparable<Node> info;
        private Vector edges;
        
        public Node(Comparable<Node> label)
        {
            info = label;
            edges = new Vector(50);
        }
        
        public void addEdge(Edge e)
        {
            edges.addLast(e);
        }
        
        public int compareTo(Node o)
        {
            // two nodes are equal if they have the same label
            Node n = (Node)o;
            return n.info.compareTo((Graph.Node) info);
        }
        
        public Comparable<Node> getLabel()
        {
            return info;
        }
        
    }
    
    private class Edge implements Comparable<Edge>
    {
        private Node toNode;
        
        public Edge(Node to)
        {
            toNode = to;
        }
        
        public int compareTo(Edge o)
        {
            // two edges are equal if they point
            // to the same node.
            // this assumes that the edges are
            // starting from the same node !!!
            Edge n = (Edge)o;
            return n.toNode.compareTo(toNode);
        }
    }
    
    private Vector nodes;
    
    public Graph()
    {
        nodes = new Vector(50);
    }
    
    public void addNode(Comparable<Node> label)
    {
        nodes.addLast(new Node(label));
    }
    
    private Node findNode(Comparable<Node> nodeLabel)
    {
        Node res = null;
        for (int i=0; i<nodes.size(); i++)
        {
            Node n = (Node)nodes.get(i);
            if(n.getLabel() == nodeLabel)
            {
                res = n;
                break;
            }
        }
        return res;
    }
    
    public void addEdge(Comparable<Node> nodeLabel1,
                        Comparable<Node> nodeLabel2)
    {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge(n2));
    }
}