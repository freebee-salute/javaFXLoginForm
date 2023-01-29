module com.example.javafxnew {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.sql;
    requires org.apache.derby.engine;
    requires org.apache.derby.commons;
    requires org.apache.derby.tools;

    opens com.example.loginForm to javafx.fxml;
    exports com.example.loginForm;
}