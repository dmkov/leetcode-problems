## Arrays
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |
| 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)<br>(medium) | Given an array of integers, return the K most frequent elements. | Heap:<br>1. Count how many times each integer occurs in the list.<br>2. Get the top K elements using heapq.nlargest O(nlogK) |

## Binary Search
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |
| 81 | [Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)<br>(medium) | Given an array sorted but then rotated at unknown pivot index, try to find if the given number exist or not in the list. | Binary Search:<br>1. If start element is smaller than end, we can do a binary search<br>2. Until then, do a conquire and divine approach until you can do a search. O(logN) or O(N)? |

## Bitwise operation
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |
| 1356 | [Sort Integers by The Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/)<br>(easy) | Given a list of numbers, sort it by the number of 1s in the binary representation. | Sort and right shift:<br>1. Create a map with number of 1s, use right shift with mask "1" until the number is 0<br>2. Use sort with a custom lambda and two fields. O(n) for map and O(logn) for sorting |


1356. Sort Integers by The Number of 1 Bits

## Data Structures
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

## Dynamic Programming
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

## Hash Tables / Sets
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

## Linked Lists
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

## Stacks / Queues
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

## Strings
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |
| 1108 | [Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address/)<br>(easy) | Update given ip address by replacing delimeter. | Iterate string:<br>1. Iterate over all characters, if the character is ".", then insert a new delimeter, otherwise copy a character to the new string. O(n) |
| 2109 | [Adding Spaces to a String](https://leetcode.com/problems/adding-spaces-to-a-string/)<br>(medium) | Given a string and array with indexes, insert spaces in the string at listed indexes. | Iterate string:<br>1. Keeping pointer at indexes array, iterate over string and construct a new one. If indexes of the char and spaces match - insert space to the new string. O(n) |

## Trees
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |
| 105 | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)<br>(medium) | Given two interger arrays for preorder and inorder lists, construct a binary tree. | Divide and conquer:<br>1. Both lists have the same unique elements. First element of preorder list is always a root.<br>2. Find root in the inorder list and recursively call method for its left and right nodes.<br>3. Do not forget to pop the root from preorder for the next iteration. O(n) |
| 173 | [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)<br>(medium) | Implement iterator over the binary search tree for inorder traversal. | Recursive:<br>1. During the initialization, put all left elements recursively to the stack.<br>2. With each next() call, pop element from stack and recursively put its right child and all left part of it into the stack.<br>3. For hasNext() check the size of the stack. O(n) |
