package com.aktiv;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jgranda
 */
@Slf4j
public class SimpleLoggerExtension implements TestWatcher, BeforeEachCallback, AfterAllCallback {

	private List<TestResult> testResultsStatus = new ArrayList<>();

	private StopWatch timer;

	public SimpleLoggerExtension() {
	}

	public void testSuccessful(ExtensionContext context) {
		this.registerTime(context, TestResultStatus.SUCCESS);
	}

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		log.info("Test Disabled for test {}: with reason :- {}", context.getDisplayName(), reason.orElse("No reason"));
		this.testResultsStatus.add(TestResult.builder().testResultStatus(TestResultStatus.DISABLED)
				.displayName(context.getDisplayName()).executionTime(NumberUtils.INTEGER_ZERO.toString()).build());
	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
		this.registerTime(context, TestResultStatus.ABORTED);
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		this.registerTime(context, TestResultStatus.FAILED);
	}

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		if (log.isInfoEnabled()) {
			log.info("START: {} method: {}", context.getTestClass().get(), context.getDisplayName());
		}
		this.timer = StopWatch.createStarted();
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		log.info("===============================================================");
		this.testResultsStatus.forEach(e -> logInfo("SUMMARY", e));
		log.info("===============================================================");
	}

	private void registerTime(final ExtensionContext context, final TestResultStatus testResultStatus) {
		this.timer.stop();
		final TestResult testResult = TestResult.builder().testResultStatus(testResultStatus)
				.displayName(context.getDisplayName()).executionTime(timer.toString()).build();
		this.logInfo("FINISH", testResult);
		this.testResultsStatus.add(testResult);
	}

	private void logInfo(final String reason, final TestResult testResult) {
		if (log.isInfoEnabled()) {
			log.info("{} {}: {}, execution time: {}", reason, testResult.getTestResultStatus().name(),
					testResult.getDisplayName(), testResult.getExecutionTime());
		}
	}
}
