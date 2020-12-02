package src.practicaAlgoritmos.grafo.infrastructure;

public interface Arista<T> {
	public Vertice<T> getDestinationVertex();
	public int getWeight();
}
