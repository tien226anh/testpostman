package org.example;

import javax.swing.*;

public class MainPage {
  private JPanel containerPanel;
  private JPanel historyPanel;
  private JPanel mainPanel;
  private JTabbedPane reqTabPanel;
  private JPanel tabMainPanel;
  private JPanel reqPanel;
  private JPanel resPanel;
  private JTextField apiUrlTextField;
  private JButton sendButton;
  private JComboBox methodComboBox;
  private JPanel headerParamPanel;
  private JTabbedPane ParamTabPanel;
  private JPanel AuthPanel;
  private JPanel ParamPanel;
  private JPanel Headers;
  private JPanel Body;

  public static void main(String[] args) {
    JFrame frame = new JFrame("MainPage");
    frame.setContentPane(new MainPage().containerPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
