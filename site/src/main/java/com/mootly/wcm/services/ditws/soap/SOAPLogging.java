package com.mootly.wcm.services.ditws.soap;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class SOAPLogging {
	final Logger logger = LoggerFactory.getLogger(SOAPLogging.class);

	@Pointcut("execution(* *.callWebService(..))")
	private void analyzeBeanExecution() { }
	
	
	@Around("analyzeBeanExecution()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		String withinType = pjp.getSourceLocation().getWithinType().toString();
		logger.debug("Before being processed by processor:" + withinType);
		//System.out.println("pjp.getSignature().getName():" + pjp.getSignature().getName());
		logger.debug("Arrays.toString(pjp.getArgs()):" + Arrays.toString(pjp.getArgs()));		
		//System.out.println("Arrays.toString(pjp.getArgs()):" + pjp.getSourceLocation().getWithinType());
		Object ret = pjp.proceed();
		logger.debug("After being processed by processor:" + withinType);
		//System.out.println("pjp.getSignature().getName():" + pjp.getSignature().getName());
		logger.debug("Arrays.toString(pjp.getArgs()):" + Arrays.toString(pjp.getArgs()));
		return ret;
	}

	@After("analyzeBeanExecution()")
	public void afterCall(JoinPoint jp) {
		//System.out.println("After Call");
	}

	@AfterThrowing(pointcut="analyzeBeanExecution()",throwing="ex")	
	public void afterThrowingCall(JoinPoint jp,Exception ex) {	
		logger.error(jp.getTarget().getClass().getName(),ex);
		//KSMDoc ksmDoc =  (KSMDoc) jp.getArgs()[0];
		//logger.error("Analyzer Exception " + ksmDoc.toString());
	}	
}
