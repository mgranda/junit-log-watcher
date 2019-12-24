package com.aktiv;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestResult{
	private String displayName;
	private TestResultStatus testResultStatus;
	private String executionTime;
}