import numpy as np
import pandas as pd
n = int(input("enter the size of array\n"))
arr = []
print("enter array elements")
for i in range(0,n):
    arr.append(int(input()))
print(arr)
print("arrayshape-->",np.shape(arr))
for i in range(len(arr)):
    arr[i] = arr[i]%3
print(arr)
print(4%3)
