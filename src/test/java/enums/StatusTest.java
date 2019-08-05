package enums;

import org.junit.Assert;
import org.junit.Test;

public class StatusTest {

  @Test
  public void test(){
    Assert.assertEquals(Status.get(0),"正常");
    Assert.assertEquals(Status.get(1),"放假");
    Assert.assertEquals(Status.get(2),"休学");
    Assert.assertEquals(Status.get(3),"开除");
  }
}
