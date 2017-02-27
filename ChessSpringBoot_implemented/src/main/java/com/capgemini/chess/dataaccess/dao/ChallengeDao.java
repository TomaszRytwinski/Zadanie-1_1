package com.capgemini.chess.dataaccess.dao;

import java.util.List;
import java.util.UUID;

import com.capgemini.chess.enums.Status;
import com.capgemini.chess.service.to.ChallengeTO;

public interface ChallengeDao {
	List<ChallengeTO> findChallengeSent(Long pid);
	List<ChallengeTO> findChallengeGot(Long pid);
	ChallengeTO findChallenge(UUID id);
	void addChallenge(ChallengeTO challengeTO);
	void changeStatus(UUID id, Status status);
	
}
