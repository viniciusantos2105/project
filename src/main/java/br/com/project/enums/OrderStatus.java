package br.com.project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
	WAITING_PAYMENT(1, "Aguardando Pagamento"),
	PAID(2, "Pago"),
	SHIPPED(3, "Enviado"),
	DELIVERED(4, "Entregue"),
	CANCELED(5, "Cancelado");
	
	Integer option;
	String description;
}
