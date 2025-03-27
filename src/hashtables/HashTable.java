package hashtables;

public class HashTable {

	private String[] tabell;
	private int antall;
	
	public HashTable(int antall) {
		this.antall = antall;
		this.tabell = new String[antall];
	}
	
	// hashfunksjon 
	private int hash(String skilt) {
		// henter siste siffer i skilt
		char sisteSiffer = skilt.charAt(skilt.length() - 1);
		// returnerer siste siffer mod antall; plassering i tabell
		return Character.getNumericValue(sisteSiffer) % antall;
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
			if (tabell[i] != null){
				System.out.print(tabell[i]);
				System.out.println();
			} else {
				System.out.println("Tomt");
			}
		}
	}
	
	public static void main (String[] args) {
		HashTable hashTabell = new HashTable(10);
		String[] skilt = {"EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"};
		
		for (String s : skilt) {
			hashTabell.settInn(s);
		}
		hashTabell.printTabell();
	}
	
}
