package com.senla.filetools;

import com.senla.dataaccessobject.RoomDTO;
import com.senla.dataaccessobject.ServiceDTO;

public interface IFileStreamWriter {
    void fileWrite(RoomDTO roomDTO);
    void fileWrite(ServiceDTO serviceDTO);
}
