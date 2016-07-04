package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BarChartTest {

    private TableView<Material> materialTable;

    @FXML
    private BarChart<String, Integer> bc;

    @FXML
    private CategoryAxis xAxis = new CategoryAxis();

    @FXML
    private NumberAxis yAxis = new NumberAxis();

    private MainApp mainApp = new MainApp();

    private ObservableList<String> materialIds = FXCollections.observableArrayList();
    private ObservableList<Material> materialz = FXCollections.observableArrayList();
    private TableView<Material> material;

    private MaterialOverviewController mvc = new MaterialOverviewController();


    Integer materialTotal = 0;
//    String stockId = selectedMaterial.getMaterialId();
//    Double width = selectedMaterial.getMaterialWidth();
//    materialTextField.setText(materialName + ", " + String.valueOf(width) + " inches");
//    for (Material id : mainApp.getMaterialData()) {
//        if (id.getMaterialWidth() == width && id.getMaterialId().equalsIgnoreCase(stockId)) {
//            materialTotal += id.getQtyOnFloor();
//        }
//        totalTextField.setText(String.valueOf(materialTotal));

    final static String austria = "14532";
    final static String brazil = "78333";
    final static String france = "40443";
    final static String italy = "72825";
    final static String usa = "72829";




    public void start(Stage stage) {


        stage.setTitle("Material On Floor");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Material On Floor");
        xAxis.setLabel("Material");
        yAxis.setLabel("Quantity");

//        setMainApp(mainApp);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("8 inch");

        for (Material id : mainApp.getMaterialData()) {
            Integer floorTotal =0;
            if (id.getMaterialWidth() > 6.9) {
//                floorTotal = id.getQtyOnFloor();
                for (Material size : mainApp.getMaterialData()) {
                    if (size.getMaterialId().equalsIgnoreCase(id.getMaterialId()) &&
                            size.getMaterialWidth() == id.getMaterialWidth()) {
                        floorTotal += size.getQtyOnFloor();
                    }
                }
            }
            series1.getData().add(new XYChart.Data(id.getMaterialId(), floorTotal));
        }

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("6 inch");

        for (Material id : mainApp.getMaterialData()) {
            Integer floorTotal =0;
            if (id.getMaterialWidth() < 6.9) {
                floorTotal = id.getQtyOnFloor();
                for (Material size : mainApp.getMaterialData()) {
                    if (size.getMaterialId().equalsIgnoreCase(id.getMaterialId()) &&
                            size.getMaterialWidth() == id.getMaterialWidth()) {
                        floorTotal += size.getQtyOnFloor();
                    }
                    else {
                        floorTotal = id.getQtyOnFloor();
                    }
                }
            }
            series2.getData().add(new XYChart.Data(id.getMaterialId(), floorTotal));
        }
////        for (Material id : mainApp.getMaterialData()) {
//        for (Material id : materialz) {
////            if (id.getMaterialWidth() > 6.9 ) {
//                series2.getData().add(new XYChart.Data(id.getMaterialId(), id.getQtyOnFloor()));
////            }
////            else {
////                series2.getData().add(new XYChart.Data(id.getMaterialId(), 0));
////            }
//        }
//        series2.getData().add(new XYChart.Data(austria, 3));
//        series2.getData().add(new XYChart.Data(brazil, 7));
//        series2.getData().add(new XYChart.Data(france, 7));
//        series2.getData().add(new XYChart.Data(italy, 10));
//        series2.getData().add(new XYChart.Data(usa, 5));

//        XYChart.Series series3 = new XYChart.Series();
//        series3.setName("Other");
//        for (Material id : materialz) {
//            if (id.getMaterialWidth() < 5.9 || id.getMaterialWidth() > 9.1) {
//                series3.getData().add(new XYChart.Data(id.getMaterialId(), id.getQtyOnFloor()));
//            }
//        }
//        series3.getData().add(new XYChart.Data(austria, 12));
//        series3.getData().add(new XYChart.Data(brazil, 4));
//        series3.getData().add(new XYChart.Data(france, 2));
//        series3.getData().add(new XYChart.Data(italy, 1));
//        series3.getData().add(new XYChart.Data(usa, 8));

//        XYChart.Series series4 = new XYChart.Series();
//        series4.setName("Other");
//        series4.getData().add(new XYChart.Data(austria, 6));
//        series4.getData().add(new XYChart.Data(brazil, 7));
//        series4.getData().add(new XYChart.Data(france, 9));
//        series4.getData().add(new XYChart.Data(italy, 2));
//        series4.getData().add(new XYChart.Data(usa, 3));


        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1, series2/*, series3*/);
        stage.setScene(scene);
        stage.show();
    }

//    public void setMainApp(MainApp mainApp) {
//        this.mainApp = mainApp;
//    }
}
