/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smnirven.rover.pc;

/**
 *
 * @author smnirven
 */
public class RoverManager {

  public static final int[] COMMAND_BATTERY_VOLTAGE = {0, 0, 0};
  public static final int[] COMMAND_ALL_STOP = {1, 0, 0};
  public static final int[] COMMAND_RED_LIGHT_ON = {2, 0, 0};

  public static void sendRedLight() {
    ConnectionManager.getInstance().sendCommand(COMMAND_RED_LIGHT_ON);
  }

  public static void sendAllStop() {
    ConnectionManager.getInstance().sendCommand(COMMAND_ALL_STOP);
  }

  public static int getBatteryLevel() {
    return ConnectionManager.getInstance().sendCommand(COMMAND_RED_LIGHT_ON)[0];
  }
}
