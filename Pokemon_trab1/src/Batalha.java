
public class Batalha extends Controller {
	private  Pokemon Blastoise = new Blastoise();
	private  Pokemon Charmander = new Charmander();
	private  Pokemon Zapdos = new Zapdos();
	private  Pokemon Moltres = new Moltres();
	private  Pokemon Articuno = new Articuno();
	private  Pokemon Mewtwo = new Mewtwo();
	private  Pokemon Mew = new Mew();
	private  Pokemon Pikachu = new Pikachu();
	private  Pokemon Entei = new Entei();
	private  Pokemon Suicune = new Suicune();
	private  Pokemon Raykou = new Raykou();
	private  Pokemon Onix = new Onix();
	Pokemon pokemons1[] = {Blastoise, Charmander, Zapdos, Moltres, Articuno, Mewtwo};
	Pokemon pokemons2 [] = {Pikachu, Mew, Suicune, Entei, Raykou, Onix};
	private  Treinador treinador1 = new Treinador("treinador1", 1, pokemons1);
	private Treinador treinador2 = new Treinador("treinador2", 2, pokemons2);

	private class Correr extends Event {
		Treinador treinador;
		public Correr (long eventTime, Treinador treinador){
			super (eventTime, 4);
			this.treinador = treinador;
		}
		
		public void action() {
			//acaba a batalha, portanto encerra a simulacao
			treinador.Correu();
			treinador.Perdeu();
			return;
		}
		
		public String description () { 
			//print na main falando qual treinador fugiu da batalha
			System.out.println(treinador.getTreinador() + " fugiu da batalha!!");
			System.exit(0);
			return treinador.getTreinador() + " fugiu da batalha!!";
		}
	}
	
	private class Troca extends Event {
		Treinador treinador;
		public Troca (long eventTime, Treinador treinador){ //pokemao deve ser um num entre 0 e 5
			super(eventTime, 3);
			this.treinador = treinador;
		}
		
		public void action () {
			treinador.pokemaoAtivo();
		}
		
		public String description (){
			return "Pokemon atual foi substituido por " + treinador.getAtivo().getNome()+ " " + treinador.getAtivo().getHp() + "/" + treinador.getAtivo().getHpMax() + "\n";
		}
	}
	
	private class Cura extends Event {
		Treinador treinador;
		public Cura (long eventTime, Treinador treinador){
			super (eventTime, 2);
			this.treinador = treinador;
		}
		
		public void action () {
			if (treinador.getAtivo().getHp() + 50 <= treinador.getAtivo().getHpMax())
				treinador.getAtivo().setHpAtual(treinador.getAtivo().getHp() + 50);
			if (treinador.getAtivo().getHp() + 50 > treinador.getAtivo().getHpMax())
				treinador.getAtivo().setHpAtual(treinador.getAtivo().getHpMax());
			if (treinador.getAtivo().getHp() == 0)
				System.out.println("nao eh possivel recuperar a vida de um pokemon fora de combate :'((" );
		}
		public String description (){
			return "hp de " + treinador.getAtivo().getNome() + " foi recuperado!!\n";
		}
	}
	
	private class Ataca extends Event {
		Treinador treinador1;
		Treinador treinador2;
		int i;
		boolean atacou = false;
		public Ataca (long eventTime, Treinador treinador1, Treinador treinador2, int ataque){
			super (eventTime, 1);
			this.treinador1 = treinador1;
			this.treinador2 = treinador2;
			i = ataque;
		}
		
