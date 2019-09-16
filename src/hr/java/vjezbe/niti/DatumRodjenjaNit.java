package hr.java.vjezbe.niti;

import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Student;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DatumRodjenjaNit implements Runnable {


	BazaPodataka bazaPodataka = new BazaPodataka();
	
	@Override
	public void run() {

		try {
			List<Student> list = bazaPodataka.getStudentWhereDateTime();
		

			if(list.isEmpty() == false) {
				Alert alertSuccess = new Alert(AlertType.INFORMATION);
				alertSuccess.setTitle("Rodjendan studenata");
				alertSuccess.setHeaderText("Cestitaj rodjendan sljedecim studentima:");

				StringBuilder imenaStudenta = new StringBuilder();

				for(Student student : list) {
					imenaStudenta.append(student.getPrezime() + " " + student.getIme() + "\n");
				}

				alertSuccess.setContentText(imenaStudenta.toString());
				alertSuccess.showAndWait();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}