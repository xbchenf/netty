package com.xbchen.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @description ByteBuf 测试
 */
public class ByteBufTest {

    public static void main(String[] args) {
        ByteBuf byteBuf1=Unpooled.buffer(7);
        byteBuf1.writeBytes("abcdefg".getBytes());
        for(int i=0;i<byteBuf1.capacity();i++){
            byte b=byteBuf1.getByte(i);
            System.out.println((char)b);
        }
        System.out.println("-------------------------------------------");

        ByteBuf byteBuf2=Unpooled.wrappedBuffer(new byte[]{1,2,3,4,5});
        while (byteBuf2.isReadable()) {
            System.out.println(byteBuf2.readByte());
        }
        System.out.println("-------------------------------------------");


        ByteBuf byteBuf3=Unpooled.buffer(4);
        System.out.println(byteBuf3.readableBytes());
        System.out.println(byteBuf3.writableBytes());
        while (byteBuf3.writableBytes() >= 4) {
            byteBuf3.writeInt(2);
        }
        System.out.println(byteBuf3.readInt());
        System.out.println(byteBuf3.readableBytes());
        System.out.println(byteBuf3.writableBytes());
        System.out.println("-------------------------------------------");

        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf4 = Unpooled.copiedBuffer("Netty in Action rocks!", utf8); //1
        ByteBuf sliced = buf4.slice(0, 14);          //2
        System.out.println(sliced.toString(utf8));  //3
        buf4.setByte(0, (byte) 'J');                 //4
        assert buf4.getByte(0) == sliced.getByte(0);
        System.out.println(buf4.toString(utf8));
        System.out.println("-------------------------------------------");

        ByteBuf buf5 = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        ByteBuf copy = buf5.copy(0, 14);
        System.out.println(copy.toString(utf8));
        buf5.setByte(0, (byte) 'J');
        assert buf5.getByte(0) != copy.getByte(0);
        System.out.println(buf5.toString(utf8));
        System.out.println(copy.toString(utf8));
        System.out.println("-------------------------------------------");

        ByteBuf buf6 = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);    //1
        System.out.println((char)buf6.getByte(0));                    //2
        int readerIndex = buf6.readerIndex();                        //3
        int writerIndex = buf6.writerIndex();
        buf6.setByte(0, (byte)'B');                            //4
        System.out.println((char)buf6.getByte(0));                    //5
        assert readerIndex == buf6.readerIndex();                    //6
        assert writerIndex ==  buf6.writerIndex();
        System.out.println(buf6.toString(utf8));
        System.out.println("-------------------------------------------");

        ByteBuf buf7 = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);    //1
        System.out.println((char)buf7.readByte());                    //2
        int readerIndex7 = buf7.readerIndex();                        //3
        int writerIndex7 = buf7.writerIndex();                        //4
        buf7.writeByte((byte)'?');                            //5
        assert readerIndex7 == buf7.readerIndex();
        assert writerIndex7 != buf7.writerIndex();
        System.out.println(readerIndex7+"-------------------------------------------"+buf7.readerIndex());
        System.out.println(writerIndex7+"-------------------------------------------"+buf7.writerIndex());
        System.out.println(buf7.toString(utf8));
        System.out.println("-------------------------------------------");

    }
}
