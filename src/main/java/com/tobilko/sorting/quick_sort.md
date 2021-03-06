## The quicksort algorithm

- has a worse-case running tine of O(n2)
- is remarkably efficient on the average
    - O(nlogn)
    - the constant factors are quite small
- sorts in place
- works well in virtual-memory environments

#### The idea

- **divide**: divide the array into `A[p..q-1]` and `A[q+1..r]` subarrays such that `V A[p..q-1] <= A[q]` and `V A[q+1..r] >= A[q]`. Compute the index `q`.
- **conquer**: sort the subarrays `A[p..q-1]` and `A[q+1..r]` by calling quicksort recursively 
- **combine**: `A[p..r]` is sorted since all the subarrays are already sorted.

---

    if p < r
        q = partition(A, p, q)
        quicksort(A, p, q - 1)
        quicksort(A, q + 1, r)
    

#### Partitioning the array

The `partition` procedure rearranges the array `A[p..r]` in place.

---

    partition(A, p, r)
        x = A[r]
        i = p - 1
        
        from j = p to r - 1
            if (A[j] > x)
                ++i
                swap(A, j, i)
        
        swap(A, ++i, r)
        
        return i;


