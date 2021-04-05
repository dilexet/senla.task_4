package com.senla.filetools;

import java.io.IOException;

public interface IFileStreamReader {
    String fileRead(String path) throws IOException;
}
