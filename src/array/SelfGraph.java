package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SelfGraph<T> {

	private Map<T, List<T>> graph = new HashMap<>();

	public void addVertex(T t) {
		graph.put(t, new LinkedList<T>());
	}

	public void addEdge(T source, T destination, boolean bidirection) {
		if (!graph.containsKey(source))
			addVertex(source);

		if (!graph.containsKey(destination))
			addVertex(destination);
		graph.get(source).add(destination);
		if (bidirection) {
			graph.get(destination).add(source);
		}
	}

	public int getVertexCount() {
		return graph.keySet().size();
	}

	public int getEdgesCount(boolean bidirection) {
		int edges = 0;

		for (T t : graph.keySet()) {
			edges += graph.get(t).size();
		}

		if (bidirection) {
			edges = edges / 2;
		}

		return edges;
	}

	public boolean hasVertex(T t) {
		return (graph.get(t) != null);
	}

	public boolean hasEdge(T s, T d) {
		return graph.get(s).contains(d);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (T v : graph.keySet()) {
			builder.append(v.toString() + ": ");
			for (T w : graph.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}

		return (builder.toString());
	}

	public static void main(String args[]) {

		SelfGraph<Integer> g = new SelfGraph<Integer>();

		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);

		System.out.println("Graph:\n" + g.toString());

		System.out.println("Vertex count - " + g.getVertexCount());

		System.out.println("Edges count - " + g.getEdgesCount(true));

		System.out.println("check if edge present " + g.hasEdge(3, 4));

		System.out.println("Check if vertex present " + g.hasVertex(5));
	}
}
