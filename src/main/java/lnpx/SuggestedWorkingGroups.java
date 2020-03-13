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
    private int workingGroupID;
    private Double affinity;

    public SuggestedWorkingGroups(int workingGroupID, Double affinity) {
        this.workingGroupID = workingGroupID;
        this.affinity = affinity;
    }

    public int getWorkingGroupID() {
        return workingGroupID;
    }

    public Double getAffinity() {
        return affinity;
    }
    
    
}
