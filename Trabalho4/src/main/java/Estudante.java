// Código editado a partir do código gerado pelo Umple

import java.util.*;

// line 1 "Estudante.ump"
public class Estudante
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Estudante Attributes
  private final String nome;
  private final String matricula;
  private double p1;
  private double p2;
  private List<Double> trabalhos;
  private List<Double> exercicios;
  private double g2;
  private int faltas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Estudante(String aNome, String aMatricula)
  {
    nome = aNome;
    matricula = aMatricula;
    p1 = 0.0;
    p2 = 0.0;
    trabalhos = new ArrayList<Double>();
    exercicios = new ArrayList<Double>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  public boolean setP1(double aP1)
  {
    boolean wasSet = false;
    if (acceptableGrade(aP1)) {
    	p1 = aP1;
    	wasSet = true;
    }
    return wasSet;
  }

  public boolean setP2(double aP2)
  {
    boolean wasSet = false;
    if (acceptableGrade(aP2)) {
    	p2 = aP2;
    	wasSet = true;
    }
    return wasSet;
  }

  public boolean addTrabalho(Double aTrabalho)
  {
    boolean wasAdded = false;
    if (acceptableGrade(aTrabalho)) {
    	wasAdded = trabalhos.add(aTrabalho);
    }
    return wasAdded;
  }

  public boolean removeTrabalho(Double aTrabalho)
  {
    boolean wasRemoved = false;
    wasRemoved = trabalhos.remove(aTrabalho);
    return wasRemoved;
  }

  public boolean addExercicio(Double aExercicio)
  {
    boolean wasAdded = false;
    if (acceptableGrade(aExercicio)) { 
    	wasAdded = exercicios.add(aExercicio);
    }
    return wasAdded;
  }

  public boolean removeExercicio(Double aExercicio)
  {
    boolean wasRemoved = false;
    wasRemoved = exercicios.remove(aExercicio);
    return wasRemoved;
  }
  
  public boolean setG2(double aG2)
  {
    boolean wasSet = false;
    if (acceptableGrade(aG2)) {
    	g2 = aG2;
    	wasSet = true;
    }
    return wasSet;
  }
  
  public boolean setFaltas(int aFaltas)
  {
    boolean wasSet = false;
    if (0 <= aFaltas && aFaltas <= 60) {
    	faltas = aFaltas;
    	wasSet = true;
    }
    return wasSet;
  }

  public String getNome()
  {
    return nome;
  }

  public String getMatricula()
  {
    return matricula;
  }

  public double getP1()
  {
    return p1;
  }

  public double getP2()
  {
    return p2;
  }

  public Double getTrabalho(int index)
  {
    Double aTrabalho = trabalhos.get(index);
    return aTrabalho;
  }

  public Double[] getTrabalhos()
  {
    Double[] newTrabalhos = trabalhos.toArray(new Double[trabalhos.size()]);
    return newTrabalhos;
  }

  public int numberOfTrabalhos()
  {
    int number = trabalhos.size();
    return number;
  }

  public boolean hasTrabalhos()
  {
    boolean has = trabalhos.size() > 0;
    return has;
  }

  public int indexOfTrabalho(Double aTrabalho)
  {
    int index = trabalhos.indexOf(aTrabalho);
    return index;
  }

  public Double getExercicio(int index)
  {
    Double aExercicio = exercicios.get(index);
    return aExercicio;
  }

  public Double[] getExercicios()
  {
    Double[] newExercicios = exercicios.toArray(new Double[exercicios.size()]);
    return newExercicios;
  }

  public int numberOfExercicios()
  {
    int number = exercicios.size();
    return number;
  }

  public boolean hasExercicios()
  {
    boolean has = exercicios.size() > 0;
    return has;
  }

  public int indexOfExercicio(Double aExercicio)
  {
    int index = exercicios.indexOf(aExercicio);
    return index;
  }
  
  public double getG2()
  {
    return g2;
  }

  public int getFaltas()
  {
    return faltas;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Estudante compareTo = (Estudante)obj;
  
    if (matricula == null && compareTo.matricula != null)
    {
      return false;
    }
    else if (matricula != null && !matricula.equals(compareTo.matricula))
    {
      return false;
    }

    return true;
  }

  public void delete()
  {}

  // line 13 "Estudante.ump"
  public double mediaG1(){
	  double mediaTrabalhos = 0.0;
	  double mediaExercicios = 0.0;
	  
	  if (!trabalhos.isEmpty()) {
		  for (Double t : trabalhos) {
			  mediaTrabalhos += t;
		  }
		  mediaTrabalhos = mediaTrabalhos/trabalhos.size();
	  }
	  
	  if (!exercicios.isEmpty()) {
		  for (Double t : exercicios) {
			  mediaExercicios += t;
		  }
		  mediaExercicios = mediaExercicios/exercicios.size();
	  }
	  
	  return (p1 + p2 + mediaTrabalhos + mediaExercicios)/4.0;
  }
  
  public double mediaFinal() {
	  return (mediaG1() + g2)/2.0;
  }
  
  public GrauFinal resultado(){
	    if (faltas > 15 ||
	    	mediaG1() < 4.0 ||
	    	mediaFinal() < 5.0) {
	    	return GrauFinal.REP;
	    }
	    return GrauFinal.APR;
  }


  public String toString()
  {
    return super.toString() + "["+
            "matricula" + ":" + getMatricula()+ "," +
            "nome" + ":" + getNome()+ "," +
            "p1" + ":" + getP1()+ "," +
            "p2" + ":" + getP2()+ "]";
  }
  
  public boolean acceptableGrade(Double grade) {
	  return 0.0 <= grade && grade <= 10.0;
  }
}