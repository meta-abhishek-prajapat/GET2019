package com.meta.junit.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.metacube.testcases.*;

@RunWith(Suite.class)
@SuiteClasses({MaxMirrorTest.class,
			   ClumpsCountTest.class,
			   FixXYTest.class,
			   SplitArrayTest.class})
public class SuiteTestClass {
}
