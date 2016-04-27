
public class Treinador {
	private String nome;
	private int posicao;
	private Pokemon[] pokemao = new Pokemon[6];
	private int i= 0;
	private Pokemon ativo;
	boolean perdeu = false;
	private int r;
	
	public Treinador(String nome, int posicao, Pokemon [] pokemaos, int r){
		this.nome = nome;
		this.posicao = posicao;
		this.r = r;
		for (int k = 0; k <= 5; k++)
			pokemao [k] = pokemaos [k];
	}
	
	public int getNumTroca(){
		if (r < 5)
			return r++;
		else{
			r = 0;
			return r;
		}
	}
	
//	public void PokemaosTreinador(Pokemon [] pokemaos){
//		for (int k = 0; k <= 5; k++)                              not in use
//			pokemao [k] = pokemaos [k];
//	}
	
	public String getTreinador (){
		return this.nome;
	}
	
	public void pokemaoAtivo(){
		if (r < 6){
			if(this.pokemao[r].getHp() != 0){
				ativo = this.pokemao[r];
			}
		}
		else {
			for(r = 0; r < 6; r++){
				if(this.pokemao[r].getHp() != 0){
					ativo = this.pokemao[r];
					break;
				}
			}
			if (this.pokemao[0].getHp() == 0 &&
					this.pokemao[1].getHp() == 0 &&
					this.pokemao[2].getHp() == 0 &&
					this.pokemao[3].getHp() == 0 &&
					this.pokemao[4].getHp() == 0 &&
					this.pokemao[5].getHp() == 0 )
					perdeu = true;
			else perdeu = false;
		}
	}
	
	public boolean Perdeu (){
		if (this.pokemao[0].getHp() == 0 &&
			this.pokemao[1].getHp() == 0 &&
			this.pokemao[2].getHp() == 0 &&
			this.pokemao[3].getHp() == 0 &&
			this.pokemao[4].getHp() == 0 &&
			this.pokemao[5].getHp() == 0 )
			perdeu = true;
		else perdeu = false;
		return perdeu;
		
	}
	public Pokemon getAtivo(){
		return ativo;
	}
	
}
