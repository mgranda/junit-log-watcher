# junit-log-watcher
**Extension to JUnit 5 with slf4j-log4j12**

**Code**

```
@Slf4j
@ExtendWith(SimpleLoggerExtension.class)
public class TestLog {
	
	@Test
	public void test1() {
		...
	}
}
```

**Output**

START: class com.aktiv.TestLog method: Test test
Some info message
FINISH SUCCESS: Test test, execution time: 00:00:01.001

 INFO [main] (SimpleLoggerExtension.java:60) - ===============================================================
 INFO [main] (SimpleLoggerExtension.java:75) - SUMMARY SUCCESS: Test test, execution time: 00:00:01.011
 INFO [main] (SimpleLoggerExtension.java:62) - ===============================================================