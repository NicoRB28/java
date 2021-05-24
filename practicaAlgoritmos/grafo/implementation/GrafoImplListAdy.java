package practicaAlgoritmos.grafo.implementation;

import java.util.LinkedList;
import java.util.List;

import src.practicaAlgoritmos.grafo.infrastructure.Arista;
import src.practicaAlgoritmos.grafo.infrastructure.Grafo;
import src.practicaAlgoritmos.grafo.infrastructure.Vertice;

public class GrafoImplListAdy<T> implements Grafo<T> {
	
	List<Vertice<T>> vertices = new LinkedList<Vertice<T>>();

	@Override
	public void addVertex(Vertice<T> vertice) {
		if(!vertices.contains(vertice)) {
			vertices.add(vertice);
			vertice.setPosition(vertices.indexOf(vertice));
		}
	}

	@Override
	public void eliminateVertex(Vertice<T> vertice) {
		vertices.remove(vertice.getPosition());
		vertices.forEach((vert)-> vert.setPosition(vertices.indexOf(vert)));
		
	}

	@Override
	public void conect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		verticeOrigen.conect(verticeDestino);
		
	}

	@Override
	public void conectWithWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino, int peso) {
		((VerticeImplListAdy<T>) verticeOrigen).conect(verticeDestino, peso);
	}

	@Override
	public void disconect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		verticeOrigen.disconect(verticeDestino);
		
	}

	@Override
	public boolean isAdjacent(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		return ((VerticeImplListAdy<T>) verticeOrigen).isAdjacent(verticeDestino);
	}

	@Override
	public List<Vertice<T>> listOfVertex() {
		return vertices;
	}

	@Override
	public List<Arista<T>> listOfAdjacents(Vertice<T> vertice) {
		return vertice.getAdjacents();
	}

	@Override
	public Vertice<T> getVertex(int nroVertice) {
		return vertices.get(nroVertice);
	}

	@Override
	public int getWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		return ((VerticeImplListAdy<T>)verticeOrigen).getWeight(verticeDestino);
	}

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}

}
