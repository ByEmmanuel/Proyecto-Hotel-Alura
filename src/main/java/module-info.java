module com.hotel.hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires hibernate.entitymanager;
    opens Persistence_JPA to org.hibernate.orm.core;



    requires org.hibernate.orm.core;
    requires jakarta.validation;


    opens com.hotel.hotel to javafx.fxml;
    exports com.hotel.hotel;



    exports Pantallas;
    opens Pantallas to javafx.fxml;
    exports Persistence_JPA;
    exports DAO;
    opens DAO to org.hibernate.orm.core;


}