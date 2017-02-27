package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.service.to.PlayerTO;


public class PlayerMapper {
	public static PlayerEntity map(PlayerTO to){
		if (to != null) {
			PlayerEntity entity = new PlayerEntity();
			entity.setId(to.getId());
			entity.setLvl(to.getLvl());
			entity.setPkt(to.getPkt());
			return entity;
		}
		return null;
	}
	
	public static PlayerTO map(PlayerEntity entity){
		if (entity != null) {
			PlayerTO to = new PlayerTO();
			to.setId(entity.getId());
			to.setLvl(entity.getLvl());
			to.setPkt(entity.getPkt());
			return to;
		}
		return null;
	}
	
	public static List<PlayerTO> map2TOs(List<PlayerEntity> entities) {
		return entities.stream().map(PlayerMapper::map).collect(Collectors.toList());
	}

	public static List<PlayerEntity> map2Entities(List<PlayerTO> tos) {
		return tos.stream().map(PlayerMapper::map).collect(Collectors.toList());
	}
}
