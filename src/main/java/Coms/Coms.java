package Coms;

import com.fazecast.jSerialComm.*;
public class Coms {
    Log log = new Log();
    SerialPort[] comPorts;
    SerialPort comPort = SerialPort.getCommPorts()[0];
    long baudRate;
    byte[] commands;
    
    public void setComPort(SerialPort[] ports) {
        this.comPorts = ports;
    }
    public void init() {
        log.l("Com project:");
        log.l(comPort.getDescriptivePortName());
        log.l(comPort.getPortDescription());
        log.l(comPort.getSystemPortName());
        byte[] buffer = {'a','b','c'};
        String line = "from java Com class";
        log.l("writing "+buffer);
        comPort.setBaudRate(9600);
        comPort.openPort();
        int count = 0;

        while (count < 100) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                log.l("Thread interrupted: "+ie.getStackTrace());
            }
            log.l("writing");
           
            comPort.writeBytes(line.getBytes(), line.getBytes().length);
            
            count++;
        }
        comPort.closePort();
        
    }
}
