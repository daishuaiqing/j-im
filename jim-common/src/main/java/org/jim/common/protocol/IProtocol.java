/**
 * 
 */
package org.jim.common.protocol;

import org.jim.common.ImChannelContext;
import org.jim.common.ImPacket;
import org.jim.common.exception.ImException;

import java.nio.ByteBuffer;

/**
 * 判断协议接口
 * @author WChao
 *
 */
public interface IProtocol {
	/**
	 * 协议名称
	 * @return 如:http、ws、tcp等
	 */
	String name();

	/**
	 * 根据buffer判断是否属于指定协议
	 * @param buffer
	 * @param imChannelContext
	 * @return
	 * @throws ImException
	 */
	boolean isProtocol(ByteBuffer buffer, ImChannelContext imChannelContext) throws ImException;

	/**
	 * 根据imPacket判断是否属于指定协议
	 * @param imPacket
	 * @param imChannelContext
	 * @return
	 * @throws ImException
	 */
	boolean isProtocol(ImPacket imPacket, ImChannelContext imChannelContext)throws ImException;
}
