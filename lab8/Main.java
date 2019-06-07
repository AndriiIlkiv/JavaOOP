package lab8;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;


public class Main extends Application {
    public Shop shop;
    private Desktop desktop = Desktop.getDesktop();
    private ObservableList<Shop> shops = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Ticket Box");

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select XML file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        TableView<Shop> table = new TableView<>(shops);
        table.prefHeightProperty().bind(primaryStage.heightProperty());
        //TableColumn<Shop> idColumn = new TableColumn<Shop("Number");
        //idColumn.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("number"));
        //idColumn.prefWidthProperty().bind(table.widthProperty().divide(2.05));
        //table.getColumns().add(idColumn);
        TableColumn<Shop, String> nameColumn = new TableColumn<>("Station");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Shop, String>("station"));
        nameColumn.prefWidthProperty().bind(table.widthProperty());
        table.getColumns().add(nameColumn);

        ScrollPane sp = new ScrollPane();
        sp.setPadding(new Insets(10));
        Button add_btn = new Button("Add station");
        Button delete_btn = new Button("Delete station");
        Button get_btn = new Button("Deserealize");
        Button put_btn = new Button("Serealize");
        HBox buttons = new HBox(add_btn,delete_btn,get_btn,put_btn);
        VBox hb = new VBox();
        get_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("XML", "*.xml"));
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    try (XMLDecoder decoder_ = new XMLDecoder(new BufferedInputStream(new FileInputStream(file.toString())))){
                        Integer size_ = (Integer) decoder_.readObject();
                        for (int i = 0; i < size_; i++) {
                            shops.add((Shop) decoder_.readObject());
                        }
                    } catch (FileNotFoundException ex) {
                        System.err.println("FileNotFound");
                    }
                }
            }
        });
        put_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("XML", "*.xml"));
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file.toString())))){
                        encoder.writeObject(shops.size());
                        for (int i = 0; i < shops.size(); i++) {
                            encoder.writeObject(shops.get(i));
                        }
                        encoder.close();
                        System.out.println("Успішно записано!");
                    } catch (FileNotFoundException ex) {
                        System.err.println("Файл не знайдено!");
                    }

                }
            }
        });
        delete_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(shop != null){
                    shops.remove(shop);
                    hb.getChildren().clear();
                    table.refresh();
                    hb.getChildren().addAll(buttons);

                }
            }
        });
        add_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Label error_l = new Label();
                TextField product_add = new TextField();
                TextField amount_add = new TextField();
                TextField priceOfProduct_v_add = new TextField();
                TextField weight_add = new TextField();
                //TextField weight_add = new TextField();
                Button save = new Button("Save");
                HBox product_g = new HBox(new Label("Station: "),product_add);
                HBox amount_p_g = new HBox(new Label("Arrival time: "),amount_add);
                HBox priceOfProduct_v_g = new HBox(new Label("Department time: "),priceOfProduct_v_add);
                HBox weight_g = new HBox(new Label("Nubmer of free places: "),weight_add);
                hb.getChildren().clear();
                hb.getChildren().addAll(product_g,amount_p_g,priceOfProduct_v_g,weight_g,save,error_l);

                save.setOnMouseClicked(e -> {
                    error_l.setText("");
                    if(product_add.getText().length() > 0){
                        Shop add_vac = new Shop();
                        add_vac.setStation(product_add.getText());
                        add_vac.setData_p(amount_add.getText());
                        add_vac.setData_v(priceOfProduct_v_add.getText());
                        add_vac.setReason((weight_add.getText()));
                        shops.add(add_vac);
                        hb.getChildren().clear();
                        table.refresh();
                        hb.getChildren().addAll(buttons);
                    }
                    else{
                        error_l.setText("Product must be not empty!");
                    }
                });
            }
        });
        getHotel(hb,table);
        hb.getChildren().addAll(buttons);
        TableView.TableViewSelectionModel<Shop> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Shop>(){

            public void changed(ObservableValue<? extends Shop> val, Shop oldVal, Shop newVal){
                if(newVal != null){
                    shop = newVal;
                    hb.getChildren().clear();
                    hb.getChildren().addAll(buttons);
                    getHotel(hb,table);

                }
            }
        });
        GridPane root = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints(150,150,Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints(150,150,Double.MAX_VALUE);
        column2.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(column2);
        root.setColumnIndex(table, 0);
        sp.setContent(hb);
        root.setColumnIndex(sp, 1);

        root.getChildren().addAll(table, sp);

        Scene scene =  new Scene(root, 1000, 500);

        scene.getStylesheets().add((getClass().getResource("main.css")).toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void getHotel(VBox hb,TableView<Shop> table){
        if(shops.size() > 0) {
            if (shop == null) {
                shop = shops.get(0);
            }
            Label lbl1 = new Label("ID:");
            TextField passport = new TextField();
            TextField data_p = new TextField();
            TextField data_v  = new TextField();
            TextField reason = new TextField();
            lbl1.setText("ID: " + shop.getIndex());
            passport.setText(shop.getStation());
            data_p.setText(shop.getData_p());
            data_v.setText(shop.getData_v());
            reason.setText("" + ((shop.getReason() == null) ? "" : shop.getReason()));
            HBox passport_g = new HBox(new Label("Station: "), passport);
            HBox data_p_g = new HBox(new Label("Arrival time:"), data_p);
            HBox data_v_g = new HBox(new Label("Department time: "), data_v);
            HBox reason_g = new HBox(new Label("Number of free places: "), reason);

            passport.textProperty().addListener((observable, oldValue, newValue) -> {
                if (shop != null) {
                    shop.setStation(newValue);
                    table.refresh();
                }
            });
            data_p.textProperty().addListener((observable, oldValue, newValue) -> {
                if (shop != null) {
                    shop.setData_p(newValue);
                }
            });
            data_v.textProperty().addListener((observable, oldValue, newValue) -> {
                if (shop != null) {
                    shop.setData_v(newValue);
                }
            });

            reason.textProperty().addListener((observable, oldValue, newValue) -> {
                if (shop != null) {
                    shop.setReason((newValue));
                }
            });
            hb.getChildren().addAll(lbl1, passport_g, data_p_g, data_v_g, reason_g);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
