package com.xyz.abc.nio;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
  
public class SocketReadHandler implements Runnable{  
    private SocketChannel socketChannel;  
    public SocketReadHandler(Selector selector,SocketChannel socketChannel) throws IOException{  
        this.socketChannel=socketChannel;  
        socketChannel.configureBlocking(false);  
          
        SelectionKey selectionKey=socketChannel.register(selector, 0);  
          
        //将SelectionKey绑定为本Handler 下一步有事件触发时，将调用本类的run方法。    
        //参看dispatch(SelectionKey key)    
        selectionKey.attach(this);  
          
        //同时将SelectionKey标记为可读，以便读取。    
        selectionKey.interestOps(SelectionKey.OP_READ);    
        selector.wakeup();  
    }  
      
    /** 
     * 处理读取数据 
     */  
    public void run() {  
        ByteBuffer inputBuffer=ByteBuffer.allocate(1024);  
        inputBuffer.clear();  
        try {  
            socketChannel.read(inputBuffer);  
            System.out.println(inputBuffer.capacity());
            
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            // charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空
            CharBuffer charBuffer = decoder.decode(inputBuffer.asReadOnlyBuffer());
            System.out.println(new String(inputBuffer.array(),"GBK"));
            //激活线程池 处理这些request  
            //requestHandle(new Request(socket,btt));   
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
