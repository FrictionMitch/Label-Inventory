package sample;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import sample.Material;

/**
 * The controller for the month statistics view.
 *
 */
public class MaterialStatisticsController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    private ObservableList<String> materialNames = FXCollections.observableArrayList();


    public int qty = 0;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Get an array with the English month names.

        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();

        // Convert it to a list and add it to our ObservableList of months.
        monthNames.addAll(Arrays.asList(months));

        // Assign the month names as categories for the horizontal axis.
        xAxis.setCategories(monthNames);


    }

    /**
     * Sets the materials to show the statistics for.
     *
     * @param materials
     */
    public void setMaterialData(List<Material> materials) {
        // Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
        for (Material m : materials) {
            int month = m.getDateOrdered().getMonthValue() - 1;
            qty = m.getQtyBackOrdered();
//            monthCounter[qty]++;
            monthCounter[month]++;
        }


        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }

        barChart.getData().add(series);
    }

    public void getMonths(List<Material> names) {
        for (Material name : names) {
            materialNames.add(name.getMaterialName());
        }
    }
}