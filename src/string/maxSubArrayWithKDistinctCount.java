package string;

public class maxSubArrayWithKDistinctCount {

}

// Java program to merge k sorted
// arrays of size n each.

// A min heap node
class MinHeapNode
{
    int element; // The element to be stored

    // index of the array from
    // which the element is taken
    int i;

    // index of the next element
    // to be picked from array
    int j;

    public MinHeapNode(int element, int i, int j)
    {
        this.element = element;
        this.i = i;
        this.j = j;
    }
};

// A class for Min Heap
class MinHeap
{
    MinHeapNode[] harr; // Array of elements in heap
    int heap_size; // Current number of elements in min heap

    // Constructor: Builds a heap from
    // a given array a[] of given size
    public MinHeap(MinHeapNode a[], int size)
    {
        heap_size = size;
        harr = a;
        int i = (heap_size - 1)/2;
        while (i >= 0)
        {
            MinHeapify(i);
            i--;
        }
    }

    // A recursive method to heapify a subtree
    // with the root at given index This method
    // assumes that the subtrees are already heapified
    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l].element < harr[i].element)
            smallest = l;
        if (r < heap_size && harr[r].element < harr[smallest].element)
            smallest = r;
        if (smallest != i)
        {
            swap(harr, i, smallest);
            MinHeapify(smallest);
        }
    }

    // to get index of left child of node at index i
    int left(int i) { return (2*i + 1); }

    // to get index of right child of node at index i
    int right(int i) { return (2*i + 2); }

    // to get the root
    MinHeapNode getMin()
    {
        if(heap_size <= 0)
        {
            System.out.println("Heap underflow");
            return null;
        }
        return harr[0];
    }

    // to replace root with new node
    // "root" and heapify() new root
    void replaceMin(MinHeapNode root) {
        harr[0] = root;
        MinHeapify(0);
    }

    // A utility function to swap two min heap nodes
    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // A utility function to print array elements
    static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    // This function takes an array of
    // arrays as an argument and All
    // arrays are assumed to be sorted.
    // It merges them together and
    // prints the final sorted output.
    static void mergeKSortedArrays(int[][] arr, int k)
    {
        MinHeapNode[] hArr = new MinHeapNode[k];
        int resultSize = 0;
        for(int i = 0; i < arr.length; i++)
        {
            MinHeapNode node = new MinHeapNode(arr[i][0],i,1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }

        // Create a min heap with k heap nodes. Every heap node
        // has first element of an array
        MinHeap mh = new MinHeap(hArr, k);

        int[] result = new int[resultSize];	 // To store output array

        // Now one by one get the minimum element from min
        // heap and replace it with next element of its array
        for(int i = 0; i < resultSize; i++)
        {

            // Get the minimum element and store it in result
            MinHeapNode root = mh.getMin();
            result[i] = root.element;

            // Find the next element that will replace current
            // root of heap. The next element belongs to same
            // array as the current root.
            if(root.j < arr[root.i].length)
                root.element = arr[root.i][root.j++];
                // If root was the last element of its array
            else
                root.element = Integer.MAX_VALUE;

            // Replace root with next element of array
            mh.replaceMin(root);
        }

        printArray(result);

    }

    // Driver code
    public static void main(String args[]){
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 1000},
                {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        mergeKSortedArrays(arr,arr.length);
    }
};

// This code is contributed by shubham96301

// Java program to construct a tree using inorder and preorder traversal

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class Node {
    char data;
    Node left, right;

    Node(char item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    static int preIndex = 0;

    /* Recursive function to construct binary of size len from
    Inorder traversal in[] and Preorder traversal pre[].
    Initial values of inStrt and inEnd should be 0 and len -1.
    The function doesn't do any error checking for cases where
    inorder and preorder do not form a tree */
    Node buildTree(char in[], char pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

		/* Pick current node from Preorder traversal using preIndex
		and increment preIndex */
        Node tNode = new Node(pre[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data);

		/* Using index in Inorder traversal, construct left and
		right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of value in arr[start...end]
    The function assumes that value is present in in[] */
    int search(char arr[], int strt, int end, char value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}

// This code has been contributed by Mayank Jaiswal

