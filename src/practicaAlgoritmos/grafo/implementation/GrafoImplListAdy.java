package practicaAlgoritmos.grafo.implementation;

import java.util.LinkedList;
import java.util.List;

import practicaAlgoritmos.grafo.infrastructure.Arista;
import practicaAlgoritmos.grafo.infrastructure.Grafo;
import practicaAlgoritmos.grafo.infrastructure.Vertice;

public class GrafoImplListAdy<T> implements Grafo<T> {
	
	List<Vertice<T>> vertices = new LinkedList<Vertice<T>>();

	@Override
	public void addVertex(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		if(!vertices.contains(vertice)) {
			vertices.add(vertice);
			vertice.setPosition(vertices.indexOf(vertice));
		}
	}

	@Override
	public void eliminateVertex(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		vertices.remove(vertice.getPosition());
		vertices.forEach((vert)-> vert.setPosition(vertices.indexOf(vert)));
		
	}

	@Override
	public void conect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		verticeOrigen.conect(verticeDestino);
		
	}

	@Override
	public void conectWithWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino, int peso) {
		// TODO Auto-generated method stub
		((VerticeImplListAdy<T>) verticeOrigen).conect(verticeDestino, peso);
	}

	@Override
	public void disconect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		verticeOrigen.disconect(verticeDestino);
		
	}

	@Override
	public boolean isAdjacent(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		return ((VerticeImplListAdy<T>) verticeOrigen).isAdjacent(verticeDestino);
	}

	@Override
	public List<Vertice<T>> listOfVertex() {
		// TODO Auto-generated method stub
		return vertices;
	}

	@Override
	public List<Arista<T>> listOfAdjacents(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		return vertice.getAdjacents();
	}

	@Override
	public Vertice<T> getVertex(int nroVertice) {
		// TODO Auto-generated method stub
		return vertices.get(nroVertice);
	}

	@Override
	public int getWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		return ((VerticeImplListAdy<T>)verticeOrigen).getWeight(verticeDestino);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return vertices.isEmpty();
	}

}
