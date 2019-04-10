package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estacionamento {
	List<Carro> carros = new ArrayList<Carro>();
	private final int ESTACIONAMENTO_LOTADO = 10;
	private final int IDADE_SENIOR = 55;
	private final int IDADE_MINIMA_PARA_CARTEIRA = 18;
	private final int MAXIMO_DE_PONTOS_NA_CARTEIRA = 20;
	
	public void estacionar(Carro carro) {
		if (carro.getMotorista() == null || carro.getMotorista().getIdade() < IDADE_MINIMA_PARA_CARTEIRA || carro.getMotorista().getPontos() > MAXIMO_DE_PONTOS_NA_CARTEIRA) throw new EstacionamentoException();
		if (carros.size() == ESTACIONAMENTO_LOTADO) {
			if (carros.stream().filter(x -> x.getMotorista().getIdade() > IDADE_SENIOR).collect(Collectors.toList()).size() == 10) throw new EstacionamentoException();
			if (carros.stream().filter(x -> x.getMotorista().getIdade() < IDADE_SENIOR).findFirst().orElse(null) != null) carros.remove(carros.stream().filter(x -> x.getMotorista().getIdade() < IDADE_SENIOR).findFirst().orElse(null));
			else carros.remove(0);
		}
		carros.add(carro);
	}
	
	public int carrosEstacionados() {
		return carros.size();
	}
	
	public boolean carroEstacionado(Carro carro) {
		if (carros.contains(carro)) return true;
		return false;
	}
}
