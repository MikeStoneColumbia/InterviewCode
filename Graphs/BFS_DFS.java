//import graph.Graph;
import java.util.*;

public class BFS_DFS extends Graph{

	private static Graph relationships;

	public static void main(String[] args){

  		relationships = new Graph();
		relationships.addVertex("Michael Stone");
		relationships.addVertex("Christina Torres");
		relationships.addVertex("Nicole");
		relationships.addVertex("Tony Stone");
		relationships.addVertex("Joseph Stone");
		relationships.addVertex("Elijah Stone");
		relationships.addVertex("David Stone");
		relationships.addVertex("coach");
		relationships.addEdge("Michael Stone","Elijah Stone");
		relationships.addEdge("Michael Stone", "Joseph Stone");
		relationships.addEdge("Tony Stone", "Christina Torres");
		relationships.addEdge("Christina Torres", "Nicole");
		relationships.addEdge("Michael Stone", "David Stone");
		relationships.addEdge("Michael Stone", "Tony Stone");
		relationships.addEdge("Michael Stone", "Christina Torres");

		System.out.println(depthFirst(relationships,"Michael Stone").toString());
		System.out.println(breadthFirst(relationships,"Michael Stone").toString());

	}

	public static Set<String> depthFirst(Graph graph, String root){

		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> vertices = new Stack<String>();

		vertices.push(root);
		while(!vertices.isEmpty()){

			String vertex = vertices.pop();
			if(!visited.contains(vertex)){

				visited.add(vertex);
				for(Vertex v : graph.getAdjVertices(vertex)){

					vertices.push(v.getLabel());

				}

			}


		}

			return visited;
	}

	public static Set<String> breadthFirst(Graph graph, String root){

		Set<String> visited = new LinkedHashSet<String>();
		Queue<String> vertices = new LinkedList<String>();

		vertices.add(root);
		visited.add(root);
		while(!vertices.isEmpty()){

			String vertex = vertices.poll();
			for(Vertex v : graph.getAdjVertices(vertex))
				if(!visited.contains(v.getLabel())){

					visited.add(v.getLabel());
					vertices.add(v.getLabel());

				}

		}

		return visited;

	}

}
