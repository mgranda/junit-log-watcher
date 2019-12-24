package com.aktiv;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SimpleLoggerExtension.class)
public class TestLog {

//	@RegisterExtension
//	public SimpleLoggerExtension jUnitLoggerExtension = new SimpleLoggerExtension();

	@DisplayName("Test test0")
	@Test
	@Disabled
	public void test0() throws InterruptedException {
		this.logEverythingOnce();
	}

	@DisplayName("Test test1")
	@Test
	public void test1() throws InterruptedException {
		this.logEverythingOnce();
		Thread.sleep(1000);
	}

	@DisplayName("Test test2")
	@Test
	public void test2() throws InterruptedException {
		this.logEverythingOnce();
		Thread.sleep(1000);
	}

	@DisplayName("Test test3")
	@Test
	public void test3() throws InterruptedException {
		this.logEverythingOnce();
		Thread.sleep(1000);
	}

	@DisplayName("Test test4")
	@Test
	public void test4() throws InterruptedException {
		this.logEverythingOnce();
		Thread.sleep(1000);
	}
	
	@DisplayName("Test test5")
	@Test
	public void test5() throws InterruptedException {
		Thread.sleep(1000);
		throw new UnsupportedOperationException("Error");
	}

	private void logEverythingOnce() {
		log.trace("Some trace message");
		log.debug("Some debug message");
		log.info("Some info message");
		log.warn("Some warn message");
		log.error("Some error message");
	}
}
