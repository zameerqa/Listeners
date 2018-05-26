package retrylogic.runtime;
/*
 * author : zameer
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
/**
 * Listeners
 * 
 * As the name suggests Listeners "listen" to the event defined in the selenium script and behave accordingly. 
 * 
 * 
 * Implementing Retry Logic at Run time means implementing Retry Logic for all the test cases that are going to fail at run time
 * This can be achieved by following two steps
 * 
 * Step 1:
 * 
 * First we need to create a user defined class that contains retry logic code and in this package retry logic code is available in RetryLogic class
 * Second thing is to create a user defined class that implements " IAnnotationTransformer " Interface and over riding the method i.e., transform() present in interface
 * IAnnotationTransformer " Interface contains only one method i.e., transform()
 * In transform() we are invoking " setRetryAnalyzer() " which belongs to " ITestAnnotation "
 * We need to pass one parameter to setRetryAnalyzer() i.e., name of the class where retry logic code is available
 * 
 * Step 2:
 * 
 * Add listeners to an existing xml file or Create a new xml file(i.e., create a suite and add all the classes that are required for the suite) 
 * To add listeners into xml file after the <suite> tag/node declare listeners tag/node i.e., <listeners> and add the class name which is implementing " IAnnotationTransformer " interface and here our implementation class is RetryLogicRuntime
 * For E.g., 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <suite name="Sanity suite for Google" parallel="tests" >
		<listeners>
			<listener class-name="org.testng.suites.RetryLogicRuntime"/>
		</listeners>
  		<test name="Default test" >
  			<parameter name="browser" value="firefox" />
			<classes>
			<class name="org.testng.suites.GooglePage" />
			<class name="org.testng.suites.FacebookPage" />
			</classes>
		</test>
		<test name="Default test1" parameter="tests">
			<parameter name="browser" value="chrome" />
			<classes>
			<class name="org.testng.suites.GooglePage" />
			<class name="org.testng.suites.FacebookPage" />
			</classes>
		</test>
	</suite>
 */
public class RetryLogicRuntime implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor constructor, Method method) {
		annotation.setRetryAnalyzer(RetryLogic.class);

	}


}
