package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dataaccess.dao.PlayerDao;
import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.dataaccess.source.PlayerDataSource;
import com.capgemini.chess.service.mapper.PlayerMapper;
import com.capgemini.chess.service.to.PlayerTO;

@Repository
public class PlayerDaoImpl implements PlayerDao{
	@Autowired
	PlayerDataSource playerDataSource;
	@Override
	public PlayerTO findById(Long id) {
		PlayerEntity player = playerDataSource.getPlayers().values().stream().filter(u ->u.getId().equals(id)).findFirst().orElse(null);
		return PlayerMapper.map(player);
	}

	@Override
	public List<PlayerTO> findByLvl(int lvl) {
		List<PlayerTO> player = new ArrayList<PlayerTO>();
		player.addAll(PlayerMapper.map2TOs(playerDataSource.getPlayers().values().stream()
				.filter(u -> u.getLvl()==lvl).collect(Collectors.toList())));
		return player;
	}

}
