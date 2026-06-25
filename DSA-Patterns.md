# DSA Coding Problems Notes

Here are all the key dsa patterns you should know, organized by priority for Java/DSA coding problems:

---

### Priority 1 — Almost certainly tested



**1. HashMap / HashSet**

```

Problems:

- Two Sum

- Contains Duplicate

- Group Anagrams

- Longest Substring Without Repeating Characters

- First Non-Repeating Character

- Intersection of Two Arrays



Core idea:

Use HashMap for O(1) lookup instead of O(n) nested loops

Use HashSet for duplicate detection

```



---



**2. Sliding Window**

```

Problems:

- Longest Substring Without Repeating Characters

- Maximum Sum Subarray of Size K

- Minimum Window Substring

- Fruits Into Baskets

- Longest Repeating Character Replacement



Core idea:

Fixed window  — window size given in problem

Variable window — expand right, shrink left when condition breaks

```



---



**3. Two Pointers**

```

Problems:

- Valid Palindrome

- Container With Most Water

- 3Sum

- Remove Duplicates from Sorted Array

- Merge Sorted Array

- Sort Colors (Dutch National Flag)



Core idea:

Left and right pointers moving toward each other

OR slow and fast pointer on same direction

```



---



**4. Prefix Sum**

```

Problems:

- Subarray Sum Equals K

- Range Sum Query

- Product of Array Except Self

- Find Pivot Index



Core idea:

preSum[i] = preSum[i-1] + arr[i]

Range sum from i to j = preSum[j] - preSum[i-1]

```



Java template:

```java

int[] prefix = new int[n + 1];

for (int i = 0; i < n; i++)

    prefix[i + 1] = prefix[i] + nums[i];

// sum from index l to r

int sum = prefix[r + 1] - prefix[l];

```



---



### Priority 2 — Likely tested



**5. Binary Search**

```

Problems:

- Binary Search (basic)

- Search in Rotated Sorted Array

- Find Peak Element

- First and Last Position of Element

- Kth Smallest Element in Sorted Matrix

- Find Minimum in Rotated Sorted Array



Core idea:

Array must be sorted (or partially sorted)

Eliminate half the search space each iteration

```



Java template:

```java

int left = 0, right = nums.length - 1;

while (left <= right) {

    int mid = left + (right - left) / 2; // avoids overflow

    if (nums[mid] == target) return mid;

    else if (nums[mid] < target) left = mid + 1;

    else right = mid - 1;

}

return -1;

```



---



**6. Stack**

```

Problems:

- Valid Parentheses

- Min Stack

- Daily Temperatures

- Next Greater Element

- Evaluate Reverse Polish Notation

- Largest Rectangle in Histogram



Core idea:

Use stack for: matching brackets, monotonic sequences,

next greater/smaller element problems

```



Java template:

```java

Deque<Integer> stack = new ArrayDeque<>();

stack.push(x);    // push

stack.pop();      // pop

stack.peek();     // top without removing

stack.isEmpty();  // check empty

```



---



**7. Queue / BFS**

```

Problems:

- Level Order Traversal

- Binary Tree Right Side View

- Rotting Oranges

- Number of Islands (BFS version)

- Shortest Path in Binary Matrix

- Word Ladder



Core idea:

BFS explores level by level

Use Queue — add neighbors, process level by level

Best for: shortest path, level-based problems

```



Java template:

```java

Queue<Integer> queue = new LinkedList<>();

queue.offer(start);

while (!queue.isEmpty()) {

    int node = queue.poll();

    // process node

    // add neighbors to queue

}

```



---



**8. DFS / Recursion**

```

Problems:

- Number of Islands

- Maximum Depth of Binary Tree

- Path Sum

- Clone Graph

- Flood Fill

- Word Search

- All Paths from Source to Target



Core idea:

Go as deep as possible before backtracking

Use recursion OR explicit stack

Best for: tree/graph traversal, path finding

```



Java template:

```java

void dfs(int[][] grid, int r, int c) {

    if (r < 0 || r >= grid.length ||

        c < 0 || c >= grid[0].length ||

        grid[r][c] == 0) return;

    grid[r][c] = 0; // mark visited

    dfs(grid, r+1, c);

    dfs(grid, r-1, c);

    dfs(grid, r, c+1);

    dfs(grid, r, c-1);

}

```



