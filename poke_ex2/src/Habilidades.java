public class Habilidades {
	String nomeHab;
	int dano;
	String descricao;

	public Habilidades (String nomeHab, int dano, String descricao){
		this.nomeHab = nomeHab;
		this.dano = dano;
		this.descricao = descricao;
	}

	public int getDano (){
		return dano;
	}
	
	public String getHabilidade (){
		return this.nomeHab;
	}
}
