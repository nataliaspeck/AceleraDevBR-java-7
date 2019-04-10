package challenge;

import java.util.Objects;

public class Carro {
	private String placa;
	private Cor cor;
	private Motorista motorista;
	
	private Carro(Builder builder) {
		this.placa = builder.placa;
		this.cor = builder.cor;
		this.motorista = builder.motorista;
	}
	
	public static final class Builder {
		private String placa;
		private Cor cor;
		private Motorista motorista;
		
		public Builder() {}

		public Builder withPlaca(String placa) {
			this.placa = placa;
			return this;
		}

		public Builder withCor(Cor cor) {
			this.cor = cor;
			return this;
		}

		public Builder withMotorista(Motorista motorista) {
			this.motorista = motorista;
			return this;
		}

		public Carro build() {
			Objects.requireNonNull(this.placa, "A placa é obrigatoria.");
			Objects.requireNonNull(this.cor, "A cor é obrigatória.");
			return new Carro(this);
		}
		
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public static Builder builder() {
		return new Builder();
	}
}