---



### Priority 3 — Good to know



**9. Linked List**

```

Problems:

- Reverse Linked List

- Merge Two Sorted Lists

- Detect Cycle (Floyd's algorithm)

- Find Middle of Linked List

- Remove Nth Node from End

- Palindrome Linked List



Core idea:

Fast/slow pointer for cycle detection and middle finding

Dummy node for clean head manipulation

```



Java template — Reverse:

```java

ListNode prev = null, curr = head;

while (curr != null) {

    ListNode next = curr.next;

    curr.next = prev;

    prev = curr;

    curr = next;

}

return prev;

```



Fast/slow pointer:

```java

ListNode slow = head, fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;

    fast = fast.next.next;

}

// slow is now at middle

```



---



**10. Binary Tree**

```

Problems:

- Inorder/Preorder/Postorder Traversal

- Maximum Depth

- Same Tree

- Symmetric Tree

- Lowest Common Ancestor

- Binary Tree Maximum Path Sum

- Diameter of Binary Tree



Core idea:

Most tree problems solved with recursion

Think: what does this function return for left/right subtree

Combine left + right + root to get answer

```



---



**11. Sorting-based**

```

Problems:

- Merge Intervals

- Meeting Rooms

- Sort Colors

- Largest Number

- Top K Frequent Elements

- Kth Largest Element



Core idea:

Sort first, then solve

Custom comparator for complex sorting

```



Java custom sort:

```java

Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

// or

Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

```



---



**12. Greedy**

```

Problems:

- Best Time to Buy and Sell Stock

- Jump Game

- Gas Station

- Assign Cookies

- Minimum Number of Arrows to Burst Balloons



Core idea:

Make locally optimal choice at each step

Usually involves sorting + one pass

```



---



**13. Dynamic Programming (light — only if time permits)**

```

Problems (easy DP only):

- Climbing Stairs (Fibonacci pattern)

- House Robber

- Coin Change

- Longest Common Subsequence

- Maximum Product Subarray



Core idea:

dp[i] depends on previous states

Bottom-up: fill table iteratively

```



Climbing Stairs template:

```java

int[] dp = new int[n + 1];

dp[0] = 1; dp[1] = 1;

for (int i = 2; i <= n; i++)

    dp[i] = dp[i-1] + dp[i-2];

return dp[n];

```



---



### Priority 4 — Only if you have extra time



**14. Heap / Priority Queue**

```

Problems:

- Kth Largest Element

- Top K Frequent Elements

- Merge K Sorted Lists

- Find Median from Data Stream



Core idea:

Min heap for kth largest

Max heap for kth smallest

```



Java template:

```java

// Min heap (default)

PriorityQueue<Integer> minHeap = new PriorityQueue<>();



// Max heap

PriorityQueue<Integer> maxHeap = 

    new PriorityQueue<>(Collections.reverseOrder());



minHeap.offer(val);  // add

minHeap.poll();      // remove smallest

minHeap.peek();      // view smallest

```



---



**15. Backtracking**

```

Problems:

- Subsets

- Permutations

- Combination Sum

- Letter Combinations of Phone Number

- N-Queens



Core idea:

Explore → Make choice → Recurse → Undo choice

Use when: need all possible combinations/permutations

```



Template:

```java

void backtrack(List<List<Integer>> result,

               List<Integer> current,

               int[] nums, int start) {

    result.add(new ArrayList<>(current));

    for (int i = start; i < nums.length; i++) {

        current.add(nums[i]);

        backtrack(result, current, nums, i + 1);

        current.remove(current.size() - 1); // undo

    }

}

```



---



### Pattern recognition cheat sheet



When you read a problem, ask:



```

"Find two numbers that..."     → Two Pointers or HashMap

"Subarray with sum/max/min..." → Sliding Window or Prefix Sum

"Sorted array, find..."        → Binary Search

"Tree/Graph traversal..."      → DFS or BFS

"All combinations/subsets..."  → Backtracking

"Optimal choice at each step"  → Greedy

"Overlapping subproblems..."   → Dynamic Programming

"Next greater/smaller..."      → Stack (monotonic)

"Kth largest/smallest..."      → Heap

"Matching brackets..."         → Stack

"Shortest path..."             → BFS

```

