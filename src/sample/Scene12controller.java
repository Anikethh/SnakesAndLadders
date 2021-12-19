//package sample;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//// scene 1 controller
//
//public class Scene12controller {
//    public ImageView cover;
//    public ImageView player;
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
//
//    public void covertoplayer(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//    public void playertocover(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//
//}
