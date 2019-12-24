# junit-log-watcher
Extension to JUnit 5



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



Output

 INFO [main] (SimpleLoggerExtension.java:53) - START: class com.aktiv.TestLog method: Test test
 INFO [main] (TestLog.java:62) - Some info message
 INFO [main] (SimpleLoggerExtension.java:75) - FINISH SUCCESS: Test test, execution time: 00:00:01.001

 INFO [main] (SimpleLoggerExtension.java:60) - ===============================================================
 INFO [main] (SimpleLoggerExtension.java:75) - SUMMARY SUCCESS: Test test, execution time: 00:00:01.011
 INFO [main] (SimpleLoggerExtension.java:62) - ===============================================================