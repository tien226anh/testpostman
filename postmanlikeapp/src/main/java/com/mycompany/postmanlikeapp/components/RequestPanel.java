/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.postmanlikeapp.components;

import com.mycompany.postmanlikeapp.models.ResponseData;
import com.mycompany.postmanlikeapp.services.MethodsService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 *
 * @author tien2
 */
public class RequestPanel extends javax.swing.JPanel {

    private final MethodsService apiService = new MethodsService();

    /**
     * Creates new form RequestPanel
     */
    public RequestPanel() {
        initComponents();

        sendRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = apiUrlTextField.getText();
                String method = (String) methodComboBox.getSelectedItem();
                String resBody = "";
                int resStatusCode = 0;
                long resTime = 0;
                String resHeaders = "";
                ResponseData resData = new ResponseData();

                if (null == method && null == url || url.trim().isEmpty()) {
                    resBody = "Please fill url and select method!";
                } else if (null == url || url.trim().isEmpty()) {
                    resBody = "Please fill url";
                } else if (null != method) {
                    switch (method) {
                        case "GET":
                            resData = apiService.sendGetRequest(url);
                            resBody = resData.getResponseBody();
                            resStatusCode = resData.getResponseStatusCode();
                            resTime = resData.getResponseTime();
                            resHeaders = Arrays.toString(resData.getResponseHeaders());
                            break;
                        case "POST":
                            resData = apiService.sendPostRequest(url);
                            resBody = resData.getResponseBody();
                            resStatusCode = resData.getResponseStatusCode();
                            resTime = resData.getResponseTime();
                            resHeaders = Arrays.toString(resData.getResponseHeaders());
                            break;
                        case "PUT":
                            resData = apiService.sendPutRequest(url);
                            resBody = resData.getResponseBody();
                            resStatusCode = resData.getResponseStatusCode();
                            resTime = resData.getResponseTime();
                            resHeaders = Arrays.toString(resData.getResponseHeaders());
                            break;
                        case "DELETE":
                            resData = apiService.sendDeleteRequest(url);
                            resBody = resData.getResponseBody();
                            resStatusCode = resData.getResponseStatusCode();
                            resTime = resData.getResponseTime();
                            resHeaders = Arrays.toString(resData.getResponseHeaders());
                            break;
                        default:
                            throw new AssertionError();
                    }
                }

                responseBodyEditorPanel.setText(resBody);
                statusCodeButton.setText(Integer.toString(resStatusCode));
                timeResponseButton.setText(Long.toString(resTime / 10) + "ms");
                responseHeadersEditorPanel.setText(resHeaders);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        requestFieldPanel = new javax.swing.JPanel();
        methodComboBox = new javax.swing.JComboBox<>();
        sendRequestButton = new javax.swing.JButton();
        apiUrlTextField = new javax.swing.JTextField();
        requestDetailTabPanel = new javax.swing.JTabbedPane();
        paramsPanel = new javax.swing.JPanel();
        authPanel = new javax.swing.JPanel();
        headersPanel = new javax.swing.JPanel();
        bodyPanel = new javax.swing.JPanel();
        responseFieldPanel = new javax.swing.JPanel();
        responseDataDetailTabPanel = new javax.swing.JTabbedPane();
        responseBodyDetailPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        responseBodyEditorPanel = new javax.swing.JEditorPane();
        reponseHeadersDetailPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        responseHeadersEditorPanel = new javax.swing.JEditorPane();
        statusCodeButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeResponseButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        methodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GET", "POST", "PUT", "DELETE" }));

        sendRequestButton.setText("Send");

        javax.swing.GroupLayout paramsPanelLayout = new javax.swing.GroupLayout(paramsPanel);
        paramsPanel.setLayout(paramsPanelLayout);
        paramsPanelLayout.setHorizontalGroup(
            paramsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        paramsPanelLayout.setVerticalGroup(
            paramsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        requestDetailTabPanel.addTab("Params", paramsPanel);

        javax.swing.GroupLayout authPanelLayout = new javax.swing.GroupLayout(authPanel);
        authPanel.setLayout(authPanelLayout);
        authPanelLayout.setHorizontalGroup(
            authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        authPanelLayout.setVerticalGroup(
            authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        requestDetailTabPanel.addTab("Auth", authPanel);

        javax.swing.GroupLayout headersPanelLayout = new javax.swing.GroupLayout(headersPanel);
        headersPanel.setLayout(headersPanelLayout);
        headersPanelLayout.setHorizontalGroup(
            headersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        headersPanelLayout.setVerticalGroup(
            headersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        requestDetailTabPanel.addTab("Headers", headersPanel);

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        requestDetailTabPanel.addTab("Body", bodyPanel);

        javax.swing.GroupLayout requestFieldPanelLayout = new javax.swing.GroupLayout(requestFieldPanel);
        requestFieldPanel.setLayout(requestFieldPanelLayout);
        requestFieldPanelLayout.setHorizontalGroup(
            requestFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestFieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(requestFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestDetailTabPanel)
                    .addGroup(requestFieldPanelLayout.createSequentialGroup()
                        .addComponent(methodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apiUrlTextField)
                        .addGap(18, 18, 18)
                        .addComponent(sendRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        requestFieldPanelLayout.setVerticalGroup(
            requestFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestFieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(requestFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(apiUrlTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(requestFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(methodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sendRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(requestDetailTabPanel)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(responseBodyEditorPanel);

        javax.swing.GroupLayout responseBodyDetailPanelLayout = new javax.swing.GroupLayout(responseBodyDetailPanel);
        responseBodyDetailPanel.setLayout(responseBodyDetailPanelLayout);
        responseBodyDetailPanelLayout.setHorizontalGroup(
            responseBodyDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(responseBodyDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        responseBodyDetailPanelLayout.setVerticalGroup(
            responseBodyDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, responseBodyDetailPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        responseDataDetailTabPanel.addTab("Body", responseBodyDetailPanel);

        jScrollPane1.setViewportView(responseHeadersEditorPanel);

        javax.swing.GroupLayout reponseHeadersDetailPanelLayout = new javax.swing.GroupLayout(reponseHeadersDetailPanel);
        reponseHeadersDetailPanel.setLayout(reponseHeadersDetailPanelLayout);
        reponseHeadersDetailPanelLayout.setHorizontalGroup(
            reponseHeadersDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reponseHeadersDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        reponseHeadersDetailPanelLayout.setVerticalGroup(
            reponseHeadersDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reponseHeadersDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        responseDataDetailTabPanel.addTab("Headers", reponseHeadersDetailPanel);

        statusCodeButton.setText("Status");

        jLabel3.setText("Status:");

        jLabel4.setText("Time:");

        timeResponseButton.setText("Time");

        javax.swing.GroupLayout responseFieldPanelLayout = new javax.swing.GroupLayout(responseFieldPanel);
        responseFieldPanel.setLayout(responseFieldPanelLayout);
        responseFieldPanelLayout.setHorizontalGroup(
            responseFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(responseFieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(responseFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(responseDataDetailTabPanel)
                    .addGroup(responseFieldPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusCodeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeResponseButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        responseFieldPanelLayout.setVerticalGroup(
            responseFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, responseFieldPanelLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(responseFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusCodeButton)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(timeResponseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(responseDataDetailTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestFieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(responseFieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requestFieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(responseFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apiUrlTextField;
    private javax.swing.JPanel authPanel;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JPanel headersPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> methodComboBox;
    private javax.swing.JPanel paramsPanel;
    private javax.swing.JPanel reponseHeadersDetailPanel;
    private javax.swing.JTabbedPane requestDetailTabPanel;
    private javax.swing.JPanel requestFieldPanel;
    private javax.swing.JPanel responseBodyDetailPanel;
    private javax.swing.JEditorPane responseBodyEditorPanel;
    private javax.swing.JTabbedPane responseDataDetailTabPanel;
    private javax.swing.JPanel responseFieldPanel;
    private javax.swing.JEditorPane responseHeadersEditorPanel;
    private javax.swing.JButton sendRequestButton;
    private javax.swing.JButton statusCodeButton;
    private javax.swing.JButton timeResponseButton;
    // End of variables declaration//GEN-END:variables
}
