package org.salim.filesync.utils;

import org.salim.filesync.model.MachineDescription;

/**
 * @author Salim
 * 拿到MachineDescription
 * 远程？
 */
public class MachineUtil {

    public static MachineDescription getLocalMachineDesc() {
        return new MachineDescription();
    }

    public static MachineDescription getRemoteMachineDesc() {
        return new MachineDescription();
    }
}
