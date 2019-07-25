package nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 1.Buffer 是缓冲区,本质是特定类型的数组
 *		除了 boolean 类型之外,其他的类型都有指定类型的缓冲区
 *		ByteBuffer
 *		CharBuffer...
 *
 * 2.怎么构建缓冲区
 * 		Buffer.allocate(capacity)
 * 		构建指定长度的缓冲区
 * 
 * 3.存取数据
 * 		put()/get();
 * 
 * 4.四个核心属性
 * 		mark:标记
 * 		position:位置(存取数据的位置)
		limit:限制(limit 之后的数据不能被操作)
		capacity:缓冲区容量
 * 
 */
public class BufferTest {
	
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put("hello".getBytes());
		buffer.flip();
		byte[] dst =new byte[buffer.limit()];
		buffer.get(dst, 0, 2);
		show(buffer);
		System.out.println(new String(dst,0,2));
		
		// 标记一下
		buffer.mark();
		buffer.get(dst, 2, 3);
		show(buffer);
		System.out.println(new String(dst, 2, 3));
		
		
		// 重置回标记处
		buffer.reset();
		show(buffer);
		
		// 是否读取完了
		if(buffer.hasRemaining()) {
			System.out.println(buffer.remaining());
		}
	}

	public static void test1() {
		// 1.创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		show(buffer);
		// 2.存取数据
		buffer.put("hello".getBytes());
		show(buffer);
		// 3.转换读写模式
		buffer.flip();
		show(buffer);
		// 4.读取数据
//		for (int i = 0; i < buffer.limit(); i++) {
//			System.out.print((char)buffer.get());
//		}
		byte[] dst = new byte[buffer.limit()];
		buffer.get(dst, 0, buffer.limit());
		System.out.println(new String(dst, 0, buffer.limit()));
		show(buffer);
		// 5.重置了 position 的位置 可以重新读取
		buffer.rewind();
		show(buffer);
		// 6.清空(索引恢复到最初的位置,但是缓冲区中的数据内容还存在)
		buffer.clear();
		show(buffer);
		System.out.println(buffer.get());
	}

	public static void show(ByteBuffer buffer) {
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		System.out.println("***************************************");
	}
}
