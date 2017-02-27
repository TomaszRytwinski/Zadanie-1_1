package com.capgemini.chess.dataaccess.source.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.dataaccess.source.PlayerDataSource;

@Component
public class PlayerDataSourceImpl implements PlayerDataSource{
	private Map<Long, PlayerEntity> players = new HashMap<Long, PlayerEntity>();
	@Override
	public Map<Long, PlayerEntity> getPlayers() {
		return players;
	}

}
