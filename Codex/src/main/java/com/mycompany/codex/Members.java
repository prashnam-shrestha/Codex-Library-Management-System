/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codex;

/**
 *
 * @author prashnamshrestha
 */
public abstract class Members {
    private String memberId;
    private String memberPass;
    
    public Members(String memberId, String memberPass) {
        setMemberId(memberId);
        setMemberPass(memberPass);
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }
    
    
     
}
