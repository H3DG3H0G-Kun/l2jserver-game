/*
 * Copyright © 2004-2025 L2J Server
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
package com.l2jserver.gameserver.network.clientpackets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.l2jserver.gameserver.network.serverpackets.ExNeedToChangeName;

/**
 * Reply for {@link ExNeedToChangeName}
 * @author JIV
 */
public class RequestExChangeName extends L2GameClientPacket {
	private static final Logger LOG = LoggerFactory.getLogger(RequestExChangeName.class);
	
	private static final String _C__D0_3B_REQUESTEXCHANGENAME = "[C] D0:3B RequestExChangeName";
	
	private String _newName;
	private int _type;
	private int _charSlot;
	
	@Override
	protected void readImpl() {
		_type = readD();
		_newName = readS();
		_charSlot = readD();
	}
	
	@Override
	protected void runImpl() {
		LOG.info("Received {} name: {} type: {} CharSlot: {}", getType(), _newName, _type, _charSlot);
		
	}
	
	@Override
	public String getType() {
		return _C__D0_3B_REQUESTEXCHANGENAME;
	}
}
