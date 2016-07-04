package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;
import java.util.List;

public class MaterialOverviewController {
    @FXML
    private TableView<Material> materialTable;
    @FXML
    private TableColumn<Material, String> pONumberColumn;
    @FXML
    private TableColumn<Material, String> materialNameColumn;
    @FXML
    private TableColumn<Material, String> materialIdColumn;
    @FXML
    private TableColumn<Material, Double> materialWidthColumn;
    @FXML
    private TableColumn<Material, Integer> qtyOrderedColumn;
    @FXML
    private TableColumn<Material, Integer> qtyReceivedColumn;
    @FXML
    private TableColumn<Material, Integer> qtyBackOrderedColumn;
    @FXML
    private TableColumn<Material, Integer> qtyOnFloorColumn;
//    @FXML
//    private TableColumn<Material, DatePicker> dateOrderedColumn;
//    @FXML
//    private TableColumn<Material, DatePicker> estArrivalColumn;
    @FXML
    private TableColumn<Material, String> dateOrderedColumn;
    @FXML
    private TableColumn<Material, String> estArrivalColumn;
    @FXML
    private TableColumn<Material, String> supplierColumn;



    @FXML
    private TextField pONumberLabel;
    @FXML
    private TextField materialIdLabel;
    @FXML
    private TextField materialNameLabel;
    @FXML
    private TextField materialWidthLabel;
    @FXML
    private TextField qtyOrderedLabel;
    @FXML
    private TextField qtyRecievedLabel;
    @FXML
    private TextField qtyBackOrderedLabel;
    @FXML
    private TextField estArrivalLabel;
    @FXML
    private TextField qtyOnFloorLabel;
    @FXML
    private TextField supplierLabel;
    @FXML
    private TextField dateOrderedLabel;
    @FXML
    private TextField totalTextField;
    @FXML
    private TextField materialTextField;
    private int materialTotal;
    private String materialName;

    private List<Material> materialId;

    public TableView<Material> getMaterialTable() {
        return materialTable;
    }

//    public void setMaterialTable(TableView<Material> materialTable) {
//        this.materialTable = materialTable;
//    }

    private ObservableList<Integer> rollsTotal = FXCollections.observableArrayList();
    private ObservableList<String> materialNames = FXCollections.observableArrayList();



    // Reference to the main application.
    private MainApp mainApp;

    public MainApp getMainApp() {
        return mainApp;
    }

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MaterialOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        materialTotal = 0;
        // Initialize the material table with columns.
        pONumberColumn.setCellValueFactory(cellData -> cellData.getValue().pONumberProperty());
        materialNameColumn.setCellValueFactory(cellData -> cellData.getValue().materialNameProperty());
        materialIdColumn.setCellValueFactory(cellData -> cellData.getValue().materialIdProperty());
        materialWidthColumn.setCellValueFactory(cellData -> cellData.getValue().materialWidthProperty().asObject());
        qtyOrderedColumn.setCellValueFactory(cellData -> cellData.getValue().qtyOrderedProperty().asObject());
        qtyReceivedColumn.setCellValueFactory(cellData -> cellData.getValue().qtyReceivedProperty().asObject());
        qtyBackOrderedColumn.setCellValueFactory(cellData -> cellData.getValue().qtyBackOrderedProperty().asObject());
//        qtyBackOrderedColumn.setCellValueFactory(cellData -> cellData.getValue().qtyBackOrderedProperty().asObject());
        qtyOnFloorColumn.setCellValueFactory(cellData -> cellData.getValue().qtyOnFloorProperty().asObject());
//        dateOrderedColumn.setCellValueFactory(cellData -> cellData.getValue().dateOrderedProperty().asString());
        dateOrderedColumn.setCellValueFactory(cellData -> cellData.getValue().dateOrderedProperty().asString());
        estArrivalColumn.setCellValueFactory(cellData -> cellData.getValue().dateExpectedProperty().asString());
        supplierColumn.setCellValueFactory(cellData -> cellData.getValue().supplierProperty());

        // Clear material details.
        showMaterialDetails(null);

