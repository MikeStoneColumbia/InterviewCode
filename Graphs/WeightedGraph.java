import java.util.*;

public class WeightedGraph {
    private Map<Vertex, List<Edge>> adjVertices;

   public WeightedGraph() {
        this.adjVertices = new HashMap<Vertex, List<Edge>>();
    }

    public void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2, int weight) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(new Edge(label1,label2,weight));
        adjVertices.get(v2).add(new Edge(label2,label1,weight));
    }

    public void removeEdge(Edge e) {
        Vertex v1 = new Vertex(e.getSource());
        Vertex v2 = new Vertex(e.getDestination());
		Edge e1 = new Edge(e.getSource(),e.getDestination(),e.getWeight());
		Edge e2 = new Edge(e.getDestination(),e.getSource(),e.getWeight());
        List<Edge> eV1 = adjVertices.get(v1);
        List<Edge> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(e);
        if (eV2 != null)
            eV2.remove(e);
    }

	public void removeEdge(String label1, String label2, int weight){

		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		Edge e1 = new Edge(label1,label2,weight);
		Edge e2 = new Edge(label2,label1,weight);
		List<Edge> ev1 = adjVertices.get(v1);
		List<Edge> ev2 = adjVertices.get(v2);
		if(ev1 != null){
//			ev1.remove(e1);
			System.out.println(ev1.contains(e1));
			System.out.println(ev1.toString());
		}
		if(ev2 != null)
			ev2.remove(e2);

	}

    public List<Edge> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
    
	public int numOfVertices(){

		return adjVertices.size();
	
	}

	public boolean containsVertex(String label){

		return adjVertices.containsKey(new Vertex(label));

	}

	public String toString(){

		if(adjVertices.size() == 0)
			return "[]";

		StringBuilder string = new StringBuilder();
		string.append('[');
		for(Map.Entry<Vertex,List<Edge>> entry : adjVertices.entrySet())
			string.append(entry.getKey().toString() + ": " + entry.getValue().toString() + ", ");

		string.deleteCharAt(string.length()-1);
		string.deleteCharAt(string.length()-1);
		
		string.append(']');
		return string.toString();

	}

	public class Edge {

		String source;
		String destination;
		int weight;
		
		public Edge(String source, String destination, int weight){

			this.source = source;
			this.destination = destination;
			this.weight = weight;
		
		}

		@Override
		public int hashCode(){

			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((source == null) ? 0 : source.hashCode());
			result = prime * result + ((destination == null) ? 0 : destination.hashCode());
			return result;
		
		}

        private WeightedGraph getOuterType() {
            return WeightedGraph.this;
        }

		public String getSource(){

			return this.source;

		}
		public String getDestination(){

			return this.destination;
		
		}
		
		public int getWeight(){

			return this.weight;

		}

		@Override
		public String toString(){

			return source + " -> " + destination + ": " + weight;

		}

	}

	public class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

		public String getLabel(){

			return label;

		}
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private WeightedGraph getOuterType() {
            return WeightedGraph.this;
        }
    }
}
