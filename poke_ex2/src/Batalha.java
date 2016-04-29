import java.util.Random;

public class Batalha extends Controller {
	private  Pokemon Blastoise = new Blastoise();
	private  Pokemon Zapdos = new Zapdos();
	private  Pokemon Moltres = new Moltres();
	private  Pokemon Articuno = new Articuno();
	private  Pokemon Mewtwo = new Mewtwo();
	private  Pokemon Pikachu = new Pikachu();
	private  Pokemon Onix = new Onix();
	private  Pokemon Charmander = new Charmander();
	Pokemon pokemons1[] = {Blastoise, Zapdos, Moltres, Articuno, Mewtwo};
	private Treinador selvagem = new Treinador ("selvagem", 2, Pikachu);
	private Treinador treinador1 = new Treinador("treinador1", 1, pokemons1);
	private int i = 0;
	private int j = 0;
	private int mapa[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
			{1,1,1,1,1,1,2,2,2,2,2,2,2,2,1,1,},
			{2,2,2,2,1,1,2,2,2,2,2,2,2,2,1,1,},
			{2,2,2,2,1,1,2,2,2,2,2,2,2,2,1,1,},
			{2,2,2,2,1,1,2,2,2,2,2,2,2,2,1,1,},
			{2,2,2,2,1,1,2,2,2,2,2,2,2,2,1,1,},
			{2,2,2,2,1,1,2,2,2,2,2,2,2,2,1,1,},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
			{1,1,2,2,2,2,2,2,2,2,2,1,1,1,1,1,},
			{1,1,2,2,2,2,2,2,2,2,2,1,1,1,1,1,},
			{1,1,2,2,2,2,2,2,2,2,2,1,1,1,1,1,},
			{1,1,2,2,2,2,2,2,2,2,2,1,1,1,1,1,}};
	

	public void direita(){
		if(j == 15)
			if(i > 0) {
				cima();
				return;
			}
		j++;
	}
	
	public void esquerda(){
		if(j == 0)
			if(i < 15){
				baixo();
				return;
			}
		j--;
	}
	
	public void cima(){
		if(i == 0)
			if(j > 0) {
				esquerda();
				return;
			}
		i--;
	}
	
	public void baixo(){
		if(i == 15)
			if(j < 15) {
				direita();
				return;
			}
		i++;
	}
	
	public int[][] getMapa(){
		return mapa;
	}

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
				treinador2.getAtivo().levaDano(dano); 
				atacou = true;
				System.out.println(treinador1.getAtivo().getNome() + " usou " + treinador1.getAtivo().habilidade[i].getHabilidade() + ", causando " + treinador1.getAtivo().habilidade[i].getDano() + " de dano");  
				System.out.println("");
				System.out.println(treinador1.getAtivo().getNome() + " " + treinador1.getAtivo().getHp() + "/" + treinador1.getAtivo().getHpMax());
				System.out.println("");
				System.out.println(treinador2.getAtivo().getNome() + " " + treinador2.getAtivo().getHp() + "/" + treinador2.getAtivo().getHpMax());
				System.out.println("");
			}
		}
		
		public String description (){
			return "";
		}
	}
	
	private class Mapa extends Event{
		private int mapa[][];

		public Mapa(long eventTime, int mapa[][]) {
			super(eventTime, 5);
			this.mapa = mapa;
		}

		public void action() {
			for(int tmp = 0; tmp < 1000000; tmp++){
				Random gerador = new Random();
				int x = gerador.nextInt(4);//0 == esquerda, 1 == direita, 2 == cima, 3 == baixo
				if(x == 0){
					esquerda();
				}
				else if(x == 1){
					direita();
				}
				else if(x == 2){
					cima();
				}
				else if(x == 3){
					baixo();
				}
				if(mapa[i][j] == 2){
					System.out.println("Treinador estah andando no gramado\n");
					Random gerador2 = new Random();
					int x2 = gerador2.nextInt(100);
					if(x2 < 20){
						return;
					}
				}
				else System.out.println("Treinador estah andando no chão comum\n");
			}
		}

		public String description() {
			return "Treinador encontrou um pokemon selvagem\n";
		}
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		Batalha batalha = new Batalha();
		int opcao = 0;
		int opcaoT1[] = {1,3,1,1,1,3,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int i = 0;
		Random gerador = new Random(19700621);
		
		batalha.treinador1.pokemaoAtivo();
		
		batalha.addEvent(batalha.new Mapa (System.currentTimeMillis() +1000, batalha.getMapa()));
		batalha.run();
		while (batalha.treinador1.perdeu == false && batalha.selvagem.perdeu == false){
			if(opcaoT1[i] == 1) batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.treinador1, batalha.selvagem, 0));
			else if(opcaoT1[i] == 2) batalha.addEvent(batalha.new Cura(System.currentTimeMillis() +1000, batalha.treinador1));
			else if(opcaoT1[i] == 3) batalha.addEvent(batalha.new Troca(System.currentTimeMillis() +1000, batalha.treinador1));
			else if(opcaoT1[i] == 4) batalha.addEvent(batalha.new Correr(System.currentTimeMillis() +1000, batalha.treinador1));
			if (batalha.selvagem.getAtivo().getEstado() == true){
				System.out.println("Pokemon " + batalha.selvagem.getAtivo().getNome() + " estah fora de combate!!\n");
				System.out.println("O vencedor eh o " + batalha.treinador1.getTreinador());
				break;
			}
			batalha.run();
			batalha.addEvent(batalha.new Ataca(System.currentTimeMillis() +1000, batalha.selvagem, batalha.treinador1, gerador.nextInt(4)));
			batalha.run();
			if(batalha.treinador1.getAtivo().getEstado() == true){
				System.out.println("Pokemon " + batalha.treinador1.getAtivo().getNome() + " estah fora de combate!!\n");
				batalha.treinador1.pokemaoAtivo();
				if (batalha.treinador1.Perdeu() == false)
					System.out.println("Pokemon atual foi substituido por " + batalha.treinador1.getAtivo().getNome() + " " + batalha.treinador1.getAtivo().getHp() + "/" + batalha.treinador1.getAtivo().getHpMax());
			}
			i++;
		}	
		if (batalha.treinador1.perdeu)
			System.out.println("O vencedor eh o " + batalha.selvagem.getTreinador());
		}	
}