        // Listen for selection changes and show the material details when changed.
        materialTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMaterialDetails(newValue));

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        materialTable.setItems(mainApp.getMaterialData());
    }

    private void showMaterialDetails(Material material) {
        if (material != null) {
            // Fill the labels with info from the material object.
            pONumberLabel.setText(material.getPoNumber());
            materialIdLabel.setText(material.getMaterialId());
            materialNameLabel.setText(material.getMaterialName());
            materialWidthLabel.setText(String.valueOf(material.getMaterialWidth()));
            qtyOrderedLabel.setText(Integer.toString(material.getQtyOrdered()));
            qtyRecievedLabel.setText(Integer.toString(material.getQtyReceived()));
            qtyBackOrderedLabel.setText(Integer.toString(material.getQtyOrdered()-material.getQtyReceived()));
//            qtyBackOrderedLabel.setText(Integer.toString(material.getQtyBackOrdered()));
            qtyOnFloorLabel.setText(Integer.toString(material.getQtyOnFloor()));
//            dateOrderedLabel.setText(DateUtil.format(material.getDateOrdered()));
//            dateOrderedLabel.equals(DateUtil.format(material.getDateOrdered()));
//            dateOrderedLabel.setText(DatePicker(String.valueOf(material.getDateOrdered());
//            estArrivalLabel.setText(material.getSupplier());
            supplierLabel.setText(material.getSupplier());

            String pattern = "MM/dd/yyyy";
//            dateTestTextField.setText(DateUtil.format(material.getBirthday()));
            dateOrderedLabel.setText(DateUtil.format(material.getDateOrdered()));
            estArrivalLabel.setText(DateUtil.format(material.getDateExpected()));
            //TODO: set running material totals
//            getMaterialNames(Arrays.asList(material));
            handleSelectMaterial();

        } else {
            // Material is null, remove all the text.
            pONumberLabel.setText("");
            materialIdLabel.setText("");
            materialNameLabel.setText("");
            materialWidthLabel.setText("");
            qtyOrderedLabel.setText("");
            qtyRecievedLabel.setText("");
            qtyBackOrderedLabel.setText("");
            qtyOnFloorLabel.setText("");
            dateOrderedLabel.setText("");
            estArrivalLabel.setText("");
            supplierLabel.setText("");
//            dateOrderedLabel.setText("");


//            dateOrderedLabel.setConverter();
//            estArrivalLabel.setText("");
//            dateOrderedLabel.setText("");
        }
    }

    @FXML
    private void handleDeleteMaterial() {
//        int selectedIndex = materialTable.getSelectionModel().getSelectedIndex();
//        materialTable.getItems().remove(selectedIndex);
        int selectedIndex = materialTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            materialTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Material Selected");
            alert.setContentText("Please select an order in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewMaterial() {
        Material tempMaterial = new Material();
        boolean okClicked = mainApp.showMaterialEditDialog(tempMaterial);
        if (okClicked) {
            mainApp.getMaterialData().add(tempMaterial);
        }
    }

    @FXML
    private void handleEditMaterial() {
        Material selectedMaterial = materialTable.getSelectionModel().getSelectedItem();
        if (selectedMaterial != null) {
            boolean okClicked = mainApp.showMaterialEditDialog(selectedMaterial);
            if (okClicked) {
                showMaterialDetails(selectedMaterial);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Material Selected");
            alert.setContentText("Please select a material in the table.");

            alert.showAndWait();
        }
    }

//    public List<Material> getMaterialIds() {
//        for (Material id : materialId)
//        return Arrays.asList(id.getMaterialId());
//    }

    public void setMaterialTotal(List<Material> materials) {
        // Count the number of people having their birthday in a specific month.
//        int[] monthCounter = new int[12];
        Material[] matId = new Material[20];
        for (Material m : materials) {
            Integer id = Integer.parseInt(m.getMaterialId());
//            qty = m.getQtyBackOrdered();
//            monthCounter[qty]++;
            materialId.add(matId[id]);
        }
        for (Material id : materialId)
            materialTextField.setText(String.valueOf(id)+"%n");
    }

    public Integer getTotals () {
        return null;
    }

//    public List<String> getMaterialId() {
//        Material material = new Material();
////        String[] ids = material.split("[^\\w_']+");
//        for (String id : material.getMaterialName() {
//            return Arrays.asList(materialId);
//        }
//    }

//    public void setMaterialTotals(List<Material> materials) {
//        int[] materialTotal = new int[12];
//        for (Material total : materials) {
//            total = total.getDateOrdered().getMonthValue() - 1;
//            qty = m.getQtyBackOrdered();
////            monthCounter[qty]++;
//            monthCounter[month]++;
//        }


//    public boolean materialId(Material id) {
//        List<Material> materialId = new ArrayList<Material>();
//
//        return materialId.add(id);
//    }

    public List getMaterialNames(List<Material> materials) {

        for (Material name : materials) {
            mainApp.getMaterialData();
            if (!materialNames.contains(name)) {
                materialNames.add(name.getMaterialName());
            }
        }
        for (String name : materialNames) {
            materialTextField.setText(name + "\n");
        }
        return Arrays.asList(materialNames);
    }

    @FXML
    private void handleSelectMaterial() {
        Material selectedMaterial = materialTable.getSelectionModel().getSelectedItem();
        if (selectedMaterial != null) {
            materialTotal = 0;
            String stockId = selectedMaterial.getMaterialId();
            materialName = selectedMaterial.getMaterialName();
            Double width = selectedMaterial.getMaterialWidth();
            materialTextField.setText(materialName + ", " + String.valueOf(width) + " inches");
            for (Material id : mainApp.getMaterialData()) {
                if (id.getMaterialWidth() == width && id.getMaterialId().equalsIgnoreCase(stockId)) {
                    materialTotal += id.getQtyOnFloor();
                }
                    totalTextField.setText(String.valueOf(materialTotal));
            }
        }
    }

}