package paradigmas_programacion;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Panama extends Application {

	private double rad = 60;
	private double lados = 5, paso = 2, stars = 0;
	private double x = 0, y = 0;
	private Pane pane = new Pane();
	Polyline polyline = new Polyline();
	Polyline polyline1 = new Polyline();

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		pintar(primaryStage);
		estrella1(x, y, rad);
		estrella2(x, y, rad);
	}

	private void pintar(Stage primaryStage) {
		Scene scene = new Scene(pane, 600, 400);
		Rectangle r = new Rectangle();
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		Rectangle r3 = new Rectangle();
		Rectangle r4 = new Rectangle();

		pane.getChildren().addAll(r, r1, r2, r3);

		r.setFill(Color.WHITE);
		r.setX(0);
		r.setY(0);
		r.setWidth(300);
		r.setHeight(200);

		r1.setFill(Color.RED);
		r1.setX(300);
		r1.setY(0);
		r1.setWidth(300);
		r1.setHeight(200);

		r2.setFill(Color.DARKBLUE);
		r2.setX(0);
		r2.setY(200);
		r2.setWidth(300);
		r2.setHeight(200);

		r3.setFill(Color.WHITE);
		r3.setX(300);
		r3.setY(200);
		r3.setWidth(300);
		r3.setHeight(200);

		r4.setFill(Color.RED);
		r4.setX(0);
		r4.setY(0);
		r4.setWidth(800);
		r4.setHeight(100);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Bandera Panama");
		primaryStage.show();
	}

	private void estrella1(double x, double y, double radio) {
		polyline.setStroke(Color.DARKBLUE);
		polyline.setFill(Color.DARKBLUE);
		pane.getChildren().add(polyline);
		ObservableList<Double> list = polyline.getPoints();
		y = 200 / 2;
		x = 300 / 2;
		stars = lados / paso;

		double radius = (2 * Math.PI) / stars;
		polyline.setRotate(55);

		for (int i = 0; i < lados; i++) {
			list.add(x + radio * Math.cos(i * radius));
			list.add(y + radio * Math.sin(i * radius));
		}
	}

	private void estrella2(double x, double y, double radio) {

		polyline1.setStroke(Color.RED);
		polyline1.setFill(Color.RED);
		ObservableList<Double> lista = polyline1.getPoints();
		y = 600 / 2;
		x = 900 / 2;
		stars = lados / paso;
		double radi = (2 * Math.PI) / stars;

		pane.getChildren().add(polyline1);
		polyline1.setRotate(55);

		for (int i = 0; i < lados; i++) {
			lista.add(x + rad * Math.cos(i * radi));
			lista.add(y + rad * Math.sin(i * radi));
		}
	}

}
