/*
 * Copyright © 2004-2024 L2J Server
 *
 * This file is part of L2J Server.
 *
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

import java.util.List;

import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Reloadable;

import com.l2jserver.gameserver.config.converter.Minutes2MillisecondsConverter;

/**
 * Grand Boss Configuration.
 * @author Zoey76
 * @version 2.6.1.0
 */
@Sources({
	"file:${L2J_HOME}/custom/game/config/grandboss.properties",
	"file:./config/grandboss.properties",
	"classpath:config/grandboss.properties"
})
@LoadPolicy(MERGE)
@HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface GrandBossConfiguration extends Reloadable {
	
	@Key("AntharasWaitTime")
	@ConverterClass(Minutes2MillisecondsConverter.class)
	int getAntharasWaitTime();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("IntervalOfAntharasSpawn")
	int getIntervalOfAntharasSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("RandomOfAntharasSpawn")
	int getRandomOfAntharasSpawn();
	
	@Key("ValakasWaitTime")
	@ConverterClass(Minutes2MillisecondsConverter.class)
	int getValakasWaitTime();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("IntervalOfValakasSpawn")
	int getIntervalOfValakasSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("RandomOfValakasSpawn")
	int getRandomOfValakasSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("IntervalOfBaiumSpawn")
	int getIntervalOfBaiumSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("RandomOfBaiumSpawn")
	int getRandomOfBaiumSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("IntervalOfCoreSpawn")
	int getIntervalOfCoreSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("RandomOfCoreSpawn")
	int getRandomOfCoreSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("IntervalOfOrfenSpawn")
	int getIntervalOfOrfenSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("RandomOfOrfenSpawn")
	int getRandomOfOrfenSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("IntervalOfQueenAntSpawn")
	int getIntervalOfQueenAntSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("RandomOfQueenAntSpawn")
	int getRandomOfQueenAntSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("IntervalOfBelethSpawn")
	int getIntervalOfBelethSpawn();
	
	// TODO(Zoey76): Convert hours to milliseconds.
	@Key("RandomOfBelethSpawn")
	int getRandomOfBelethSpawn();
	
	@Key("BelethMinPlayers")
	int getBelethMinPlayers();
	
	// TODO(Zoey76): Implement AllowZakenWithoutParty configuration.
	@Key("AllowZakenWithoutParty")
	boolean getAllowZakenWithoutParty();
	
	// TODO(Zoey76): Implement ZakenMinPlayers configuration.
	@Key("ZakenMinPlayers")
	List<Integer> getZakenMinPlayers();
	
	// TODO(Zoey76): Implement ZakenMaxPlayers configuration.
	@Key("ZakenMaxPlayers")
	List<Integer> getZakenMaxPlayers();
	
	// TODO(Zoey76): Implement ZakenMinPlayerLevel configuration.
	@Key("ZakenMinPlayerLevel")
	List<Integer> getZakenMinPlayerLevel();
	
	// TODO(Zoey76): Implement ZakenCanBeRevealedByAOESpells configuration.
	@Key("ZakenCanBeRevealedByAOESpells")
	boolean getZakenCanBeRevealedByAoeSPells();
}