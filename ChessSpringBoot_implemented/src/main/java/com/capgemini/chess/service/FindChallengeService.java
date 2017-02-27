package com.capgemini.chess.service;

import java.util.List;
import com.capgemini.chess.service.to.ChallengeTO;

public interface FindChallengeService {
	ChallengeTO findChallenge(Long p1id, Long p2id);
	List<ChallengeTO> findChallenge(Long pid);
}
