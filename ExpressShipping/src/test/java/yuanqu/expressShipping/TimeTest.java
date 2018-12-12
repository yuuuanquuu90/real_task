package yuanqu.expressShipping;

import org.junit.Test;

public class TimeTest {
	@Test
	public void test() {
		double time = 8047.70 / (60 / 3.6);
		System.out.println((int)time/60);
		System.out.println(time%60);
	}

//	public String printTime(double time) {
//		double minutes = time % 60;
//		double seconds = time - 60 * minutes;
//		return df.format(minutes) + "min:" + df.format(seconds) + "s";
//	}
}
