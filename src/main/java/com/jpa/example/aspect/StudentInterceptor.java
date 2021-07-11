package com.jpa.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.jpa.example.SpringDemo;

@Aspect
@Component
@SpringDemo(data=2)
public class StudentInterceptor {
	
	@Pointcut("execution(* com.jpa.example.student.*.*())")
	public void forStudentPackage() {}
	
	@Pointcut("execution(* com.jpa.example.student.StudentServiceImpl.updateStudent(..))")
	public void updateStudent() {}
	
	@Pointcut("execution(* com.jpa.example.student.*.set*(..))")
	public void setters() {}
	
	@Pointcut("execution(* com.jpa.example.student.*.get*(..))")
	public void getters() {}
	
	@Pointcut("execution(* com.jpa.example.student.StudentServiceImpl.findStudentById(..))")
	public void test() {}
	
	
	@AfterReturning(pointcut="updateStudent()",returning="returnValue")
	public void getReturnValueAndPrint(JoinPoint jp, int returnValue) {
		
		System.out.println(">>>>>>>>>>>This is after returning Method***############## \n\n");
		
		System.out.println("The return value is " + returnValue + "\n\n");
	}
	
	
	@AfterThrowing(pointcut="test()",throwing="theExcep")
	public void getThrowingExceptionPrint(Throwable theExcep) {
		
		System.out.println("YOU ARE INSIDE POINTCUT ADVICE "+ theExcep + "\n\n");
	}
	
	
	
	@After("forStudentPackage()")
	public void thisMethodIsAfter() {
		
		System.out.println("\n\n THIS METHOD IS FOR @AFTER ANNOTATION ADVICE\n\n");
	}

	
	@Around("updateStudent()")
	public Object aroundAdviceType(ProceedingJoinPoint pjb) throws Throwable{
		
		System.out.println("You have entered @Around Advice");
		
		long mil = System.currentTimeMillis();
		Object result=null;
		
		try {
		
		 result = pjb.proceed();
		}catch(Exception e) {
			System.out.println("The exception is " + e.getMessage());
			
			//throw e; //to rethrow exception to main calling program..
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end-mil;
		
		System.out.println("The EXECUTION DURATION IS " + duration + "MS");
		
		return result;
	}
	
	
	@Before("forStudentPackage()")
	public void beforeAddAccountMethod2(JoinPoint jp) {
		
		MethodSignature sign = (MethodSignature) jp.getSignature();
		
		System.out.println("The method signtures are " + sign.toLongString());
		Object[] args = jp.getArgs();
		for(Object o: args) {
			System.out.println("The object is " +o);
		}
		
		System.out.println("....>>>This is Aspect class: and this is befor add account METHOD 2****");
	}

}
