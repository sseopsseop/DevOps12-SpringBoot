package com.bit.springboard.mapper;

import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    void post(BoardDto boardDto);

    void postFiles(List<BoardFileDto> boardFileDtoList);

    BoardDto findById(int id);

    List<BoardDto> findAll(Map<String, Object> searchMap);

    List<BoardFileDto> findFilesByBoardId(int id);
}
