package hr.java.vjezbe;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.niti.DatumRodjenjaNit;
import hr.java.vjezbe.niti.ZadnjeUneseniIspit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	private static BorderPane root;
	public static Scene scene;
	BazaPodataka bazaPodataka = new BazaPodataka();
	private Service<Void> backgroundThread;

	DatumRodjenjaNit datumRodjenjaNit = new DatumRodjenjaNit();



	@Override
	public void start(Stage primaryStage) {



		//
		//		backgroundThread.restart();
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("Pocetna.fxml"));
			scene = new Scene(root, 350, 420);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Rodjendan ima: ");
			primaryStage.getIcons().add(new Image("https://cdn4.iconfinder.com/data/icons/google-i-o-2016/512/google_assistant-512.png"));
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.show();
			BackgroundFill myBF = new BackgroundFill(Color.LIGHTSTEELBLUE, new CornerRadii(1),
					new Insets(0.0,0.0,0.0,0.0));
			root.setBackground(new Background(myBF));
		} catch(Exception e) {
			e.printStackTrace();
		}

		Timeline prikazSlavljenika = new Timeline(
				new KeyFrame(Duration.seconds(15), new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Platform.runLater(new DatumRodjenjaNit());
					}
				}));
		prikazSlavljenika.setCycleCount(Timeline.INDEFINITE);
		prikazSlavljenika.play();


		Timeline showLastIspit = new Timeline(
				new KeyFrame(Duration.seconds(15), new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Platform.runLater(new ZadnjeUneseniIspit());
					}
				}));
		showLastIspit.setCycleCount(Timeline.INDEFINITE);
		showLastIspit.play();

	}





	//	private void test(Stage primaryStage) {
	//
	//		List<Student> list = bazaPodataka.getStudentWhereDateTime();
	//		Optional<List<Student>> possibleStudList = Optional.ofNullable(list);
	//
	//		try {
	//		//	while(true) {
	//			if (!possibleStudList.get().isEmpty()) {
	//				primaryStage.setTitle("Rodjendan ima: " + list.toString());
	//			} else {
	//				primaryStage.setTitle("Danas nitko ne slavi rodjendan od studenta!");
	//			}
	//			 //Thread.sleep(5);
	//		//	}
	//
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//	}



	public static void main(String[] args) {
		launch(args);
	}

	public static void setCenterPane(BorderPane centerPane) {
		root.setBottom(centerPane);

	}
}
