public class Pokemon {
	private String nome;
	private String tipo;
	private int numero;
	private double hp;
	private double hpMax;
	private String fraqueza;
	protected Habilidades[] habilidade = new Habilidades[4]; 
	//////// private int i = 0;
	private boolean derrotado = false;
	
	public Pokemon(String nome, String tipo, int numero, double hp, String fraqueza){
		this.nome = nome;
		this.tipo = tipo;
		this.numero = numero;
		hpMax = hp;
		this.hp = hp;
		this.fraqueza = fraqueza;
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
	
	public String getTipo(){
		return tipo;
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

class Mewtwo extends Pokemon {
	public Mewtwo(){
		super("Mewtwo", "psiquico", 150, 200, "psiquico");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Charmander extends Pokemon {
	public Charmander(){
		super("Charmander", "fogo", 150, 200, "agua");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Pikachu extends Pokemon {
	public Pikachu(){
		super("Pikachu", "raio", 150, 200, "lutador");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Zapdos extends Pokemon {
	public Zapdos(){
		super("Zapdos", "raio", 150, 150, "lutador");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 20, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Articuno extends Pokemon {
	public Articuno(){
		super("Articuno", "agua", 150, 200, "grama");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Moltres extends Pokemon {
	public Moltres(){
		super("Moltres", "fogo", 150, 200, "agua");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Mew extends Pokemon {
	public Mew(){
		super("Mew", "psiquico", 150, 200, "psiquico");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Onix extends Pokemon {
	public Onix(){
		super("Onix", "lutador", 150, 200, "agua");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Suicune extends Pokemon {
	public Suicune(){
		super("Suicune", "agua", 150, 300, "grama");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Entei extends Pokemon {
	public Entei(){
		super("Entei", "fogo", 150, 200, "agua");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Raykou extends Pokemon {
	public Raykou(){
		super("Raykou", "raio", 150, 200, "lutador");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}

class Blastoise extends Pokemon {
	public Blastoise(){
		super("Blastoise", "agua", 150, 200, "lutador");
		habilidade [0] = new Habilidades("bater", 100, "bate");
		habilidade [1] = new Habilidades ("arranhar", 90, "arranha");
		habilidade [2] = new Habilidades ("morder", 80, "morde");
		habilidade [3] = new Habilidades ("chutar", 70, "chuta");
	}
	
}