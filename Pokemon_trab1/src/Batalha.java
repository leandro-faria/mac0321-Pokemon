
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
	Pokemon pokemons2 [] = {Mew, Pikachu, Entei, Suicune, Raykou, Onix};
	private  Treinador treinador1 = new Treinador("treinador1", 1, pokemons1, 0);
	private Treinador treinador2 = new Treinador("treinador2", 2, pokemons2, 0);

	private class Correr extends Event {
		Treinador treinador;
		public Correr (long eventTime, Treinador treinador){
			super (eventTime);
			this.treinador = treinador;
		}
		
		public void action() {
			//acaba a batalha, portanto encerra a simulacao
			return;
		}
		
		public String description () { 
			//print na main falando qual treinador fugiu da batalha
			return treinador.getTreinador() + " fugiu da batalha!!";
		}
	}
	
	private class Troca extends Event {
		Treinador treinador;
		int pokemao;
		public Troca (long eventTime, Treinador treinador, int pokemao){ //pokemao deve ser um num entre 0 e 5
			super(eventTime);
			this.treinador = treinador;
			this.pokemao = pokemao;
		}
		
		public void action () {
			treinador.pokemaoAtivo();
		}
		
		public String description (){
			return "Pokemon atual foi substituido por " + treinador.getAtivo().getNome() + treinador.getAtivo().getHp() + "/" + treinador.getAtivo().getHpMax();
		}
	}
	
	private class Cura extends Event {
		Treinador treinador;
		public Cura (long eventTime, Treinador treinador){
			super (eventTime);
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
			return "hp de " + treinador.getAtivo().getNome() + " foi recuperado!!";
		}
	}
	
	private class Ataca extends Event {
		Treinador treinador1;
		Treinador treinador2;
		int i;
		boolean atacou = false;
		public Ataca (long eventTime, Treinador treinador1, Treinador treinador2, int ataque){
			super (eventTime);
			this.treinador1 = treinador1;
			this.treinador2 = treinador2;
			i = ataque;
		}
		
		public void action () {
			double dano = treinador1.getAtivo().habilidade[i].getDano();
			if (treinador1.getAtivo().getHp() > 0){
				treinador2.getAtivo().levaDano(dano); 
				atacou = true;
			}
			if(treinador2.getAtivo().getEstado() == true){
				treinador2.pokemaoAtivo();
			}
		}
		
		public String description (){
			if (atacou == true)
				return treinador1.getAtivo().getNome() + " usou " + treinador1.getAtivo().habilidade[i].getHabilidade() + ", causando " + treinador1.getAtivo().habilidade[i].getDano() + " de dano";  
			else return "";
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Batalha batalha = new Batalha();
		int opcao = 0;
		int opcaoT1[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} , opcaoT2[] = {1,3,3,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int i = 0;
		
//		Falta: quando um pokemon for pra fora de combate, temos que fazer outro entrar em seu lugar, ou seja, fazer um evento Troca
		batalha.treinador1.pokemaoAtivo();
		batalha.treinador2.pokemaoAtivo();
		
		while (opcao != 4 && batalha.treinador1.perdeu == false && batalha.treinador2.perdeu == false){
			
			if (opcaoT1[i] == 1 && opcaoT2 [i] == 1){
				batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.treinador1, batalha.treinador2, 0));
				batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.treinador2, batalha.treinador1, 0));
				batalha.run();
				Thread.sleep(1000);
				System.out.println("");
				System.out.println(batalha.treinador1.getAtivo().getNome() + " " + batalha.treinador1.getAtivo().getHp() + "/" + batalha.treinador1.getAtivo().getHpMax());
				System.out.println("");
				System.out.println(batalha.treinador2.getAtivo().getNome() + " " + batalha.treinador2.getAtivo().getHp() + "/" + batalha.treinador2.getAtivo().getHpMax());
				System.out.println("");
				Thread.sleep(1000);
				if (batalha.treinador1.getAtivo().getEstado() == true){
					System.out.println("Pokemon " + batalha.treinador1.getAtivo().getNome() + " estah fora de combate!!");
					batalha.addEvent(batalha.new Troca(System.currentTimeMillis() , batalha.treinador1, batalha.treinador1.getNumTroca()));
					batalha.run();
				}
				if (batalha.treinador2.getAtivo().getEstado() == true){
					System.out.println("Pokemon " + batalha.treinador2.getAtivo().getNome() + " estah fora de combate!!");
					batalha.addEvent(batalha.new Troca(System.currentTimeMillis() , batalha.treinador2, batalha.treinador2.getNumTroca()));
					batalha.run();
				}
				i++;
			}
			
			if (opcaoT1[i] == 1 && opcaoT2[i] == 4 ){
				opcao = 4;
				batalha.addEvent(batalha.new Correr(System.currentTimeMillis(), batalha.treinador2));	
				batalha.run();
			}
			
			if (opcaoT1[i] == 1 && opcaoT2[i] == 2 ){
				batalha.addEvent(batalha.new Cura(System.currentTimeMillis(), batalha.treinador2));
				batalha.run();
				Thread.sleep(1000);
				System.out.println("");
				System.out.println(batalha.treinador2.getAtivo().getNome() + " " + batalha.treinador2.getAtivo().getHp() + "/" + batalha.treinador2.getAtivo().getHpMax());
				System.out.println("");
				Thread.sleep(1000);
				batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() , batalha.treinador1, batalha.treinador2, 1));
				batalha.run();
				System.out.println("");
				System.out.println(batalha.treinador1.getAtivo().getNome() + " " + batalha.treinador1.getAtivo().getHp() + "/" + batalha.treinador1.getAtivo().getHpMax());
				System.out.println("");
				System.out.println(batalha.treinador2.getAtivo().getNome() + " " + batalha.treinador2.getAtivo().getHp() + "/" + batalha.treinador2.getAtivo().getHpMax());
				System.out.println("");
				Thread.sleep(1000);
//				if (batalha.treinador1.getAtivo().getEstado() == true){
//					System.out.println("Pokemon " + batalha.treinador1.getAtivo().getNome() + " estah fora de combate!!");
//					batalha.addEvent(batalha.new Troca(System.currentTimeMillis() , batalha.treinador1, 1));
//					break; 
//				}
				if (batalha.treinador2.getAtivo().getEstado() == true){
					System.out.println("Pokemon " + batalha.treinador2.getAtivo().getNome() + " estah fora de combate!!");
					batalha.addEvent(batalha.new Troca(System.currentTimeMillis() , batalha.treinador2, batalha.treinador2.getNumTroca()));
					batalha.run();
				}
				i++;
			}
			
			if (opcaoT1[i] == 1 && opcaoT2[i] == 3 ){
				batalha.addEvent(batalha.new Troca(System.currentTimeMillis() , batalha.treinador2, batalha.treinador2.getNumTroca()));
				batalha.run();
				batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() , batalha.treinador1, batalha.treinador2, 0));
				batalha.run();
				System.out.println(batalha.treinador2.getAtivo().getNome() + " " + batalha.treinador2.getAtivo().getHp() + "/" + batalha.treinador2.getAtivo().getHpMax());
				System.out.println("");
				Thread.sleep(1000);
				if (batalha.treinador2.getAtivo().getEstado() == true){
					System.out.println("Pokemon " + batalha.treinador2.getAtivo().getNome() + " estah fora de combate    !!");
					batalha.addEvent(batalha.new Troca(System.currentTimeMillis() , batalha.treinador2, batalha.treinador2.getNumTroca()));
					batalha.run();
				}
				i++;
			}
		}
	}
}
