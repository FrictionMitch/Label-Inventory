package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.fxml.FXMLLoader;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import sample.MaterialOverviewController;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import com.sun.java.swing.action.CancelAction;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.scene.control.TableView;

/**
 *
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 *
 */
public class RootLayoutController {

    // Reference to the main application
    private MainApp mainApp;
    private MaterialOverviewController mMaterialOverviewController;
    public TableView<Material> material;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty material inventory.
     */
    @FXML
    private void handleNew() {
        mainApp.getMaterialData().clear();
        mainApp.setMaterialFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadMaterialDataFromFile(file);
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        File materialFile = mainApp.getMaterialFilePath();
        if (materialFile != null) {
            mainApp.saveMaterialDataToFile(materialFile);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("File Saved");
            alert.showAndWait();
        } else {
            handleSaveAs();
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveMaterialDataToFile(file);
        }
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Material Inventory");
        alert.setHeaderText("About");
        alert.setContentText("Version 1.2\n\nCreator: Mike Brisson\n\nMark can't say I've never given him anything :)");

        alert.showAndWait();
    }

    @FXML
    private void handleEdit() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Why would you click that?");
        alert.setHeaderText("You can't follow instructions very well");
        alert.setContentText("Was it worth it?");

        alert.showAndWait();
    }
//    @FXML
//    public void handlePrint(WritableImage writableImage, Stage primaryStage) {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("MaterialOverview.fxml"));
//        try {
//            AnchorPane frame = fxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        MaterialOverviewController c = fxmlLoader.getController();
//
//        //Loads data into table
//        c.setMainApp(mainApp);

        //Fit table to page
//        Rectangle rect = new Rectangle(0,0,c.getMaterialTable().getWidth(),c.getMaterialTable().getHeight());
//        c.getMaterialTable().setClip(rect);
//        writableImage = new WritableImage((int) c.getMaterialTable().getPrefWidth(),
//                (int) c.getMaterialTable().getPrefHeight());
//        c.getMaterialTable().snapshot(null, writableImage);
//        eventDispatcher.printLandscape(writableImage);

        //Fit table to page
//        ImageView imageView = new ImageView(writableImage);
//        Printer printer = Printer.getDefaultPrinter();
//        PageLayout pageLayout = printer.createPageLayout(Paper.NA_LETTER, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
//        double scaleX = pageLayout.getPrintableWidth() / imageView.getBoundsInParent().getWidth();
//        double scaleY = pageLayout.getPrintableHeight() / imageView.getBoundsInParent().getHeight();
//        imageView.getTransforms().add(new Scale(scaleX, scaleY));





        //Prints the fucker
//        PrinterJob printerJob = PrinterJob.createPrinterJob();

//        PrinterJob printerJob = PrinterJob.createPrinterJob();
//        if (printerJob != null) {
//            boolean successPrintDialog = printerJob.showPrintDialog(mainApp.getPrimaryStage().getOwner());
//            if(successPrintDialog){
//                boolean success = printerJob.printPage(pageLayout,imageView);
//                if (success) {
//                    printerJob.endJob();
//                }
//            }
//        }
//
//        if(printerJob.showPrintDialog(mainApp.getPrimaryStage().getOwner()) && printerJob.printPage(c.getMaterialTable()))
//            printerJob.endJob();
//    }

    @FXML
    private void handlePrint() {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MaterialOverview.fxml"));
        try {
            AnchorPane frame = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MaterialOverviewController c = fxmlLoader.getController();

        //Loads data into table
        c.setMainApp(mainApp);

        //Fit table to page
//        Rectangle rect = new Rectangle(0,0,c.getMaterialTable().getWidth(),c.getMaterialTable().getHeight());
//        c.getMaterialTable().setClip(rect);
//        WritableImage writableImage;
//        writableImage = new WritableImage((int) c.getMaterialTable().getPrefWidth(),
//                (int) c.getMaterialTable().getPrefHeight());
//        c.getMaterialTable().snapshot(null, writableImage);
//        EventDispatcher eventDispatcher = new EventDispatcher() {
//            @Override
//            public Event dispatchEvent(Event event, EventDispatchChain tail) {
//                return null;
//            }
//        };
//        eventDispatcher.printLandscape(writableImage);


//        ImageView imageView = new ImageView();
//        Printer printer = Printer.getDefaultPrinter();
//        PageLayout pageLayout = printer.createPageLayout(Paper.NA_LETTER, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
//        double scaleX = pageLayout.getPrintableWidth() / imageView.getBoundsInParent().getWidth();
//        double scaleY = pageLayout.getPrintableHeight() / imageView.getBoundsInParent().getHeight();
//        imageView.getTransforms().add(new Scale(scaleX, scaleY));

        //Prints the fucker
        PrinterJob printerJob = PrinterJob.createPrinterJob();

//        if(printerJob.showPrintDialog(mainApp.getPrimaryStage().getOwner()) && printerJob.printPage(c.getMaterialTable()))
//            printerJob.endJob();

        if (printerJob != null) {
            boolean showDialog = printerJob.showPrintDialog(mainApp.getPrimaryStage().getOwner());
//            boolean showDialog = printerJob.showPageSetupDialog(mainApp.getPrimaryStage().getOwner());
            if (showDialog) {
                c.getMaterialTable().setScaleX(0.72);
                c.getMaterialTable().setScaleY(1.0);
                c.getMaterialTable().setTranslateX(-94);
                c.getMaterialTable().setTranslateY(-0);
                boolean success = printerJob.printPage(c.getMaterialTable());
                if (success) {
                    printerJob.endJob();
                    showDialog=false;
                }
                c.getMaterialTable().setTranslateX(0);
                c.getMaterialTable().setTranslateY(0);
                c.getMaterialTable().setScaleX(1.0);
                c.getMaterialTable().setScaleY(1.0);
            }
            showDialog=false;
        }

    }


    @FXML
    private void handleShowMaterialStatistics() {
        mainApp.showMaterialStatistics();
    }

    @FXML
    private void handleShowOnFloorStats() {
        mainApp.showOnFloorStatistics();
    }

    @FXML
    private void handleShowBarChartTest() {
        mainApp.showBarChartTest();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Are you sure you want to exit without Saving?");
        alert.setContentText("Choose your option.");

        ButtonType buttonSave = new ButtonType("Save");
        ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType buttonExit = new ButtonType("Exit");

        alert.getButtonTypes().setAll(buttonSave, buttonCancel, buttonExit);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonSave){
            handleSaveAs();
        } else if (result.get() == buttonExit) {
            System.exit(0);

        } else if (result.get() == buttonCancel){
            alert.close();
        }

    }
}
