package com.labs1904.hwe.exercises

object StretchProblems {

  /*
  Checks if a string is palindrome.
 */
  def isPalindrome(s: String): Boolean = {
    val listOfChars = s.toList
    val reversedChars = listOfChars.reverse
    val reversed = reversedChars.mkString("")
    if (s == reversed){
      true
    } else {
      false
    }
  }

  /*
For a given number, return the next largest number that can be created by rearranging that number's digits.
If no larger number can be created, return -1
 */
  def getNextBiggestNumber(i: Integer): Int = {
    
    0
  }

}
