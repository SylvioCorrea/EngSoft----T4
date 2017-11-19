import static org.junit.Assert.*;
import static org.junit.Assume.*;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.*;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;


@RunWith(JUnitQuickcheck.class)
public class EstudanteTeste {
	 
	Estudante estudante = new Estudante("Joao", "123");
	
	//OrderingComparison order = import 

	@Property(trials = 100)
	public void testSetP1P2G2(double nota) {
		boolean p1Set = estudante.setP1(nota);
		boolean p2Set = estudante.setP2(nota);
		boolean g2Set = estudante.setG2(nota);
		assertEquals(p1Set, 0.0 <= nota && nota <= 10.0);
		assertTrue(p1Set == p2Set && p1Set == g2Set);
	}

	@Property(trials = 100)
	public void testAddTrabalhoExercicio(double nota) {
		assertEquals(estudante.addTrabalho(nota), 0.0 <= nota && nota <= 10.0);
		assertEquals(estudante.addExercicio(nota), 0.0 <= nota && nota <= 10.0);
	}
	
	@Property(trials = 100)
	public void testMediaG1(double p1, double p2, double[] trabalhos, double[] exercicios) {
		estudante.setP1(p1);
		estudante.setP2(p2);
		
		for (double t : trabalhos) {
			estudante.addTrabalho(t);
		}
		for (double e : exercicios) {
			estudante.addExercicio(e);
		}
		double g1 = estudante.mediaG1();
		assertTrue(0 <= g1 && g1 <= 10);
	}
	
	@Property(trials = 100)
	public void testResultadoFaltas(@InRange(minInt = 0, maxInt = 15) int faltas) {
		estudante.setP1(10.0);
		estudante.setP2(10.0);
		estudante.addTrabalho(10.0);
		estudante.addExercicio(10.0);
		
		estudante.setFaltas(faltas);
		assertThat(estudante.resultado(), is(GrauFinal.APR));
	}
	
	@Property(trials = 100)
	public void testResultadoG1(double p1, double p2, double[] trabalhos,
							   double[] exercicios) {
		estudante.setP1(p1);
		estudante.setP2(p2);
		
		for (double t : trabalhos) {
			estudante.addTrabalho(t);
		}
		for (double e : exercicios) {
			estudante.addExercicio(e);
		}
		
		assumeThat(estudante.mediaG1(), lessThan(4.0));
		assertThat(estudante.resultado(), is(GrauFinal.REP));
	}
	
	@Property(trials = 100)
	public void testResultadoG2(@InRange(minDouble = 0.0, maxDouble = 10.0) double g2) {
		estudante.setP1(4.0);
		estudante.setP2(4.0);
		
		estudante.addTrabalho(4.0);
		estudante.addExercicio(4.0);
		
		estudante.setG2(g2);
		
		//assumeThat(estudante.mediaG1(), greaterThanOrEqualTo(4.0));
		assumeThat(estudante.mediaFinal(), greaterThanOrEqualTo(5.0));
		assertThat(estudante.resultado(), is(GrauFinal.APR));
	}
	
	

}
