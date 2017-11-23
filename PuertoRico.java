package paradigmas_programacion;

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class PuertoRico extends Application {

	Polyline polyline = new Polyline();
	Polyline polyline1 = new Polyline();
	private double lados = 5, paso = 2, stars = 0;
	private double rad = 100;
	private double x = 0, y = 0;

	Pane pane = new Pane();
	Group group = new Group();

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		pintar(primaryStage);
		triangulo();
		estrella(x, y, rad);

	}

	private void pintar(Stage primaryStage) {
		Scene scene = new Scene(pane, 800, 600);

		Rectangle r4 = new Rectangle();
		Rectangle r5 = new Rectangle();
		Rectangle r6 = new Rectangle();
		Rectangle r7 = new Rectangle();
		Rectangle r8 = new Rectangle();

		pane.getChildren().addAll(r4, r5, r6, r7, r8);

		r4.setFill(Color.RED);
		r4.setX(0);
		r4.setY(0);
		r4.setWidth(800);
		r4.setHeight(100);

		r5.setFill(Color.WHITE);
		r5.setX(0);
		r5.setY(200);
		r5.setWidth(800);
		r5.setHeight(200);

		r6.setFill(Color.RED);
		r6.setX(0);
		r6.setY(250);
		r6.setWidth(800);
		r6.setHeight(200);

		r7.setFill(Color.WHITE);
		r7.setX(0);
		r7.setY(350);
		r7.setWidth(800);
		r7.setHeight(200);

		r8.setFill(Color.RED);
		r8.setX(0);
		r8.setY(450);
		r8.setWidth(800);
		r8.setHeight(150);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Bandera Puerto Rico");
		primaryStage.show();

	}

	private void triangulo() {
		polyline1.setStroke(Color.DARKBLUE);
		polyline1.setFill(Color.DARKBLUE);
		polyline1.getPoints().addAll(new Double[] { 0.0, 0.0, 0.0, 600.0, 400.0, 300.0 });
		pane.getChildren().addAll(polyline1);

	}

	private void estrella(double x, double y, double radio) {

		polyline.setStroke(Color.WHITE);
		polyline.setFill(Color.WHITE);

		ObservableList<Double> lista = polyline.getPoints();
		y = 600 / 2;
		x = 350 / 2;
		stars = lados / paso;

		double radi = (2 * Math.PI) / stars;

		pane.getChildren().addAll(polyline);

		polyline.setRotate(55);

		for (int i = 0; i < lados; i++) {
			lista.add(x + radio * Math.cos(i * radi));
			lista.add(y + radio * Math.sin(i * radi));

		}
	}
}