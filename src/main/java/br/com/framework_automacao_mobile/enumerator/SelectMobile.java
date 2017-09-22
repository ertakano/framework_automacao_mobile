package br.com.framework_automacao_mobile.enumerator;

public enum SelectMobile {

	ANDROID("ANDROID"),
	IOS("IOS");
	
	private final String value;
	
	SelectMobile(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
