package spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*******************************基于配置文件配置aop，注解注释掉了***************************************/


/**
 * 声明一个切面：1.需要把该类放入到ioc容器中@Component
 * 			2.再声明为一个切面
 * 			3.在配置文件中加上（当ioc容器侦测到<aop:aspectj-autoproxy> 会自动为与 AspectJ 切面匹配的 Bean 创建代理）
 * @Order:定义切面的优先级，值越小，优先级越高。比如有一个验证参数的切面，先执行验证参数，然后在记录日志。即可使用order优先级指定切面的执行顺序。
 */
//@Order(1)
//@Aspect
//@Component
public class TestAspect {
	
	
	/**
	 * 多个切入点表达式都是一样的，可以使用@Pointcut注解定义一个通用的切入点表达式，其他通知使用方法名直接使用切入点,其他包中的切面使用全类名使用。
	 * 
	 * 一般的，该方法中不需要加入其他代码。
	 * 
	 */
	//@Pointcut("execution (* spring.aop.impl.ArithmeticCalculator.*(..))")
	//public void declareJoinPoint() {}
	
	
	

	/**
	 * 前置通知
	 * execution	执行
	 *	public	int返回值
	 */
	
	/**
	 * 使用JoinPont访问链接细节
	 * 切入点表达式可以通过操作符 &&, ||, ! 结合起来 
	 * execution (public int spring.aop.impl.ArithmeticCalculator.*(int,int)) 
	 * 	&& execution (* spring.aop.impl.ArithmeticCalculator.*(..))
	 */
	//@Before("execution (public int spring.aop.impl.ArithmeticCalculator.*(..))")
	//@Before("declareJoinPoint()")
	public void testBefore(JoinPoint joinPoint ) {
		String methodName  = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("the method  " + methodName + " begins with " + args);
	}
	
	//后置通知:在目标方法执行后（无论是否发生异常），执行的通知
	//在后置通知中，还不能访问目标方法执行的结果（返回值）.因为方法可能出现异常，所以访问不到方法的返回值。
	//@After("execution (public int spring.aop.impl.ArithmeticCalculator.*(int,int))")
	//@After("declareJoinPoint()")
	public void testAfter(JoinPoint joinPoint) {
		String methodName  = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("the method  " + methodName + " after with " + args);
	}
	
	/**
	 * 返回通知：在方法正常结束后执行的代码
	 * 返回通知是可以访问到方法的返回值的
	 */
	//@AfterReturning(value = "execution (public int spring.aop.impl.ArithmeticCalculator.*(int,int))", returning="result")
	//@AfterReturning(value="declareJoinPoint()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName  = joinPoint.getSignature().getName();
		System.out.println("the method  " + methodName + " returns " + result);
	}
	
	/**
	 * 异常通知:在目标方法出现异常时会执行的代码
	 * 	可以访问到异常对象；且可以指定出现特定异常时才执行的代码Exception ex、NullPointException ex...
	 */
	//@AfterThrowing(value="execution (public int spring.aop.impl.ArithmeticCalculator.*(int,int))", throwing="ex")
	//@AfterThrowing(value="declareJoinPoint()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName  = joinPoint.getSignature().getName();
		System.out.println("the method  " + methodName + " exception : " + ex);
	}
	
	/**
	 * 环绕通知;需要携带ProceedingJoinPoint类型的参数
	 * 环绕通知类似于	动态代理的全过程！！ProceedingJoinPoint类型的参数可以决定是否执行目标方法
	 * 		且环绕通知必须有返回值，返回值即是目标方法的返回值
	 * 
	 * 功能最强（包含前、后、返回、异常通知），但并不是最常用的。
	 */
	//@Around(value="execution (public int spring.aop.impl.ArithmeticCalculator.*(int,int))")
	//@Around("declareJoinPoint()")
	public Object around(ProceedingJoinPoint pdJointPoint) {
		Object result = null;
		String methodName  = pdJointPoint.getSignature().getName();
		
		try {
			//前置通知
			System.out.println("the method " + methodName + " begins with " + pdJointPoint.getArgs());
			//执行目标方法
			result = pdJointPoint.proceed();
			
			//返回通知
			System.out.println("the method " + methodName + " returns " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("the method " + methodName + " exceptions " + e);
		}
		
		//后置通知
		System.out.println("the method " + methodName + " ends ");
		
		return result;
	}
}
