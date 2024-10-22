## Arrays
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)<br>(easy) | Return the max possible profit from buying stocks in one day and selling them in another based on the given array of prices. Only single purchase and selling are allowed. | Precomputed array:<br>1. Get array with max values on the right side.<br>2. Iterate from the left and check the diff for every number with prices[i] and precomputed[i+1].<br>Two pointers: 1. Use pointers to buy (i) and sell (i+1). If difference is negative, increment buy and sell to the next pair.<br>2. If the difference is positive, slide only sell and buy will find the lowest value. O(n) |

## Binary Search
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

## Bitwise operation
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

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
| 1108 | [Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address/)<br>(easy) | Update given ip address by replacing delimeter in it. | Iterate list:<br>1. Iterate over all characters, if the character is ".", then insert a new delimeter, otherwise copy a character to the new string. O(n) |

## Trees
| # | Title | Description | Basic idea |
|---| ----- | -------- | --------------------- |

