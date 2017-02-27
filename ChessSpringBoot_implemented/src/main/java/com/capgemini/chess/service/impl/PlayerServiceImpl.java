package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.dao.PlayerDao;
import com.capgemini.chess.service.PlayerService;
import com.capgemini.chess.service.to.PlayerTO;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerDao playerDao;
	@Override
	public PlayerTO searchPlayer(Long id) {
		PlayerTO foundById = playerDao.findById(id);
		return foundById;
	}

	@Override
	public int getLevel(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPoint(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
