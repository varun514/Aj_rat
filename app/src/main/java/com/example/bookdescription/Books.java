package com.example.bookdescription;

import java.util.List;

public class Books {
    private List<Desc> mdesc;

    public Books(List<Desc> mdesc) {
        this.mdesc = mdesc;
    }

    public List<Desc> getMdesc() {
        return mdesc;
    }

    public void setMdesc(List<Desc> mdesc) {
        this.mdesc = mdesc;
    }
}
