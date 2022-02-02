package kr.co.soojintaek.mvc.controller;

import kr.co.soojintaek.mvc.domain.Board;
import kr.co.soojintaek.mvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
*
* BoardController 설명
*
* @author psjin
* @version 1.0.0
* 작성일 2022-01-26
**/
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
    * 기능 : 게시글 목록 리턴
    * 작성일 2022-01-26
    **/
    @GetMapping
    public List<Board> getList(){
        return boardService.getList();
    }

    /**
    * 기능 : 게시글 1건 조회
    * 작성일 2022-01-26
    **/
    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq){
        return boardService.get(boardSeq);
    }

    /**
    * 기능 : 게시글 등록/수정 처리
    * 작성일 2022-01-26
    **/
    @GetMapping("/save")
    public int save(Board parameter){
        boardService.save(parameter);
        return parameter.getBoardSeq();
    }

    /**
    * 기능 : 게시글 삭제
    * 작성일 2022-01-26
    **/
    @GetMapping("/delete/{boardSeq}")
    public boolean delete(@PathVariable int boardSeq){
        Board board = boardService.get(boardSeq);
        if(board == null){
            return false;
        }
        boardService.delete(boardSeq);
        return true;
    }
}