		public void action () {
			double dano = treinador1.getAtivo().habilidade[i].getDano();
			if (treinador1.getAtivo().getHp() > 0){
				dano = treinador2.getAtivo().levaDano(treinador1.getAtivo().getTipo(), dano, treinador2.getAtivo().getTipo()); 
				atacou = true;
				System.out.println(treinador1.getAtivo().getNome() + " usou " + treinador1.getAtivo().habilidade[i].getHabilidade() + ", causando " + dano + " de dano");  
				System.out.println("");
				System.out.println(treinador1.getAtivo().getNome() + " " + treinador1.getAtivo().getHp() + "/" + treinador1.getAtivo().getHpMax());
				System.out.println("");
				System.out.println(treinador2.getAtivo().getNome() + " " + treinador2.getAtivo().getHp() + "/" + treinador2.getAtivo().getHpMax());
				System.out.println("");
			}
			
			if(treinador2.getAtivo().getEstado() == true && treinador2.Perdeu() == false){
				System.out.println("Pokemon " + treinador2.getAtivo().getNome() + " estah fora de combate!!\n");
				treinador2.pokemaoAtivo();
				System.out.println("Pokemon atual do " + treinador2.getNome() + " foi substituido por " + treinador2.getAtivo().getNome() + " " + treinador2.getAtivo().getHp() + "/" + treinador2.getAtivo().getHpMax());

			}	
		}
		
		public String description (){
			return "";
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Batalha batalha = new Batalha();
		int opcao = 0;
		int opcaoT1[] = {1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} , opcaoT2[] = {1,2,2,2,1,2,2,2,1,2,2,1,1,1,1,1,2,2,2,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1};
		int i = 0;
		
		batalha.treinador1.pokemaoAtivo();
		batalha.treinador2.pokemaoAtivo();
		
		while (batalha.treinador1.perdeu == false && batalha.treinador2.perdeu == false){
			if(opcaoT1[i] >= opcaoT2[i]){
				if(opcaoT1[i] == 1) batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.treinador1, batalha.treinador2, 0));
				else if(opcaoT1[i] == 2) batalha.addEvent(batalha.new Cura(System.currentTimeMillis() +1000, batalha.treinador1));
				else if(opcaoT1[i] == 3) batalha.addEvent(batalha.new Troca(System.currentTimeMillis() +1000, batalha.treinador1));
				else if(opcaoT1[i] == 4) batalha.addEvent(batalha.new Correr(System.currentTimeMillis() +1000, batalha.treinador1));
				batalha.run();
				if(opcaoT2[i] == 1) batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.treinador2, batalha.treinador1, 0));
				else if(opcaoT2[i] == 2) batalha.addEvent(batalha.new Cura(System.currentTimeMillis() +1000, batalha.treinador2));
				else if(opcaoT2[i] == 3) batalha.addEvent(batalha.new Troca(System.currentTimeMillis() +1000, batalha.treinador2));
				else if(opcaoT2[i] == 4) batalha.addEvent(batalha.new Correr(System.currentTimeMillis() +1000, batalha.treinador2));
				batalha.run();
			}
			else if(opcaoT1[i] < opcaoT2[i]){
				if(opcaoT2[i] == 1) batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.treinador2, batalha.treinador1, 0));
				else if(opcaoT2[i] == 2) batalha.addEvent(batalha.new Cura(System.currentTimeMillis() +1000, batalha.treinador2));
				else if(opcaoT2[i] == 3) batalha.addEvent(batalha.new Troca(System.currentTimeMillis() +1000, batalha.treinador2));
				else if(opcaoT2[i] == 4) batalha.addEvent(batalha.new Correr(System.currentTimeMillis() +1000, batalha.treinador2));
				batalha.run();
				if(opcaoT1[i] == 1) batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.treinador1, batalha.treinador2, 0));
				else if(opcaoT1[i] == 2) batalha.addEvent(batalha.new Cura(System.currentTimeMillis() +1000, batalha.treinador1));
				else if(opcaoT1[i] == 3) batalha.addEvent(batalha.new Troca(System.currentTimeMillis() +1000, batalha.treinador1));
				else if(opcaoT1[i] == 4) batalha.addEvent(batalha.new Correr(System.currentTimeMillis() +1000, batalha.treinador1));
				batalha.run();
			}
			i++;
		}
		if (batalha.treinador1.perdeu == true)
			System.out.println("O vencedor eh o " + batalha.treinador2.getTreinador());
		if (batalha.treinador2.perdeu == true)
			System.out.println("O vencedor eh o " + batalha.treinador1.getTreinador());
	}
}

