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
		this.hpMax = hp;
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
		habilidade [0] = new Habilidades("Psycho Cut", 100, "bate");
		habilidade [1] = new Habilidades ("Confusion", 90, "arranha");
		habilidade [2] = new Habilidades ("Hypnosis", 80, "morde");
		habilidade [3] = new Habilidades ("Magic Coat", 70, "chuta");
	}
	
}

class Charmander extends Pokemon {
	public Charmander(){
		super("Charmander", "fogo", 150, 200, "agua");
		habilidade [0] = new Habilidades("Fire Fang", 100, "bate");
		habilidade [1] = new Habilidades ("Ember", 90, "arranha");
		habilidade [2] = new Habilidades ("Fire Punch", 80, "morde");
		habilidade [3] = new Habilidades ("Flame Burst", 70, "chuta");
	}
	
}

class Pikachu extends Pokemon {
	public Pikachu(){
		super("Pikachu", "raio", 150, 200, "lutador");
		habilidade [0] = new Habilidades("Choque do Trovao", 100, "bate");
		habilidade [1] = new Habilidades ("Electro Ball", 90, "arranha");
		habilidade [2] = new Habilidades ("Thunder Punch", 80, "morde");
		habilidade [3] = new Habilidades ("Shock Wave", 70, "chuta");
	}
	
}

class Zapdos extends Pokemon {
	public Zapdos(){
		super("Zapdos", "raio", 150, 150, "lutador");
		habilidade [0] = new Habilidades("Electroweb", 100, "bate");
		habilidade [1] = new Habilidades ("Fusion Bolt", 20, "arranha");
		habilidade [2] = new Habilidades ("Discharge", 80, "morde");
		habilidade [3] = new Habilidades ("Charge", 70, "chuta");
	}
	
}

class Articuno extends Pokemon {
	public Articuno(){
		super("Articuno", "agua", 150, 200, "grama");
		habilidade [0] = new Habilidades("Bubble Beam", 100, "bate");
		habilidade [1] = new Habilidades ("Hydro Cannon", 90, "arranha");
		habilidade [2] = new Habilidades ("Razor Shell", 80, "morde");
		habilidade [3] = new Habilidades ("Soak", 70, "chuta");
	}
	
}

class Moltres extends Pokemon {
	public Moltres(){
		super("Moltres", "fogo", 150, 200, "agua");
		habilidade [0] = new Habilidades("Fire Blast", 100, "bate");
		habilidade [1] = new Habilidades ("Flamethrower", 90, "arranha");
		habilidade [2] = new Habilidades ("Fiery Dance", 80, "morde");
		habilidade [3] = new Habilidades ("Flame Burst", 70, "chuta");
	}
	
}

class Mew extends Pokemon {
	public Mew(){
		super("Mew", "psiquico", 150, 200, "psiquico");
		habilidade [0] = new Habilidades("Trick Room", 100, "bate");
		habilidade [1] = new Habilidades ("Reflect", 90, "arranha");
		habilidade [2] = new Habilidades ("Role Play", 80, "morde");
		habilidade [3] = new Habilidades ("Psycho Shift ", 70, "chuta");
	}
	
}

class Onix extends Pokemon {
	public Onix(){
		super("Onix", "lutador", 150, 200, "agua");
		habilidade [0] = new Habilidades("Dig", 100, "bate");
		habilidade [1] = new Habilidades ("Sandstorm", 90, "arranha");
		habilidade [2] = new Habilidades ("Rollout", 80, "morde");
		habilidade [3] = new Habilidades ("Stone Edge", 70, "chuta");
	}
	
}

class Suicune extends Pokemon {
	public Suicune(){
		super("Suicune", "agua", 150, 300, "grama");
		habilidade [0] = new Habilidades("Jato de agua", 100, "bate");
		habilidade [1] = new Habilidades ("Octazooka", 90, "arranha");
		habilidade [2] = new Habilidades ("Brine", 80, "morde");
		habilidade [3] = new Habilidades ("Waterfall", 70, "chuta");
	}
	
}

class Entei extends Pokemon {
	public Entei(){
		super("Entei", "fogo", 150, 200, "agua");
		habilidade [0] = new Habilidades("Blast Burn", 100, "bate");
		habilidade [1] = new Habilidades ("Eruption", 90, "arranha");
		habilidade [2] = new Habilidades ("Over Heat", 80, "morde");
		habilidade [3] = new Habilidades ("V- Create", 70, "chuta");
	}
	
}

class Raykou extends Pokemon {
	public Raykou(){
		super("Raykou", "raio", 150, 200, "lutador");
		habilidade [0] = new Habilidades("ThunderWave", 100, "bate");
		habilidade [1] = new Habilidades ("Thunder Fang", 90, "arranha");
		habilidade [2] = new Habilidades ("Volt Switch", 80, "morde");
		habilidade [3] = new Habilidades ("Wild Charge", 70, "chuta");
	}
	
}

class Blastoise extends Pokemon {
	public Blastoise(){
		super("Blastoise", "agua", 150, 200, "lutador");
		habilidade [0] = new Habilidades("Canhao de agua", 100, "bate");
		habilidade [1] = new Habilidades ("Whrilpool", 90, "arranha");
		habilidade [2] = new Habilidades ("Water Sport", 80, "morde");
		habilidade [3] = new Habilidades ("Aqua Ring", 70, "chuta");
	}
	
}
