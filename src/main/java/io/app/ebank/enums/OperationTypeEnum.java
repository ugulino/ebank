package io.app.ebank.enums;

public enum OperationTypeEnum {
	COMPRA_A_VISTA(1), 
	COMPRA_PARCELADA(2), 
	SAQUE(3), 
	PAGAMENTO(4);
	
	public int operationTypeValue;
	OperationTypeEnum(int value) {
		operationTypeValue = value;
	}
	
	public int getOperationTypeValue() {
		return operationTypeValue;
	}
}
