package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.DistVO;
import org.zerock.domain.RankVO;
import org.zerock.domain.WritersVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;
	
	
	@Override
	public void register(BoardVO vo) {
		//mapper.insert(vo);
		mapper.insertSelectKey(vo);  //글등록시 글번호 알기
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO vo) {
		return (mapper.update(vo)==1);
	}

	@Override
	public boolean remove(Long bno) {
		return (mapper.delete(bno)==1);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public Long count(Criteria cri) {
		return mapper.count(cri);
	}

	@Override
	public List<RankVO> rank() {
		return mapper.rank();
		
	}

	@Override
	public List<DistVO> dist() {
		return mapper.dist();
	}

	@Override
	public List<WritersVO> writers() {
	return mapper.writers();
	}

}
