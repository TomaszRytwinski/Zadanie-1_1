package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTO;

public class ChallengeMapper {
	public static ChallengeEntity map(ChallengeTO to){
		if (to != null) {
			ChallengeEntity entity = new ChallengeEntity();
			entity.setP1id(to.getP1id());
			entity.setP2id(to.getP2id());
			entity.setId(to.getId());
			entity.setStatus(to.getStatus());;
			return entity;
		}
		return null;
	}
	
	public static ChallengeTO map(ChallengeEntity entity){
		if (entity != null) {
			ChallengeTO to = new ChallengeTO();
			to.setP1id(entity.getP1id());
			to.setP2id(entity.getP2id());
			to.setId(entity.getId());
			to.setStatus(entity.getStatus());;
			return to;
		}
		return null;
	}
	
	public static List<ChallengeTO> map2TOs(List<ChallengeEntity> entities) {
		return entities.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}

	public static List<ChallengeEntity> map2Entities(List<ChallengeTO> tos) {
		return tos.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}
}
