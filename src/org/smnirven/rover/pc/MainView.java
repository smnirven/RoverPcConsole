/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainView.java
 *
 * Created on Jan 2, 2011, 9:25:23 PM
 */
package org.smnirven.rover.pc;

import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author smnirven
 */
public class MainView extends javax.swing.JFrame {

    /** Creates new form MainView */
    public MainView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConnect = new javax.swing.JButton();
        btnScan = new javax.swing.JButton();
        cmbDevices = new javax.swing.JComboBox();
        txtLog = new javax.swing.JScrollPane();
        txtEventLog = new javax.swing.JTextArea();
        jScrollBar1 = new javax.swing.JScrollBar();
        btnSendRedLight = new javax.swing.JButton();
        btnGetBattery = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rover Console");

        btnConnect.setText("connect");
        btnConnect.setEnabled(false);
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnScan.setText("scan");
        btnScan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnScanMouseClicked(evt);
            }
        });

        cmbDevices.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDevicesActionPerformed(evt);
            }
        });

        txtEventLog.setColumns(20);
        txtEventLog.setRows(5);
        txtLog.setViewportView(txtEventLog);

        btnSendRedLight.setText("RED");
        btnSendRedLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRedLightActionPerformed(evt);
            }
        });

        btnGetBattery.setText("Get Battery Level");
        btnGetBattery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetBatteryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtLog, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnScan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDevices, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConnect))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSendRedLight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetBattery)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnScan)
                    .addComponent(cmbDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect))
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendRedLight)
                    .addComponent(btnGetBattery))
                .addGap(184, 184, 184)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(txtLog, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        NxtDevice selectedDevice = (NxtDevice) cmbDevices.getSelectedItem();
        txtEventLog.append("Attempting Connection to Device " + selectedDevice.toString() + "\n");
        if (ConnectionManager.getInstance().openConnection(selectedDevice)) {
            txtEventLog.append("Connection Established!\n");
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void cmbDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDevicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDevicesActionPerformed

    private void btnScanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScanMouseClicked
        txtEventLog.append("Device Scan Initiated\n");
        ArrayList<NxtDevice> devices = ConnectionManager.getInstance().getAvailableDevices();

        if (devices.size() > 0) {
            cmbDevices.removeAllItems();
            for (int i = 0; i < devices.size(); i++) {
                cmbDevices.addItem(devices.get(i));
            }

            btnConnect.setEnabled(true);
        }

        txtEventLog.append("Device Scan Completed\n");
    }//GEN-LAST:event_btnScanMouseClicked

    private void btnSendRedLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRedLightActionPerformed
        RoverManager.sendRedLight();
    }//GEN-LAST:event_btnSendRedLightActionPerformed

    private void btnGetBatteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetBatteryActionPerformed
        txtEventLog.append("Querying Device Battery Level...\n");
        int level = RoverManager.getBatteryLevel();
        txtEventLog.append("Current Battery Level: " + level + "\n");
    }//GEN-LAST:event_btnGetBatteryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnGetBattery;
    private javax.swing.JButton btnScan;
    private javax.swing.JButton btnSendRedLight;
    private javax.swing.JComboBox cmbDevices;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextArea txtEventLog;
    private javax.swing.JScrollPane txtLog;
    // End of variables declaration//GEN-END:variables
}