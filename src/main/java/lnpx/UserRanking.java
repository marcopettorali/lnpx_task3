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
public class UserRanking {
    private String username;
    private Double ranking;

    public UserRanking(String username, Double ranking) {
        this.username = username;
        this.ranking = ranking;
    }

    
    
    public String getUsername() {
        return username;
    }

    public Double getRanking() {
        return ranking;
    }
    
    
}
