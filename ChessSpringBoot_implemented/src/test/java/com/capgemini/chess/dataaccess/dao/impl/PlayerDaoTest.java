package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.dataaccess.source.PlayerDataSource;
import com.capgemini.chess.service.to.PlayerTO;

@RunWith(MockitoJUnitRunner.class)
public class PlayerDaoTest {
	private static final Long EXISTING_ID = 1l;
	private static final Long EXISTING_ID2 = 2l;
	private static final Long EXISTING_ID3 = 3l;
	private static final Long NON_EXISTING_ID = 4l;
	
	@InjectMocks
	private PlayerDaoImpl playerDao;

	@Mock
	private PlayerDataSource playerDataSource;

	@Test
	public void shouldFoundExistingId() {
		// given
		Mockito.when(playerDataSource.getPlayers()).thenReturn(givePlayerBase());

		// when
		PlayerTO playerTO = playerDao.findById(EXISTING_ID);

		// then

		Assert.assertEquals(EXISTING_ID, playerTO.getId());
	}
	@Test
	public void shouldNotFoundNonExistingId() {
		// given
		Mockito.when(playerDataSource.getPlayers()).thenReturn(givePlayerBase());

		// when
		PlayerTO playerTO = playerDao.findById(NON_EXISTING_ID);

		// then

		Assert.assertNull(playerTO);
	}
	
	@Test
	public void shouldFoundPlayerWith5Level() {
		// given
		Mockito.when(playerDataSource.getPlayers()).thenReturn(givePlayerBase());
		List<PlayerTO> playerTO = new ArrayList<PlayerTO>();
		// when
		playerTO = playerDao.findByLvl(5);

		// then

		Assert.assertEquals(EXISTING_ID,playerTO.get(0).getId());
	}
	
	@Test
	public void shouldFoundNoPlayerWith6Level() {
		// given
		Mockito.when(playerDataSource.getPlayers()).thenReturn(givePlayerBase());
		List<PlayerTO> playerTO = new ArrayList<PlayerTO>();
		// when
		playerTO = playerDao.findByLvl(6);

		// then

		Assert.assertTrue(playerTO.isEmpty());
	}

	private Map<Long, PlayerEntity> givePlayerBase() {
		HashMap<Long, PlayerEntity> playerBase = new HashMap<Long, PlayerEntity>();
		PlayerEntity player1 = new PlayerEntity();
		PlayerEntity player2 = new PlayerEntity();
		PlayerEntity player3 = new PlayerEntity();
		player1.setId(EXISTING_ID);
		player1.setLvl(5);
		player1.setPkt(20);
		player2.setId(EXISTING_ID2);
		player2.setLvl(4);
		player2.setPkt(12);
		player3.setId(EXISTING_ID3);
		player3.setLvl(1);
		player3.setPkt(6);
		playerBase.put(1l, player1);
		playerBase.put(2l, player2);
		return playerBase;
	}

}
