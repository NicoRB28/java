package practicaAlgoritmos.grafo.tests;

import practicaAlgoritmos.grafo.implementation.GrafoImplListAdy;
import practicaAlgoritmos.grafo.implementation.VerticeImplListAdy;
import practicaAlgoritmos.grafo.infrastructure.Arista;
import practicaAlgoritmos.grafo.infrastructure.Vertice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestGrafoImplListAdy {
	GrafoImplListAdy<Integer> grafo;
	
	@Before
	public void setUp() throws Exception{
		grafo = new GrafoImplListAdy<Integer>();
	}
	
	@Test
	public void testAgregarYEliminarVertice() {
		
		int tamAntes = grafo.listOfVertex().size();
		VerticeImplListAdy<Integer> vertice1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vertice2 = new VerticeImplListAdy<Integer>(2);
		VerticeImplListAdy<Integer> vertice3 = new VerticeImplListAdy<Integer>(3);
		grafo.addVertex(vertice1);
		grafo.addVertex(vertice2);
		grafo.addVertex(vertice3);
		grafo.conect(vertice1, vertice2);
		grafo.conect(vertice1, vertice3);
		grafo.conect(vertice2, vertice1);
		grafo.conect(vertice2, vertice3);
		grafo.conect(vertice3, vertice1);
		grafo.conect(vertice3, vertice2);
		int tamDesp = grafo.listOfVertex().size();
		assertTrue(tamDesp == tamAntes+3);
		grafo.eliminateVertex(vertice1);
		grafo.eliminateVertex(vertice2);
		grafo.eliminateVertex(vertice3);
		int tamFin = grafo.listOfVertex().size();
		assertTrue(tamAntes == tamFin);
	}
	
	@Test
	public void testConectarYDesconectar() {
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		grafo.addVertex(vert1);
		grafo.addVertex(vert2);
		grafo.conect(vert1, vert2);
		boolean ok = false;
		
		List<Arista<Integer>> listAdy = grafo.listOfAdjacents(vert1);
		for(Arista<Integer> a : listAdy) {
			if (a.getDestinationVertex() == vert2) {
				ok = true;
			}
		}
		assertTrue(ok);
		
		grafo.disconect(vert1, vert2);
		ok = false;
		listAdy = grafo.listOfAdjacents(vert1);
		
		for(Arista<Integer> a : listAdy) {
			if(a.getDestinationVertex() == vert2 ) {
				ok = true;
			}
		}
		
		assertFalse(ok);
	}
	
}
 