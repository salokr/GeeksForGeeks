/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author ashutosh
 */
/*
Given an array of of size n and a number k, find all elements that appear more than n/k times
Given an array of size n, find all elements in array that appear more than n/k times. For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times. There are two elements that appear more than two times, 2 and 3.

A simple method is to pick all elements one by one. For every picked element, count its occurrences by traversing the array, if count becomes more than n/k, then print the element. Time Complexity of this method would be O(n2).

A better solution is to use sorting. First, sort all elements using a O(nLogn) algorithm. Once the array is sorted, we can find all required elements in a linear scan of array. So overall time complexity of this method is O(nLogn) + O(n) which is O(nLogn).
*/

//ONE APPROACH IS TO USE HASHING  <- SIMPLE BUT TAKES SPACE, TETRIS MMETHOD IS EFFICIENT IN BOTH SPACE AND TIME
public class ArrayofSizenAndaNumberkFindAllElementsThatAppearMoreThannBYkTimes 
{
    
}
