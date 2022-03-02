package kr.co.soojintaek.mvc.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Tanent {

    private int companyNo;
    private String companyName;
    private boolean companyYN;
    private String domain;
    private String phone;
    private String email;
    private Date regDate;
    private int regUsr;
    private Date modDate;
    private int modUsr;

    public Tanent(boolean companyYN) {
        this.companyYN = companyYN;

    }

}
