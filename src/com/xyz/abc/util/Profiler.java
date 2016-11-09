package com.xyz.abc.util;

/**
 * 可以在多线程种使用，也可以在不同线程种使用
 * 
 * @author heyubo
 * 
 */
public class Profiler {
	// 即使是static final,每个线程亦将调用一次，在每次get调用时将初始化（如果没有调用set方法）
	private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
		@Override
		protected Long initialValue() {
			return System.nanoTime();
		}
	};

	public static final void begin(String businessInfo) {
		TIME_THREADLOCAL.set(System.nanoTime());
	}

	public static final long end(String businessInfo) {
		long interval = System.nanoTime() - TIME_THREADLOCAL.get();
		System.out.println(ensureNotNull(businessInfo) + "本次运行时间" + interval + "纳秒"//
				+ "，即" + interval / 1000000 + "ms"//
		);
		return interval;
	}

	private static String ensureNotNull(String str) {
		return str == null ? "" : str;
	}
}
