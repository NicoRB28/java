package src.practicaAlgoritmos.grafo.infrastructure;

import java.util.List;

public interface Vertice<T> {
	public T getValue();
	public int getPosition();
	public void setPosition(int pos);
	public void conect(Vertice<T> vertice);
	public void disconect(Vertice<T> vertice);
	public List<Arista<T>> getAdjacents();
}
