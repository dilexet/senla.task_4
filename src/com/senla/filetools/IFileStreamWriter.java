package com.senla.filetools;

import com.senla.dataaccessobject.RoomDTO;
import com.senla.dataaccessobject.ServiceDTO;

public interface IFileStreamWriter {
    void fileWrite(String path, RoomDTO roomDTO);
    void fileWrite(String path, ServiceDTO serviceDTO);
}
