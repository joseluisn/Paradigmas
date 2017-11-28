package paradigmas_programacion;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.stage.Stage;

public class Ingreso extends Application {
	private TableView table = new TableView();
	private final ObservableList<Estudiante> listaDatos = 
		     FXCollections.observableArrayList();

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 400, 375);
		primaryStage.setScene(scene);

		Text scenetitle = new Text("Formulario de ingreso");
		grid.add(scenetitle, 0, 0, 2, 1);

		Label labelName = new Label("Nombres ");
		grid.add(labelName, 0, 1);
		TextField fieldName = new TextField("");
		grid.add(fieldName, 1, 1);
		Label labelDocumento = new Label("Tipo documento ");
		grid.add(labelDocumento, 0, 2);

		ChoiceBox TypeDocumentchoiceBox = new ChoiceBox();
		TypeDocumentchoiceBox.getItems().addAll("Cedula ", "Cedula de extranjeria", "Pasaporte",
				"Tarjeta de identidad");

		grid.add(TypeDocumentchoiceBox, 1, 2);
		Label labelNumIden = new Label("Num de identificacion ");
		grid.add(labelNumIden, 0, 4);
		TextField fieldNumIden = new TextField("");
		grid.add(fieldNumIden, 1, 4);

		Button btnOk = new Button("Ok");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btnOk);
		grid.add(hbBtn, 0, 6);

		Button btnTable = new Button("Ver tabla");
		HBox hbBtnTable = new HBox(10);
		hbBtnTable.setAlignment(Pos.BOTTOM_LEFT);
		hbBtnTable.getChildren().add(btnTable);
		grid.add(hbBtnTable, 1, 6);

		Button btnExit = new Button("Exit");
		HBox hbBtnExit = new HBox(10);
		hbBtnExit.setAlignment(Pos.BOTTOM_LEFT);
		hbBtnExit.getChildren().add(btnExit);
		grid.add(hbBtnExit, 2, 6);
		Button btnBack = new Button("Back");
		Button[] buttons = { btnOk, btnTable, btnExit, btnBack };
	

		Scene scene2 = new Scene(new Group());
		primaryStage.setTitle("Registros estudiantes");
		primaryStage.setWidth(400);
		primaryStage.setHeight(600);

		final Label label = new Label("Estudiantes");

		table.setEditable(true);
		

		TableColumn name = new TableColumn("Nombre");
		TableColumn primeraNota = new TableColumn("1ra nota");
		TableColumn segundaNota = new TableColumn("2da nota");
		TableColumn terceraNota = new TableColumn("3ra nota");
		TableColumn defNota = new TableColumn("Nota definitiva");

		table.getColumns().addAll(name, primeraNota, segundaNota, terceraNota, defNota);
		name.setCellValueFactory( new PropertyValueFactory<Estudiante, String>
	      ("fieldName"));
		name.setCellValueFactory( new PropertyValueFactory<Estudiante, String>
	      ("fieldNumIden"));
	      table.setItems(listaDatos);
		
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		
		vbox.getChildren().addAll(label, table, btnBack);

		((Group) scene2.getRoot()).getChildren().addAll(vbox);

		EventHandler<ActionEvent> handler = (e) -> {
			Object obj = e.getSource();
			if (obj instanceof Button) {
				Button btn = (Button) obj;
				if (btn.getText().equals("Exit")) {
					primaryStage.close();
				}
				if (btn.getText().equals("Ver tabla")) {

					btnTable.setOnAction(es -> primaryStage.setScene(scene2));
				}
				if (btn.getText().equals("Back")) {

					btnBack.setOnAction(ex -> primaryStage.setScene(scene));
				}if(btn.getText().equals("Ok")) {
					 try {
						 Estudiante datos;
						
						 long numLong=Long.parseLong(fieldNumIden.getText());
						 datos = new Estudiante(fieldName.getText(),numLong);
					     listaDatos.add(datos);

					     } catch (Exception ex) {
					   System.out.println("Debe rellenar todos los campos antes de guardar");
					     }
					
				}
				System.out.println("click on " + btn.getText());
			}
		};

		for (Button btn : buttons)
			btn.setOnAction(handler);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Student controls");
		primaryStage.show();
	}

}

