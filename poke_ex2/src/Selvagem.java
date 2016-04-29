public class Selvagem {
	private String nome;
	private String tipo;
	private int numero;
	private double hp;
	private double hpMax;
	private String fraqueza;
	protected Habilidades[] habilidade = new Habilidades[4]; 
	//////// private int i = 0;
	private boolean derrotado = false;
	
	public Selvagem (String nome, double hp){
		this.nome = nome;
		this.hp = hp;
		hpMax = hp;
	}
	
	public double getHpMax (){
		return hpMax;
	}
	
	public double getHp(){
		return hp;
	}
	
	public void setHpAtual (double hpNovo){
		hp = hpNovo;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void levaDano (double dano){
		if ((this.hp - dano) <= 0){
			this.hp = 0;
			derrotado = true;
		}
		else
			this.hp = this.hp - dano;
	}
	
	public boolean getEstado(){
		return derrotado;
	}
}

//class Charmander extends Selvagem {
//	public Charmander(){
//		super("Charmander", 200);
//		habilidade [0] = new Habilidades("bater", 100, "bate");
//		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
//		habilidade [2] = new Habilidades ("morder", 80, "morde");
//		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
//	}
//	
//}
//
//class Pikachu extends Selvagem {
//	public Pikachu(){
//		super("Pikachu", 200);
//		habilidade [0] = new Habilidades("bater", 100, "bate");
//		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
//		habilidade [2] = new Habilidades ("morder", 80, "morde");
//		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
//	}
//	
//}
//
//class Onix extends Selvagem {
//	public Onix(){
//		super("Onix", 200);
//		habilidade [0] = new Habilidades("bater", 100, "bate");
//		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
//		habilidade [2] = new Habilidades ("morder", 80, "morde");
//		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
//	}
//	
//}