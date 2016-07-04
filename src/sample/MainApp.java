package sample;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class MainApp extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("MaterialOverview.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.prefs.Preferences;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Material> materialData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Label Inventory");
        this.primaryStage.getIcons().add(new Image("file:resources/images/1462487405_Mask.png"));

        initRootLayout();

        showMaterialOverview();
    }

    public MainApp() {
        // Add some sample data
        materialData.add(new Material("22222", "Matte", "14532", 9.0, 5, 5, 0, 1, "Avery", LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("22222", "Matte", "14532", 9.0, 5, 5, 0, 3, "Avery", LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("22222", "Matte", "14532", 6.75, 5, 5, 0, 7, "Avery", LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("123456", "Chrome", "72824", 9.0, 8, 5, 0, 6, "Avery", LocalDate.of(2016, 1, 12), LocalDate.of(2016, 1, 12)));
        materialData.add(new Material("333", "Clear", "72829", 8.75, 8, 3, 0, 2, "Avery", LocalDate.of(2016, 2, 16), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("123456", "Dull Silver", "72826", 9.0, 1, 1, 0, 1, "Avery", LocalDate.of(2016, 2, 26), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("789", "Super Tac", "40443", 8.5, 10, 7, 0, 9, "Avery", LocalDate.of(2016, 3, 16), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("123456", "Bopp", "78333", 8.5, 5, 4, 0, 4, "Wassau", LocalDate.of(2016, 3, 16), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("5555", "Matte Lam", "814M", 5.75, 12, 2, 0, 2, "Avery", LocalDate.of(2016, 4, 16), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("123456", "Clear Lam", "815C", 8.0, 5, 3, 0, 3, "Avery", LocalDate.of(2016, 5, 16), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("777", "Fluo Green", "15283", 9.0, 0, 6, 0, 6, "Avery", LocalDate.of(2016, 6, 16), LocalDate.of(2016, 1, 1)));
        materialData.add(new Material("123456", "Semi Gloss", "43393", 9.0, 0, 4, 0, 5, "Unisource", LocalDate.of(2016, 7, 16), LocalDate.of(2016, 1, 1)));


    }

    public ObservableList<Material> getMaterialData() {
        return materialData;
    }

    /**
     * Initializes the root layout and tries to load the last opened
     * person file.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try to load last opened person file.
        File file = getMaterialFilePath();
        if (file != null) {
            loadMaterialDataFromFile(file);
        }
    }

    /**
     * Original
     * Initializes the root layout.
     */
//    public void initRootLayout() {
//        try {
//            // Load root layout from fxml file.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
//            rootLayout = (BorderPane) loader.load();
//
//            // Show the scene containing the root layout.
//            Scene scene = new Scene(rootLayout);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Shows the material overview inside the root layout.
     */
//    public void showMaterialOverview() {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("MaterialOverview.fxml"));
//            AnchorPane personOverview = (AnchorPane) loader.load();
//
//            // Set person overview into the center of root layout.
//            rootLayout.setCenter(personOverview);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void showMaterialOverview() {
        try {
            // Load material overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MaterialOverview.fxml"));
            AnchorPane materialOverview = (AnchorPane) loader.load();

            // Set material overview into the center of root layout.
            rootLayout.setCenter(materialOverview);

            // Give the controller access to the main app.
            MaterialOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showMaterialEditDialog(Material material) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MaterialEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Material");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the material into the controller.
            MaterialEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMaterial(material);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public File getMaterialFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setMaterialFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("MaterialApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("MaterialApp");
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     *
     * @param file
     */
    public void loadMaterialDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(MaterialListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            MaterialListWrapper wrapper = (MaterialListWrapper) um.unmarshal(file);

            materialData.clear();
            materialData.addAll(wrapper.getMaterials());

            // Save the file path to the registry.
            setMaterialFilePath(file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    /**
     * Saves the current person data to the specified file.
     *
     * @param file
     */
    public void saveMaterialDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(MaterialListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            MaterialListWrapper wrapper = new MaterialListWrapper();
            wrapper.setMaterials(materialData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setMaterialFilePath(file);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public void showMaterialStatistics() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MaterialStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Material Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the persons into the controller.
            MaterialStatisticsController controller = loader.getController();
            controller.setMaterialData(getMaterialData());

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOnFloorStatistics() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("OnFloorStats.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Material On Floor");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the material into the controller.
            OnFloorStatsController controller = loader.getController();
            controller.start(dialogStage);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBarChartTest() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("BarChartTestLayout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Detailed Bar Chart");

//
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the material into the controller.
            BarChartTest controller = loader.getController();
            controller.start(dialogStage);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
