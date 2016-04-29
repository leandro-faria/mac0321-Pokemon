
public class Treinador {
	private String nome;
	private int posicao;
	private Pokemon[] pokemao = new Pokemon[6];
	private int i= 0;
	private Pokemon ativo;
	boolean perdeu = false;
	private int r = 0;
	
	public Treinador(String nome, int posicao, Pokemon [] pokemaos){
		this.nome = nome;
		this.posicao = posicao;
		for (int k = 0; k <= 5; k++)
			pokemao [k] = pokemaos [k];
	}
	
	public String getTreinador (){
		return this.nome;
	}
	
	public void pokemaoAtivo(){
		if (r < 6){
			while(r < 6){
				if(this.pokemao[r].getHp() != 0){
					ativo = this.pokemao[r++];
					return;
				}
			r++;
			}
		}
		if(r >= 6){
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
	
	public void Correu(){
		for (int k = 0; k <= 5; k++)
			pokemao[k].setHpAtual(0);
	}
	
	public Pokemon getAtivo(){
		return ativo;
	}

	public String getNome() {
		return nome;
	}
	
}
