package hashtables;

import java.util.LinkedList;

public class LenketHashTable {
	
	private LinkedList<String>[] tabell;
	private int antall;
	
	@SuppressWarnings("unchecked")
	public LenketHashTable(int antall) {
		this.antall = antall;
		this.tabell = new LinkedList[antall];
		
		for (int i = 0; i < antall; i++) {
			tabell[i] = new LinkedList<>();
		}
	}
	
	private int hash(String skilt) {
		char sisteSiffer = skilt.charAt(skilt.length() - 1);
		return Character.getNumericValue(sisteSiffer) % antall;
	}
	
	public void settInn(String skilt) {
		int index = hash(skilt);
		tabell[index].add(skilt);
	}
	
	public void printTabell() {
		for(int i = 0; i < antall; i++){
			System.out.print("Index " + i + ": ");
			if (tabell[i].isEmpty() == false) {
				System.out.print(tabell[i]);
				System.out.println();
			} else {
				System.out.println("Tomt");
			}
		}
	}

	public static void main(String[] args) {
		LenketHashTable hashTabell = new LenketHashTable(10);
		String[] skilt = {"EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"};
		
		for (String s : skilt) {
			hashTabell.settInn(s);
		}
		hashTabell.printTabell();
	}

}
