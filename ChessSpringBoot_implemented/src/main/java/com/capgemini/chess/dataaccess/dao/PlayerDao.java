package com.capgemini.chess.dataaccess.dao;

import java.util.List;

import com.capgemini.chess.service.to.PlayerTO;

public interface PlayerDao {
	PlayerTO findById(Long id);
	List<PlayerTO> findByLvl(int lvl);

}
