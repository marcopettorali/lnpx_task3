/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lnpx;

/**
 *
 * @author Riccardo
 */
public class SuggestedWorkingGroups {
    private WorkingGroup wg;
    private int workingGroupID;
    private String description;
    private Double affinity;

    public SuggestedWorkingGroups(WorkingGroup wg, int workingGroupID, Double affinity, String description) {
        this.wg=wg;
        this.workingGroupID = workingGroupID;
        this.description=description;
        this.affinity = affinity;
    }

    public WorkingGroup getWg() {
        return wg;
    }
    
    

    public int getWorkingGroupID() {
        return workingGroupID;
    }

    public Double getAffinity() {
        return affinity;
    }

    public String getDescription() {
        return description;
    }
    

    
    
}
