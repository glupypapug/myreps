import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	private enum drawingModes{
		pixel,
		circle,
		square
	}
	
	static drawingModes mode;
	private static double previousX;
	private static double previousY;

	public static void main(String[] args) {
		mode = drawingModes.pixel;
		launch (args); 
	}

	@Override 
	public void start(Stage primaryStage){
		
		VBox myBox = new VBox();
		
		MenuBar menu1 = new MenuBar();
		Menu file  = new Menu ("File");
		menu1.getMenus().add(file);
		menu1.autosize();
		
		ToolBar toolBar = new ToolBar();
		 Button brush = new Button("Brush");
		 brush.setOnAction(new EventHandler<ActionEvent>() {
			 
	            @Override
	            public void handle(ActionEvent event) {
	            	mode = drawingModes.pixel;
	            }
	        });
		 
		 Button rectangle = new Button("Rectangle");
		 rectangle.setOnAction(new EventHandler<ActionEvent>() {
			 
	            @Override
	            public void handle(ActionEvent event) {
	            	mode = drawingModes.square;
	            }
	        });
		 
		 toolBar.getItems().add(rectangle);
	     toolBar.getItems().add(brush);
		
		
		 Canvas canvas = new Canvas(600, 600);
	        GraphicsContext gc = canvas.getGraphicsContext2D();
	        canvas.autosize();
	    	gc.clearRect(0, 0, 600, 500);
	    //	gc.fillOval(10, 20,30, 40);
			
			
			

		StackPane ben = new StackPane(); 
		Scene scene = new Scene(myBox, 800,600);
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		     //   System.out.println("mouse click detected! " + mouseEvent.getSceneX()+" "+ mouseEvent.getSceneY());
		      if (mode == drawingModes.pixel) {
		    	  gc.fillRect(mouseEvent.getSceneX(), mouseEvent.getSceneY()-menu1.getHeight()-toolBar.getHeight(), 1, 1);
		      }
		      else if (mode==drawingModes.square) {
		    	  previousX= mouseEvent.getSceneX();
		    	  previousY = mouseEvent.getSceneY()-menu1.getHeight()-toolBar.getHeight();
		      }
		    	
		    }
		});
		
		scene.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		      //  System.out.println("mouse click detected! " + mouseEvent.getSceneX()+" "+ mouseEvent.getSceneY());
		    	if (mode==drawingModes.square) {
		    		gc.fillRect(previousX, previousY, mouseEvent.getSceneX()-previousX,mouseEvent.getSceneY()-previousY-menu1.getHeight()-toolBar.getHeight());
		    	}
		    	
		    }
		});
		
		
		((VBox)scene.getRoot()).getChildren().addAll(menu1,toolBar,canvas);
		primaryStage.setScene(scene); 
		primaryStage.show();
	
	}


	
}
