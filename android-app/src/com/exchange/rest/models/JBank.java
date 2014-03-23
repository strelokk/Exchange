package com.exchange.rest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad.fargutu on 3/20/14.
 */
public class JBank {

    private String name;
    private List<JBranch> branches;

    public String getName() {
        return name;
    }

    public void setName(String bankName) {
        this.name = bankName;
    }

    public List<JBranch> getBranches() {
        if (branches == null)
            branches = new ArrayList<JBranch>();

        return branches;
    }

    public void setBranches(List<JBranch> branches) {
        this.branches = branches;
    }

}
