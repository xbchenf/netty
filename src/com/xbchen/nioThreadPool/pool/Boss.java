package com.xbchen.nioThreadPool.pool;

import java.nio.channels.ServerSocketChannel;
/**
 * boss接口
 * @author xbchenf
 *
 */
public interface Boss {
	
	/**
	 * 加入一个新的ServerSocket
	 * @param serverChannel
	 */
	public void registerAcceptChannelTask(ServerSocketChannel serverChannel);
}
