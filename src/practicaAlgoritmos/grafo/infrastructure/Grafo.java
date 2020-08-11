package practicaAlgoritmos.grafo.infrastructure;

import java.util.List;

public interface Grafo<T> {
	
	public void addVertex(Vertice<T> vertice);
	public void eliminateVertex(Vertice<T> vertice);
	public void conect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino);
	public void conectWithWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino, int peso);
	public void disconect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino);
	public boolean isAdjacent(Vertice<T> verticeOrigen, Vertice<T> verticeDestino);
	public List<Vertice<T>> listOfVertex();
	public List<Arista<T>> listOfAdjacents(Vertice<T> vertice);
	public Vertice<T> getVertex(int nroVertice);
	public int getWeight(Vertice<T> vertice);
	public boolean isEmpty();
	
	
	

}
