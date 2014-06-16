package com.Codility.Massimo;
/*
 * A binary tree is either an empty pointer or a node that consists of an integer value and two sub trees. 
 * A binary tree T is given. A node of that tree containing value V is described as visible if the path 
 * from the root of the tree to the node does not contain a node with any value exceeding V. In particular 
 * the root node is always visible and nodes with values lower than that of the root node are never visible.
 * 
 * Assume the following declarations are given
 * 
 * Class Tree 
 * {
 *   public int x;
 *   public Tree l;
 *   public Tree r; 
 * }
 * Write a function:
 *
 * Class Solution { int solution(Tree T);}
 * that given a binary tree T consisting of N nodes, returns the number of visible nodes.
 * 
 * Assume that:
 * 
 * .N is an integer within the range of [0....1,000,000] .each element of tree T is an integer with in the 
 * range [-1,000,000...1,000,000]
 * 
 * For example, given tree T that has the following structure
 * 
 * 
 *         5
 *        / \      
 *      3   10
 *     / \  / 
 *    20  21 1
 * 
 * the function should return 4, because there are 4 visible nodes, namely those with values 5,10,20 and 21. 
 * The node with the value 1 is not visible because there is a node with a value 10 on the path from the root 
 * to that node and 10 exceeds 1. The node with value 3 is not visible because its value is lower than that of 
 * the root node, which has a value of 5.
 * 
 * Given the Tree T has the following structure:
 * 
 *       8
 *      / \
 *     2   6
 *    / \       
 *   8   7
 * the function should return 2 since the only visible nodes are with value 8.
 */

public class TraversingBinaryTree {

}
