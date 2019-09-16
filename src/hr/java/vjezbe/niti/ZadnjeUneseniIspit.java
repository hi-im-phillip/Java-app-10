package hr.java.vjezbe.niti;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Ispit;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ZadnjeUneseniIspit implements Runnable {
	
	BazaPodataka bazaPodataka = new BazaPodataka();
	
	
	
	
	@Override
	public void run() {
		
		
		//Optional<List<Ispit>> possibleLista = Optional.ofNullable(listIspit);
		
		try {
			
			Ispit listIspit = bazaPodataka.getLastIspit();
			//Ispit ispit = listIspit.get(listIspit.size() - 1);
		//	if (listIspit.isEmpty() == false) {
				
				Alert alertSuccess = new Alert(AlertType.INFORMATION);
				alertSuccess.setTitle("Zadnji ispit");

				
				StringBuilder zadnjiIspitBuilder = new StringBuilder();
				
				zadnjiIspitBuilder.append(listIspit.toString());

				alertSuccess.setContentText(zadnjiIspitBuilder.toString());
				alertSuccess.showAndWait();
	//		}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
