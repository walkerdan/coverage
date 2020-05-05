package edu.depaul.se433.coverage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionFinderTest {

  private PositionFinder finder = new PositionFinder();

  /**
   * a = null
   */
  @Test
  @DisplayName("expect an exception if list is null")
  public void null_should_throw_exception() {

    assertThrows( IllegalArgumentException.class, () -> finder.findPosition(null, 5));
  }

  /**
   * a = {}
   */
  @Test
  @DisplayName("expect an exception if list is empty")
  public void test_invalid_array() {
    int[] a = new int[] {};
    assertThrows( IllegalArgumentException.class, () -> finder.findPosition(a, 5));
  }

  /**
   * a = {2}
   */
  @Test
  @DisplayName("should return -1 when item not found")
  public void test_not_there_array() {
    int[] a = new int[] {2};
    int pos = finder.findPosition(a, 5);
    assertEquals(-1, pos);
  }

  /**
   * a = {5}
   */
  @Test
  @DisplayName("should return 0 when target is only item")
  public void test_is_there_array() {
    int[] a = new int[] {5};
    int pos = finder.findPosition(a, 5);
    assertEquals(0, pos);
  }

  @Test
  @Disabled
  @DisplayName("should return 0 when target is only item")
  public void test_zero() {
    int[] a = new int[] {0};
    int pos = finder.findPosition(a, 0);
    assertEquals(0, pos);
  }



  /**
   * a = {2,5}
   */
  @Test
  @DisplayName("should return correct position of found item")
  public void test_together_array() {
    int[] a = new int[] {2,5};
    int pos = finder.findPosition(a, 5);
    assertEquals(1, pos);
  }

  @Test
  @DisplayName("Constructor test")
  public void constructor_works() {
    new PositionFinder();
  }
}
