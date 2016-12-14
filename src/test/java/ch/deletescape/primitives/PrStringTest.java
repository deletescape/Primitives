package ch.deletescape.primitives;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PrStringTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void reverse() {
    assertThat(PrString.reverse("Test"), is("tseT"));
    assertThat(PrString.reverse("Tri"), is("irT"));
    assertThat(PrString.reverse("T"), is("T"));
    assertThat(PrString.reverse(""), is(""));
    assertThat(PrString.reverse(null), is((String) null));
  }

  @Test
  public void simpleFormat() {
    assertThat(PrString.simpleFormat("{}", "Test"), is("Test"));
    assertThat(PrString.simpleFormat("{} {}", "Test", "Test 2"), is("Test Test 2"));
    assertThat(PrString.simpleFormat("No elements supplied"), is("No elements supplied"));
    assertThat(PrString.simpleFormat("No elements supplied", (Object[]) null), is("No elements supplied"));
    assertThat(PrString.simpleFormat("{} {}", "Test", null), is("Test null"));
    assertThat(PrString.simpleFormat("{} {}", "{}", "Test"), is("{} Test"));
    assertThat(PrString.simpleFormat("{}", 1), is("1"));
  }

  @Test
  public void simpleFormatNotEnoughElements() {
    thrown.expect(SimpleFormatException.class);
    thrown.expectMessage(is("Number of elements (1) and tokens (2) doesn't match."));
    PrString.simpleFormat("{} {}", "Test");
  }

  @Test
  public void simpleFormatTooManyElements() {
    thrown.expect(SimpleFormatException.class);
    thrown.expectMessage(is("Number of elements (3) and tokens (1) doesn't match."));
    PrString.simpleFormat("{}", "Test", "Test 2", "Test 3");
  }

  @Test
  public void repeat() {
    assertThat(PrString.repeat(5, ' '), is("     "));
    assertThat(PrString.repeat(5, 'a', ' '), is("a a a a a "));
    assertThat(PrString.repeat(3, "tst"), is("tsttsttst"));
    assertThat(PrString.repeat(2, ""), is(""));
  }
}
