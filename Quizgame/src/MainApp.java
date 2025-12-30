import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        QuizController quiz = new QuizController();

        Scene scene = new Scene(quiz.createUI(), 400, 300);
        stage.setScene(scene);
        stage.setTitle("Quiz Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
