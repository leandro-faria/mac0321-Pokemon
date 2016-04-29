
public class Treinador {
	private String nome;
	private int posicao;
	private Pokemon[] pokemao = new Pokemon[5];
	private Pokemon pokemaaao;
	private Selvagem selvagem = new Selvagem("selvagem", 200);
	private int i= 0;
	private Pokemon ativo;
	private Selvagem ativ;
	boolean perdeu = false;
	private int r = 0;
	
	public Treinador(String nome, int posicao, Pokemon [] pokemaos){
		this.nome = nome;
		this.posicao = posicao;
		for (int k = 0; k <= 4; k++)
			pokemao [k] = pokemaos [k];
	}
	
	public Treinador(String nome, int posicao, Pokemon selvagem){
		this.nome = nome;
		this.posicao = posicao;
		this.pokemaaao = selvagem;
		ativo = selvagem;
	}
	
//	public int getNumTroca(){
//		if (r < 5)
//			return r++;
//		else{
//			r = 0;
//			return r;
//		}
//	}
	
//	public void PokemaosTreinador(Pokemon [] pokemaos){
//		for (int k = 0; k <= 5; k++)                              not in use
//			pokemao [k] = pokemaos [k];
//	}
	
	public String getTreinador (){
		return this.nome;
	}
	
	public void pokemaoAtivo(){
		if (r < 5){
			while(r < 5){
				if(this.pokemao[r].getHp() != 0){
					ativo = this.pokemao[r++];
					return;
				}
			r++;
			}
		}
		if(r >= 5){
			for(r = 0; r < 5; r++){
				if(this.pokemao[r].getHp() != 0){
					ativo = this.pokemao[r];
					break;
				}
			}
			if (this.pokemao[0].getHp() == 0 &&
					this.pokemao[1].getHp() == 0 &&
					this.pokemao[2].getHp() == 0 &&
					this.pokemao[3].getHp() == 0 &&
					this.pokemao[4].getHp() == 0  )
					perdeu = true;
			else perdeu = false;
		}
	}
		
	public boolean Perdeu (){
		if (this.pokemao[0].getHp() == 0 &&
			this.pokemao[1].getHp() == 0 &&
			this.pokemao[2].getHp() == 0 &&
			this.pokemao[3].getHp() == 0 &&
			this.pokemao[4].getHp() == 0 )
			perdeu = true;
		else perdeu = false;
		return perdeu;
		
	}
	
	public void Correu(){
		for (int k = 0; k <= 4; k++)
			pokemao[k].setHpAtual(0);
	}
	
	public Pokemon getAtivo(){
		return ativo;
	}
	
}
