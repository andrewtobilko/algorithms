## The quicksort algorithm

- has a worse-case running tine of O(n2)
- is remarkably efficient on the average
    - O(nlogn)
    - the constant factors are quite small
- sorts in place
- works well in virtual-memory environments

---

- **divide**: divide the array into `A[p..q-1]` and `A[q+1..r]` subarrays such that `V A[p..q-1] <= A[q]` and `V A[q+1..r] >= A[q]`. Compute the index `q`.
- **conquer**: sort the subarrays `A[p..q-1]` and `A[q+1..r]` by calling quicksort recursively 
- **combine**: `A[p..r]` is sorted since all the subarrays are already sorted.

---

    if p < r
        q = partition(A, p, q)
        quicksort(A, p, q - 1)
        quicksort(A, q + 1, r)
    
