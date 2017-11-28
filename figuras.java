package paradigmas_programacion;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class figuras extends Application {
	private double Radio = 180;
	private double rad = 40;
	private Circle circle = new Circle();
	private Circle circle2 = new Circle();
	private Pane paneCenter = new Pane();
	private BorderPane panep = new BorderPane();
	private Pane paneBottom = new Pane();
	private Pane paneLeft = new Pane();
	Button btnDis = new Button("Decrease");
	Button btnAum = new Button("Increase");
	Button btnMas = new Button("More");
	Button btnMenos = new Button("Less");

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		btnAum.setLayoutY(200);
		btnDis.setLayoutY(400);
		btnMas.setLayoutX(100);
		btnMenos.setLayoutX(300);
		btnAum.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Radio += 3;
				pintar(primaryStage, paneLeft);
			}
		});
		btnDis.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Radio -= 3;
				pintar(primaryStage, paneLeft);

			}
		});
		btnMas.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				rad += 3;
				pintar(primaryStage, paneBottom);

			}
		});
		btnMenos.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				rad -= 3;
				pintar(primaryStage, paneBottom);

			}
		});

		paneBottom.getChildren().addAll(btnMas, btnMenos);
		panep.setCenter(paneCenter);
		panep.setLeft(paneLeft);
		panep.setBottom(paneBottom);

		pintar(primaryStage, panep);

		paneLeft.getChildren().addAll(btnAum, btnDis);

	}

	private void pintar(Stage primaryStage, Pane paneb) {
		primaryStage = new Stage();

		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		circle.getStrokeDashArray().addAll(4., 10., 4., 10.);
		circle.setRadius(Radio);

		Polygon triangle = new Polygon(0, Radio * -1, -Radio * Math.cos(Math.PI / 6),
				(-Radio * Math.sin(Math.PI / 6)) * -1, Radio * Math.cos(Math.PI / 6),
				(-Radio * Math.sin(Math.PI / 6)) * -1);
		triangle.setStroke(Color.ALICEBLUE);
		triangle.setFill(null);

		circle2.setCenterX(0);
		circle2.setCenterY(Radio * -1);
		circle2.setRadius(rad);
		circle2.setFill(Color.RED);
		circle2.setStroke(Color.BLACK);

		Polygon triangle2 = new Polygon(-1 * (0 + circle.getRadius() * Math.cos(Math.PI / 6)),
				-circle2.getRadius() + circle.getRadius() * Math.sin(Math.PI / 6),
				-1 * (-circle2.getRadius() * Math.cos(Math.PI / 6) + circle.getRadius() * Math.cos(Math.PI / 6)),
				circle2.getRadius() * Math.sin(Math.PI / 6) + circle.getRadius() * Math.sin(Math.PI / 6),
				-1 * (circle2.getRadius() * Math.cos(Math.PI / 6) + circle.getRadius() * Math.cos(Math.PI / 6)),
				circle2.getRadius() * Math.sin(Math.PI / 6) + circle.getRadius() * Math.sin(Math.PI / 6));
		triangle2.setStroke(Color.BLACK);
		triangle2.setFill(Color.DARKGREEN);

		Rectangle square = new Rectangle(rad + (rad / 2), rad + (rad / 2));
		square.setFill(Color.DODGERBLUE);
		square.setStroke(Color.BLACK);
		square.setY((circle.getRadius() * Math.sin(Math.PI / 6)) - (square.getHeight() / 2));
		square.setX((circle.getRadius() * Math.cos(Math.PI / 6)) - (square.getWidth() / 2));

		Shape[] shapes = { circle, triangle, triangle2, square, circle2 };
		for (Shape shape : shapes) {
			shape.setLayoutX(250);
			shape.setLayoutY(250);
		}

		paneCenter.getChildren().clear();
		paneCenter.getChildren().addAll(circle, triangle, circle2, triangle2, square);
		Scene scene = new Scene(panep, 600, 600);
		primaryStage.setTitle("Figuras");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}