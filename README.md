### Algorithms
Contains a collection of algorithms that I have practiced while preparing for interviews or I was asked in the interviews.
You will find a few left with instructions but not yet coded, I plan to code them some time. These are in following broad categories.
I have tried to add unit tests but as always tests lag behind.

#### Categories
- array
- back tracking
- dynamic programming
- graph
- list
- matrix
- search
- sort
- stacks and queues
- stream
- string
- tree
- trie
- misc in "nocategory"




### Eventually, I have intentions to add solutions to the following problem set :) 
#### Arrays
| Problem                         | solution exists |
|---------------------------------|-------|
| Binary search                   | yes   |
| Find Maximum in Sliding Window  | no    |
| Search rotated array            | yes   |
| Find smallest common number     | no    |
| Rotate Array                    | yes   |
| Find low/high index             | no    |
| Move zeros to left              | yes   |
| Find maximum single sell profit | no    |
| Implement Quicksort             | no    |
| Merge Overlapping Intervals     | yes   |
| Sum of Two Values               | yes   |

#### Linked List
- Reverse a singly linked list
- Remove Duplicates from a Linked List
- Delete node with a given key
- Insertion Sort of a Linked List
- Intersection Point of Two Lists
- Nth from last node
- Swap Nth Node with Head
- Merge Two Sorted Linked Lists
- Merge Sort
- Reverse even nodes
- Rotate a Linked List
- Reverse k Elements
- Add Two Integers
- Copy linked list with arbitrary pointer

#### Math and Stats
- Find kth permutation
- Integer Division
- Pythagorean Triplets
- All Sum Combinations
- Find Missing Number
- Permute String
- All Subsets
- Is Number Valid?
- Power of a Number
- Calculate Square Root

#### String
- Reverse words in a sentence
- Remove Duplicates
- Remove white spaces
- String Segmentation
- XML to Tree
- Find all palindrome substrings
- Regular Expression

#### Trees
- Check if two binary trees are identical
- Write an Inorder Iterator for a Binary Tree
- Iterative Inorder Traversal
- Inorder Successor BST
- Level Order Traversal of Binary Tree
- Is Binary Search Tree?
- Convert Binary Tree To Doubly Linked List
- Print Tree Perimeter
- Connect Same Level Siblings
- Serialize/Deserialize Binary Tree
- Connect All Siblings
- Inorder Successor BST with parent pointers
- Nth Highest in BST
- Mirror binary tree nodes
- Delete zero sum sub-trees
- N-ary Tree to Binary Tree

#### Stacks and Queues
- Stack using Queues
- Queue using Stacks
- Expression Evaluation

#### Graphs
- Clone a Directed Graph
- Minimum Spanning Tree
- Word Chaining

#### Back Tracking
- Boggle
- All Possible Parentheses
- Solve N-Queens problem
- Find K-sum subsets

#### Dynamic Programming
- Fibonacci numbers
- Largest Sum Subarray
- MaxSum Subsequence - Nonadjacent Elements
- Game Scoring: Find number of ways a player can score 'n' runs
- Coin Changing Problem
- Levenshtein Distance

#### Miscellaneous
- Sum of Three Values
- Make Columns and Rows Zeros
- Search in a Matrix
- Implement LRU Cache
- Host Endianness
- Closest Meeting Point

### Brief note on Data Structures
#### Array
I’m not kidding when I say that the basic array is the most important data structure in machine learning, and there is more to this bread-and-butter type than you might think. 
Arrays are important because they are used in linear algebra: the most useful and powerful mathematical tool at your disposal.

Therefore, the most common types will be the one- and two-dimensional variety, corresponding to vectors and matrices respectively, but you will occasionally 
encounter three- or four-dimensional arrays either for higher ranked tensors or to group examples of the former.

When doing matrix arithmetic, you will have to choose from a dizzying variety of libraries, data types, and even languages. Many scientific programming languages such as 
Matlab, Interactive Data Language (IDL), and Python with the Numpy extension are designed primarily for working with vectors and matrices.

But the nice thing about these data structures is that, even in more general-purpose programming languages, implementing vectors and matrices is straightforward 
right next to the metal, assuming the language has any Fortran DNA in it at all. Consider the translation of matrix-vector multiplication:
into C++:

```
for (int i=0; i<n; i++) {
  y[i]=0;
  for (int j=0; j<n; j++) y[i]+=a[i][j]*x[j]
}
```

#### Linked list
A linked list consists of several separately allocated nodes. Each node contains a data value plus a pointer to the next node in the list. Insertions, 
at constant time, are very efficient, but accessing a value is slow and often requires scanning through much of the list.

#### Binary tree
A binary tree is similar to a linked list except that each node has two pointers to subsequent nodes instead of just one. The value in the left child is 
always less than the value in the parent node, which in turn is smaller than that of the right child. Thus, data in binary trees is automatically sorted from left to right. 
Both insertion and access are efficient at O(log n) on average. Like linked lists, they are easy to transform into arrays and this is the basis for a tree-sort.

#### Heap
A heap is another hierarchical, ordered data structure similar to a tree except instead of a horizontal ordering, it has a vertical ordering. 
This ordering applies along the hierarchy, but not across it: the parent is always larger than both its children, but a node of higher rank 
is not necessarily larger than a lower one that’s not directly beneath it.

Both insertion and retrieval are performed by promotion. An element is first inserted in the highest available position. Then it is compared with its parent 
and promoted until it reaches the right rank. To take an element off the heap, the larger of the two children is promoted to the missing position, then the larger 
of those two children is promoted and so on until everything has trickled up the ranks.

Typically, the highest ranking value at the top is pulled off the heap in order to sort a list. Unlike a tree, most heaps are simply stored in an array 
with the relationships between elements only implicit.

#### Balanced tree
If the data is already already sorted, binary trees are less efficient at O(n) worst case since the data will be laid out linearly as if it were a linked list. 
While the ordering in a binary tree is constrained, it is by no means unique and the same list can be arranged in many different configurations depending on the 
order in which it is inserted.
There are several transformations that can be applied to a tree in order to make it more balanced. Self-balancing trees perform these operations automatically 
in order to keep access and insertion at an optimal average.

#### Stack
A stack is defined as “first in, last out.” An element is pushed onto the top of the stack where it covers the previous element. The top element must be popped 
off before any of the others can be accessed.

Stacks are mainly useful for parsing grammars and implementing computer languages.

#### Queue
A queue is defined as “first in, first out.”

#### Set
A set consists of an un-ordered list of non-repeating elements.

#### Associative arrays
In an associative array, there are two types of data which are stored in pairs: the key and its associated value. 
The data structure is relational in nature: the value is addressed by its key. Associative arrays are good for building dictionaries.

