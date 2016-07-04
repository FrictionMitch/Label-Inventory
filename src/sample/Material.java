package sample;

import javafx.beans.property.*;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Model class for a Material.
 *
 */
public class Material {

    private final StringProperty pONumber;
    private final StringProperty materialId;
    private final StringProperty materialName;
    private final DoubleProperty materialWidth;
    private final IntegerProperty qtyOrdered;
    private final IntegerProperty qtyReceived;
    private final IntegerProperty qtyBackOrdered;
    private final IntegerProperty qtyOnFloor;
//    private final ObjectProperty<DatePicker> dateOrdered;
    private final ObjectProperty<LocalDate> dateOrdered;
    private final ObjectProperty<LocalDate> dateExpected;
    private final StringProperty supplier;
//    private final ObjectProperty<LocalDate> birthday;

//    private final ObjectProperty<DatePicker> date;

//    private final SimpleIntegerProperty materialId;
//    private final SimpleStringProperty materialName;
//    private final SimpleIntegerProperty materialSize;
//    private final SimpleIntegerProperty qtyOrdered;
//    private final SimpleIntegerProperty qtyBackOrdered;
//    private final SimpleIntegerProperty qtyOnFloor;

    /**
     * Default constructor.
     */
    public Material() {
        this(null, null, null, 0.0, 0, 0, 0, 0, null, null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param materialName
     * @param materialId
     */
    public Material(String pONumber, String materialName, String materialId, Double materialWidth, Integer qtyOrdered,
                    Integer qtyReceived, Integer qtyBackOrdered, Integer qtyOnFloor, String supplier,
                    LocalDate dateOrdered, LocalDate dateExpected) {

//        Integer total = qtyOrdered - qtyReceived
        this.pONumber = new SimpleStringProperty(pONumber);
        this.materialName = new SimpleStringProperty(materialName);
        this.materialId = new SimpleStringProperty(materialId);
        this.materialWidth = new SimpleDoubleProperty(materialWidth);
        this.qtyOrdered = new SimpleIntegerProperty(qtyOrdered);
        this.qtyReceived = new SimpleIntegerProperty(qtyReceived);
        this.qtyBackOrdered = new SimpleIntegerProperty(qtyBackOrdered);
//        this.qtyBackOrdered = new SimpleIntegerProperty(qtyBackOrdered);
        this.qtyOnFloor = new SimpleIntegerProperty(qtyOnFloor);
        this.dateOrdered = new SimpleObjectProperty(dateOrdered);
        this.dateExpected = new SimpleObjectProperty(dateExpected);
        this.supplier = new SimpleStringProperty(supplier);
//        this.dateExpected = new SimpleObjectProperty<LocalDate>(LocalDate.of(2016, 2, 21));
//        this.dateOrdered = new SimpleObjectProperty<DatePicker>();
//        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));

        // Some initial dummy data, just for convenient testing.
//        this.materialWidth = new SimpleDoubleProperty(9);
//        this.city = new SimpleStringProperty("some city");
    }

//    public Material (Integer materialId, String name, Integer size, Integer qty, Integer backOrdered,
//                   Integer onFloor/*, Date date, Date arrival*/) {
//        this.materialId = new SimpleIntegerProperty(materialId);
//        this.materialName = new SimpleStringProperty(name);
//        this.materialSize = new SimpleIntegerProperty(size);
//        this.qtyOrdered = new SimpleIntegerProperty(qty);
//        this.qtyBackOrdered = new SimpleIntegerProperty(backOrdered);
//        this.qtyOnFloor = new SimpleIntegerProperty(onFloor);
//        /*dateOrdered = new SimpleObjectProperty<>(date);
//        estArrival = new SimpleObjectProperty<>(arrival);*/
//    }


//    public String getPONumber() {
//        return pONumber.get();
//    }
//
//    public void setPONumber(String pONumber) {
//        this.pONumber.set(pONumber);
//    }
//
//    public StringProperty pONumberProperty() {
//        return pONumber;
//    }


    public String getPoNumber() {
        return pONumber.get();
    }
    public void setPoNumber(String pONumber) {
        this.pONumber.set(pONumber);
    }
    public StringProperty pONumberProperty() {
        return pONumber;
    }

    public String getMaterialName() {
        return materialName.get();
    }

    public void setMaterialName(String materialName) {
        this.materialName.set(materialName);
    }

    public StringProperty materialNameProperty() {
        return materialName;
    }

    public String getMaterialId() {
        return materialId.get();
    }

    public void setMaterialId(String materialId) {
        this.materialId.set(materialId);
    }

    public StringProperty materialIdProperty() {
        return materialId;
    }

    public double getMaterialWidth() {
        return materialWidth.get();
    }

    public DoubleProperty materialWidthProperty() {
        return materialWidth;
    }

    public void setMaterialWidth(double materialWidth) {
        this.materialWidth.set(materialWidth);
    }

    public int getQtyOrdered() {
        return qtyOrdered.get();
    }

    public IntegerProperty qtyOrderedProperty() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered.set(qtyOrdered);
    }

    public int getQtyReceived() {
        return qtyReceived.get();
    }

    public IntegerProperty qtyReceivedProperty() {
        return qtyReceived;
    }

    public void setQtyReceived(int qtyReceived) {
        this.qtyReceived.set(qtyReceived);
    }

    public int getQtyBackOrdered() {
        return qtyOrdered.get();
    }

    public IntegerProperty qtyBackOrderedProperty() {
        return qtyBackOrdered;
    }

    public void setQtyBackOrdered(int qtyBackOrdered) {
        this.qtyBackOrdered.set(qtyBackOrdered);
    }

//    public int getQtyBackOrdered() {
//        return qtyBackOrdered.get();
//    }
//
//    public IntegerProperty qtyBackOrderedProperty() {
//        return qtyBackOrdered;
//    }
//
//    public void setQtyBackOrdered(int qtyBackOrdered) {
//        this.qtyBackOrdered.set(qtyBackOrdered);
//    }

    public int getQtyOnFloor() {
        return qtyOnFloor.get();
    }

    public IntegerProperty qtyOnFloorProperty() {
        return qtyOnFloor;
    }

    public void setQtyOnFloor(int qtyOnFloor) {
        this.qtyOnFloor.set(qtyOnFloor);
    }

//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
//    public LocalDate getBirthday() {
//        return dateOrdered.get();
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.dateOrdered.set(birthday);
//    }
//
//    public ObjectProperty<LocalDate> birthdayProperty() {
//        return dateOrdered;
//    }
//    public LocalDate getDateOrdered() {
//        return dateOrdered.get();
//    }
//
//    public ObjectProperty<LocalDate> dateOrderedProperty() {
//        return dateOrdered;
//    }
//
//    public void setDateOrdered(LocalDate dateOrdered) {
//        this.dateOrdered.set(dateOrdered);
//    }

    //    public DatePicker getDateOrdered() {
//        return dateOrdered.get();
//    }
//
//    public StringProperty dateOrderedProperty() {
//        return dateOrdered.toStringProperty();
//    }
//
//    public void setDateOrdered(String dateOrdered) {
//        this.dateOrdered.set(dateOrdered);
//    }


    public String getSupplier() {
        return supplier.get();
    }

    public StringProperty supplierProperty() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }

//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
//    public LocalDate getBirthday() {
//        return birthday.get();
//    }
//
//    public ObjectProperty<LocalDate> birthdayProperty() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday.set(birthday);
//    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDateOrdered() {
        return dateOrdered.get();
    }

    public ObjectProperty<LocalDate> dateOrderedProperty() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered.set(dateOrdered);
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDateExpected() {
        return dateExpected.get();
    }

    public ObjectProperty<LocalDate> dateExpectedProperty() {
        return dateExpected;
    }

    public void setDateExpected(LocalDate dateExpected) {
        this.dateExpected.set(dateExpected);
    }



    //    @XmlJavaTypeAdapter(LocalDateAdapter.class)
//    public DatePicker getDateOrdered() {
//        return dateOrdered.get();
//    }
//
//    public ObjectProperty<DatePicker> dateOrderedProperty() {
//        return dateOrdered;
//    }
//
//    public void setDateOrdered(DatePicker dateOrdered) {
//        this.dateOrdered.set(dateOrdered);
//    }
}
