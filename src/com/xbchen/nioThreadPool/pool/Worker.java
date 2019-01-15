package com.xbchen.nioThreadPool.pool;

import java.nio.channels.SocketChannel;
/**
 * worker接口
 * @author xbchenf
 *
 */
public interface Worker {
	
	/**
	 * 加入一个新的客户端会话
	 * @param channel
	 */
	public void registerNewChannelTask(SocketChannel channel);

}