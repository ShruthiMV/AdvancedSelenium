package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssests {
	
	

@Test(enabled=false)
public void m1() {
	
	System.out.println("Step1");
	System.out.println("Step2");
	Assert.assertEquals(false, true);
	System.out.println("Step3");
	System.out.println("Step4");
	
}

@Test(enabled=false)

public void m2() {
	
	System.out.println("Step1");
	System.out.println("Step2");
	Assert.assertEquals(false, true);
	System.out.println("Step3");
	System.out.println("Step4");
	
}

@Test(enabled=false)

public void m3() {
int a=10;
int b=10;
	Assert.assertEquals(a, b);
	System.out.println("Step3");
	
	
}

@Test(enabled=false)

public void m4() {
int a=10;
int b=12;
	Assert.assertEquals(a, b, "not equlas");
	System.out.println("Step3");
	
	
}

@Test(enabled=false)

public void m5() {
   String s1="Shruthi";
   String s2="Shruthi";
   Assert.assertTrue(s1.equalsIgnoreCase(s2),"False==");
   System.out.println("true");
}

@Test(enabled=false)

public void m6() {
	  String s1="Shruthi";
	   String s2="Shruth";
	Assert.assertFalse(s1.equalsIgnoreCase(s2),"Equals");
	System.out.println("data not equal");
	
	
}

@Test(enabled=false)

public void m7() {
	
	String s=null;
	Assert.assertNull(s, "it is not null");
	System.out.println("it is null");
}

@Test(enabled=false)

public void m8() {
	
	String s="hello";
	Assert.assertNull(s, "it is not null");
	System.out.println("it is null");
}

@Test(enabled=false)

public void m9() {
	
String s1="hello";
String s2="hello";
Assert.assertSame(s2, s1, "it is not same");
System.out.println("it is same");
}

@Test

public void m10() {
	
	String s1="hello";
	String s2="hell";
	Assert.assertNotSame(s2, s1, "it is not same");
	System.out.println("it is same");
}
@Test

public void m11() {
	
	Assert.fail("failing the test script");
	
}

}
