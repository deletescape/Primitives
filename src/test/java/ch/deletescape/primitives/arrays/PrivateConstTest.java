package ch.deletescape.primitives.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * "Pseudo test" to get coverage for private empty constructors.
 * Yes, I don't like this. Yes it is ugly, but it makes the coverage reports a lot more readable
 * 
 * @author deletescape
 */
public class PrivateConstTest {

  @Test
  public void test() throws Exception {
    Class<?>[] classes = new Class[] { PrBoolArray.class, PrByteArray.class, PrCharArray.class, PrDoubleArray.class,
        PrFloatArray.class, PrIntArray.class, PrLongArray.class, PrShortArray.class };
    for (Class<?> clazz : classes) {
      Constructor<?> constructor = clazz.getDeclaredConstructor();

      // Constructor should be private
      assertThat(constructor.isAccessible(), is(false));

      constructor.setAccessible(true);
      constructor.newInstance();
    }
  }

}
