package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompanyViewAdd extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JList list1;
    private JList list2;
    private JList list3;
    private JTextField textField1;
    private JTextField textField2;
    private JScrollPane JScrollPaneFilials;
    private JScrollPane JScrollPaneDepartments;
    private JScrollPane JScrollPaneDirector;

    public CompanyViewAdd() {
        setContentPane(contentPane);
        setModal(true);
        this.contentPane.setPreferredSize(new Dimension(400,300));
        this.JScrollPaneFilials.setPreferredSize(new Dimension(80,100));
        this.JScrollPaneDepartments.setPreferredSize(new Dimension(80,100));
        this.JScrollPaneDirector.setPreferredSize(new Dimension(80,100));
    }


}
