package jana60.vacanza;

import java.util.Scanner;

public class Agenzia {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Boolean menu = true;
		
		while(menu) {
			try {
				System.out.println("Inserisci la destinazione");
				String destinazione = scan.nextLine();
				System.out.println("Inserisci la data di inizio (aaaa-mm-gg): ");
				String dataInizio = scan.nextLine();
				System.out.println("Inserisci la data di fine (aaaa-mm-gg): ");
				String dataFine = scan.nextLine();
				
				Vacanza newHoliday = new Vacanza(destinazione, dataInizio, dataFine);
				
				System.out.println("Riassunto vacanza: " + newHoliday.getDestinazione() + "; Inizio: " + newHoliday.getDataInizio() + "; Data fine: " + newHoliday.getDataFine());
				
				menu = false;
			} catch(NullPointerException npe) {
				System.out.println("Errore: " + npe.getMessage());
				menu = true;
			} catch(Exception e) {
				System.out.println("Errore: " + e.getMessage());
				menu = true;
			}
			
			
			
			
		}
		
		scan.close();
		
		

	}

}
