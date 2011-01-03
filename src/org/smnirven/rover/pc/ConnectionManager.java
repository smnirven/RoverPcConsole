/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smnirven.rover.pc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

/**
 *
 * @author smnirven
 */
public class ConnectionManager {

    private static ConnectionManager _instance;
    private static NXTComm _connection;
    private static DataOutputStream _dos;
    private static DataInputStream _dis;
    private static int[] _reply = new int[1000];

    private ConnectionManager() {
        try {
            _connection = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
        } catch (NXTCommException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionManager getInstance() {
        if (_instance == null) {
            _instance = new ConnectionManager();
        }

        return _instance;
    }

    public boolean openConnection(NxtDevice device) {
        boolean itWorked = false;
        try {
            itWorked = _connection.open(device.getNxtInfo());
            InputStream is = _connection.getInputStream();
            OutputStream os = _connection.getOutputStream();

            _dos = new DataOutputStream(os);
            _dis = new DataInputStream(is);
        } catch (NXTCommException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itWorked;
    }

    public int[] sendCommand(int[] command) {
        if (_dos == null) {
            System.out.println("dos is null");
        }

        for (int k = 0; k < 3; k++) {
            try {
                _dos.writeInt(command[k]);
                _dos.flush();
            } catch (IOException ioe) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ioe);
            }
        }

        for (int k = 0; k < 8; k++) {
            try {
                _reply[k] = _dis.readInt();
            } catch (IOException ioe) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ioe);
            }
        }

        return _reply;
    }

    public ArrayList<NxtDevice> getAvailableDevices() {
        ArrayList<NxtDevice> devices = new ArrayList();

        try {
            NXTInfo[] nxtInfos = _connection.search(null, NXTCommFactory.BLUETOOTH);
            for (int i = 0; i < nxtInfos.length; i++) {
                devices.add(new NxtDevice(nxtInfos[i]));
            }
        } catch (NXTCommException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return devices;
    }

    public int[] getReply() {
        return _reply;
    }
}
