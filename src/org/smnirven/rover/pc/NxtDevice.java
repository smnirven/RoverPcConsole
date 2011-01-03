/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.smnirven.rover.pc;

import lejos.pc.comm.NXTInfo;

/**
 *
 * @author smnirven
 */
public class NxtDevice {
    private NXTInfo _nxtInfo;

    public NxtDevice(NXTInfo nxtInfo) {
        _nxtInfo = nxtInfo;
    }

    @Override
    public String toString() {
        return _nxtInfo.name + " - " + _nxtInfo.deviceAddress;
    }

    public NXTInfo getNxtInfo() {
        return _nxtInfo;
    }
}
