import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import java.sql.*;
import java.util.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;


public class QuizController {

    private List<Question> questions = new ArrayList<>();
    private int index = 0;
    private int score = 0;
    private int timeLeft = 15;

    private Label questionLabel = new Label();
    private Label timerLabel = new Label("Time: 15");
    private Button btnA = new Button();
    private Button btnB = new Button();
    private Button btnC = new Button();
    private Button btnD = new Button();
    private Button exitBtn = new Button("Exit");
    private Button restartBtn = new Button("Restart");

    private Timeline timer;

    public Parent createUI() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        btnA.setOnAction(e -> checkAnswer('A'));
        btnB.setOnAction(e -> checkAnswer('B'));
        btnC.setOnAction(e -> checkAnswer('C'));
        btnD.setOnAction(e -> checkAnswer('D'));
        exitBtn.setOnAction(e -> Platform.exit());
        restartBtn.setOnAction(e -> restartQuiz());

        root.getChildren().addAll(
                timerLabel,
                questionLabel,
                btnA, btnB, btnC, btnD
                ,exitBtn,restartBtn
        );

        loadQuestions();
        showQuestion();
        startTimer();

        return root;
    }

    private void showQuestion() {
        if (index >= questions.size()) return;

        Question q = questions.get(index);
        questionLabel.setText(q.question);
        btnA.setText("A. " + q.a);
        btnB.setText("B. " + q.b);
        btnC.setText("C. " + q.c);
        btnD.setText("D. " + q.d);
        timerLabel.setText("Time: " + timeLeft);
    }
    public void loadQuestions() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM questions ORDER BY RAND() LIMIT 5"
            );

            while (rs.next()) {
                Question q = new Question();
                q.id = rs.getInt("id");
                q.question = rs.getString("question");
                q.a = rs.getString("optionA");
                q.b = rs.getString("optionB");
                q.c = rs.getString("optionC");
                q.d = rs.getString("optionD");
                q.correct = rs.getString("correctOption").charAt(0);
                questions.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Questions loaded = " + questions.size());

    }

    public void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft);

            if (timeLeft == 0) {
                nextQuestion();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void checkAnswer(char selected) {
        if (questions.get(index).correct == selected) {
            score++;
        }
        nextQuestion();
    }

    public void nextQuestion() {
        timeLeft = 15;
        index++;

        if (index == questions.size()) {
            timer.stop();
            questionLabel.setText("Finished! Score: " + score);
            btnA.setDisable(true);
            btnB.setDisable(true);
            btnC.setDisable(true);
            btnD.setDisable(true);
            saveScore("Player", score);
        } else {
            showQuestion();
        }
    }
    private void restartQuiz() {
        if (timer != null) timer.stop();

        index = 0;
        score = 0;
        timeLeft = 15;

        btnA.setDisable(false);
        btnB.setDisable(false);
        btnC.setDisable(false);
        btnD.setDisable(false);

        restartBtn.setDisable(true);

        loadQuestions();

        if (!questions.isEmpty()) {
            showQuestion();
            startTimer();
        }
    }

    public void saveScore(String name, int score) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO scores VALUES (NULL, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, score);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
