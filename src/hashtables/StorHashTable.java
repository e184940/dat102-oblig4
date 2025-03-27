package hashtables;

public class StorHashTable {

	private String[] tabell;
	private int antall;
	
	public StorHashTable(int antall) {
		this.antall = antall;
		this.tabell = new String[antall];
	}
	
	// ny hashfunksjon 
	private int hash(String skilt) {
		// returnerer siste siffer i skilt, og bruker det som hashverdi
        return Integer.parseInt(skilt.substring(skilt.length() - 1)) % tabell.length;
	}
	
	public void settInn(String skilt) {
		int index = hash(skilt);
		int orgIndex = index;
		
		// linær probing; finner neste ledige plass
		while(tabell[index] != null) {
			// steglengde 1
			index = (index + 1) % antall;
			// hvis vi er tilbake på start, så er tabell full	
			if(index == orgIndex) {
				System.out.println("Tabell er full");
				return;
			}
		}
		tabell[index] = skilt;
	}
	
	public void printTabell() {
		for(int i = 0; i < antall; i++) {
			System.out.print("Index " + i + ": ");
			// skriver ut element på gitt index dersom det er noe der
			if (tabell[i] != null){
				System.out.print(tabell[i]);
				System.out.println();
			// skriver ut "Tomt" dersom tomt
			} else {
				System.out.println("Tomt");
			}
		}
	}
	
	public static void main (String[] args) {
		// opretter dobbelt så lang hashtabell
		HashTable hashTabell = new HashTable(20);
		String[] skilt = {"EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"};
		
		for (String s : skilt) {
			hashTabell.settInn(s);
		}
		hashTabell.printTabell();
	}
	
}
