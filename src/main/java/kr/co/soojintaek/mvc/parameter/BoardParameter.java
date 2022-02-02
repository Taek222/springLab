package kr.co.soojintaek.mvc.parameter;

import lombok.Data;

import java.util.Date;

@Data
public class BoardParameter {

    private int boardSeq;
    private String title;
    private String contents;

}
