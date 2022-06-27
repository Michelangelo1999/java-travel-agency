package jana60.vacanza;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vacanza {
	
	private String destinazione;
	private String dataInizio;
	private String dataFine;
	
	public Vacanza(String destinazione, String dataInizio, String dataFine) throws Exception {
		super();
		//converto le stringhe inserite
		LocalDate dataInizioDate = convertiData(dataInizio);
		LocalDate dataFineDate = convertiData(dataFine);
		
		//gestisco l'errore di conversione
		if(dataInizio == null || dataFine == null) {
			throw new Exception("L'inserimento delle date non è valido");
		}
		
		//controlli sulle date
		if(!isValidDataInizio(dataInizioDate) || !isValidDataFine(dataFineDate)) {
			throw new Exception("");
		}
		
		
		//controlli sui valori dei campi
		
		this.destinazione = destinazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}
	
    //getters and setters
	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	
	//validation methods
	public boolean isValidDataInizio(LocalDate dataInizio) {
		LocalDate oggi = LocalDate.now();
		
		return oggi.isBefore(dataInizio);
	}
	
	public boolean isValidDataFine(LocalDate dataFine, LocalDate dataInizio) {
		return dataFine.isAfter(dataInizio);
	}
	
	
	//other methods
	private LocalDate convertiData(String dataInserita) {
		Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
		Matcher matcher = pattern.matcher(dataInserita);
		boolean matchFound = matcher.find();

		LocalDate d = null;
		
		//converte la stringa della data in un oggetto di classe Date
	        if (matchFound) {
//			DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
//			//imposta che i calcoli di conversione della data siano rigorosi       
//			formatoData.setLenient(false);
	        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			d = LocalDate.parse(dataInserita, formatoData);
			}
	        
	    return d;    
	           
	       
	 }
	

}
