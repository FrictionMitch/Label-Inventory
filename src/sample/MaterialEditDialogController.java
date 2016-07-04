package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;

public class MaterialEditDialogController {
    @FXML
    private TextField pONumberEditTextField;
    @FXML
    private TextField materialIdEditTextField;
    @FXML
    private TextField materialNameEditTextField;
    @FXML
    private TextField materialWidthEditTextField;
    @FXML
    private TextField qtyOrderedEditTextField;
    @FXML
    private TextField qtyReceivedEditTextField;
    @FXML
    private TextField qtyBackOrderedEditTextField;
    @FXML
    private TextField qtyOnFloorEditTextField;
//    @FXML
//    private TextField dateOrderedEditTextField;

    @FXML
    private DatePicker dateOrderedEditDatePicker;
    @FXML
    private DatePicker estArrivalEditDatePicker;
//    @FXML
//    private TextField estArrivalEditTextField;
    @FXML
    private TextField supplierEditTextField;
    private LocalDate dateExpected;


    private Stage dialogStage;
    private Material mMaterial;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the mMaterial to be edited in the dialog.
     *
     * @param material
     */
    public void setMaterial(Material material) {
        this.mMaterial = material;

        pONumberEditTextField.setText(material.getPoNumber());
        materialIdEditTextField.setText(material.getMaterialId());
        materialNameEditTextField.setText(material.getMaterialName());
        materialWidthEditTextField.setText(String.valueOf(material.getMaterialWidth()));
        qtyOrderedEditTextField.setText(Integer.toString(material.getQtyOrdered()));
        qtyReceivedEditTextField.setText(Integer.toString(material.getQtyReceived()));
        qtyBackOrderedEditTextField.setText(Integer.toString(material.getQtyBackOrdered()));
        qtyOnFloorEditTextField.setText(Integer.toString(material.getQtyOnFloor()));
//        dateOrderedEditTextField.setText(mMaterial.getCity());
//        estArrivalEditTextField.setText(mMaterial.getCity());
        supplierEditTextField.setText(material.getSupplier());
//        dateOrderedEditTextField.setPromptText("mm/dd/yyyy");
        dateOrderedEditDatePicker.setPromptText("mm/dd/yyyy");
//        estArrivalEditTextField.setPromptText("mm/dd/yyyy");
        dateOrderedEditDatePicker.setValue(mMaterial.getDateOrdered());
//        dateOrderedEditTextField.setText(DateUtil.format(mMaterial.getDateOrdered()));
        estArrivalEditDatePicker.setPromptText("mm/dd/yyyy");
        estArrivalEditDatePicker.setValue(mMaterial.getDateExpected());
//        estArrivalEditTextField.setText(DateUtil.format(mMaterial.getDateExpected()));
//        estArrivalEditDatePicker.setValue((LocalDate.of(2016, 3, 16)));
//        estArrivalEditDatePicker.setText(DateUtil.format(mMaterial.getDateOrdered()));
//        dateExpected = mMaterial.getDateExpected();
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            mMaterial.setPoNumber(pONumberEditTextField.getText());
            mMaterial.setMaterialId(materialIdEditTextField.getText());
            mMaterial.setMaterialName(materialNameEditTextField.getText());
            mMaterial.setMaterialWidth(Double.parseDouble(materialWidthEditTextField.getText()));
            mMaterial.setQtyOrdered(Integer.parseInt(qtyOrderedEditTextField.getText()));
            mMaterial.setQtyReceived(Integer.parseInt(qtyReceivedEditTextField.getText()));
            mMaterial.setQtyBackOrdered(Integer.parseInt(qtyOrderedEditTextField.getText())-Integer.parseInt(qtyReceivedEditTextField.getText()));
//            mMaterial.setQtyBackOrdered(Integer.parseInt(qtyBackOrderedEditTextField.getText()));
            mMaterial.setQtyOnFloor(Integer.parseInt(qtyOnFloorEditTextField.getText()));
            mMaterial.setSupplier(supplierEditTextField.getText());
            mMaterial.setDateOrdered(dateOrderedEditDatePicker.getValue());
//            mMaterial.setDateOrdered(DateUtil.parse(dateOrderedEditTextField.getText()));
            mMaterial.setDateExpected(estArrivalEditDatePicker.getValue());
//            mMaterial.setDateExpected(DateUtil.parse(estArrivalEditTextField.getText()));
//            LocalDate localDate = estArrivalEditDatePicker.getValue();
//            String date = localDate.toString();
//            mMaterial.setDateExpected(DateUtil.parse(localDate.toString()));
//            mMaterial.setDateExpected(DateUtil.parse(date));
//            mMaterial.setDateExpected(DateUtil.parse(dateExpected.toString()));
//            mMaterial.setDateExpected(DateUtil.parse(localDate.toString()));


            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (pONumberEditTextField.getText() == null || pONumberEditTextField.getText().length() == 0) {
            errorMessage += "No PO Number!\n";
        }

        if (materialIdEditTextField.getText() == null || materialIdEditTextField.getText().length() == 0) {
            errorMessage += "No material ID!\n";
        }
        if (materialNameEditTextField.getText() == null || materialNameEditTextField.getText().length() == 0) {
            errorMessage += "No valid material name!\n";
        }
        if (materialWidthEditTextField.getText().toString() == null || materialWidthEditTextField.getText().length() == 0) {
            errorMessage += "No valid width!\n";
        }

        if (qtyOrderedEditTextField.getText() == null || qtyOrderedEditTextField.getText().length() == 0) {
            errorMessage += "No valid ordered quantity!\n";
        }

//        if (qtyBackOrderedEditTextField.getText() == null || qtyBackOrderedEditTextField.getText().length() == 0) {
//            errorMessage += "No valid quantity!\n";
//        }

        if (qtyOnFloorEditTextField.getText() == null || qtyOnFloorEditTextField.getText().length() == 0) {
            errorMessage += "No valid on floor quantity!\n";
        }

//        if (qtyOnFloorEditTextField.getText() == null || qtyOnFloorEditTextField.getText().length() == 0) {
//            errorMessage += "No valid street!\n";
//        }
//
//        if (qtyOnFloorEditTextField.getText() == null || qtyOnFloorEditTextField.getText().length() == 0) {
//            errorMessage += "No valid street!\n";
//        }

        if (supplierEditTextField.getText() == null || supplierEditTextField.getText().length() == 0) {
            errorMessage += "No valid supplier!\n";
        }



//        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//            errorMessage += "No valid postal code!\n";
//        } else {
//            // try to parse the postal code into an int.
//            try {
//                Integer.parseInt(postalCodeField.getText());
//            } catch (NumberFormatException e) {
//                errorMessage += "No valid postal code (must be an integer)!\n";
//            }
//        }


        if (dateOrderedEditDatePicker.getValue() == null) {
//            errorMessage += "No valid date ordered entry!\n";
            dateOrderedEditDatePicker.setValue(LocalDate.now());
//            mMaterial.setDateOrdered(DateUtil.parse(dateOrderedEditTextField.getText()));
//            mMaterial.setDateOrdered(DateUtil.parse(String.valueOf(LocalDate.now())));
//        } else {
//            if (!DateUtil.validDate(dateOrderedEditTextField.getText())) {
//                errorMessage += "No valid date ordered. Use the format mm/dd/yyyy!\n";
//            }
        }

        if (estArrivalEditDatePicker.getValue() == null) {
//            errorMessage += "No valid date expected entry!\n";
            estArrivalEditDatePicker.setValue(LocalDate.now().plusDays(7));
        } /*else {
            if (!DateUtil.validDate(dateOrderedEditTextField.getText())) {
                errorMessage += "No valid date expected. Use the format mm/dd/yyyy!\n";
            }
        } */


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
