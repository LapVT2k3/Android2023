package com.lapvt.myapplication.recyclerviewb3;

import java.util.Objects;

public class Folder {
    private String nameFolder;

    public Folder(String nameFolder) {
        this.nameFolder = nameFolder;
    }

    public String getNameFolder() {
        return nameFolder;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return Objects.equals(nameFolder, folder.nameFolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFolder);
    }
}
