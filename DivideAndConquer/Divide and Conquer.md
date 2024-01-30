## Divide and conquer (D&C) is one of the most important paradigms in algorithm design and is widely used.

A divide-and-conquer algorithm works by recursively breaking the problem down into two or more subproblems of the same or related type, until these subproblems become simple enough to be solved directly [1]. Then one combines the results of subproblems to form the final solution.
As you can see, divide-and-conquer algorithm is naturally implemented in the form of recursion. Another subtle difference that tells a divide-and-conquer algorithm apart from other recursive algorithms is that we break the problem down into two or more subproblems in the divide-and-conquer algorithm, rather than a single smaller subproblem. The latter recursive algorithm sometimes is called decrease and conquer instead, such as Binary Search.

There are in general three steps that one can follow in order to solve the problem in a divide-and-conquer manner.

1. Divide. Divide the problem 
{S1,S2,...Sn}
 } where n≥2
n≥2, i.e. there are usually more than one subproblem.

2. Conquer. Solve each subproblem recursively. 

3. Combine. Combine the results of each subproblem.

Fig 1. General Steps involved in Divide-and-Conquer Algorithms

In the following articles, we will show you some classic examples of divide-and-conquer algorithms, such as Merge Sort and Quick Sort. We also present a template which could help you design divide-and-conquer algorithm, along with examples on how to apply the template to real problems.
