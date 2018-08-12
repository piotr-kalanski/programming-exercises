import math
import os
import random
import re
import sys
from collections import Counter


# Complete the freqQuery function below.
def freqQuery(queries):
    result = []
    
    countsOfElements = Counter()
    numberOfElementsWithFrequency = Counter()
    
    for query in queries:
        operation = query[0]
        element = query[1]
        
        countOfElement = countsOfElements[element]
        
        if operation == 1:
            countsOfElements[element] = countOfElement + 1

            numberOfElementsWithFrequency[countOfElement] -= 1;
            numberOfElementsWithFrequency[countOfElement + 1] += 1;
        elif operation == 2 and countOfElement > 0:
            countsOfElements[element] = countOfElement - 1

            numberOfElementsWithFrequency[countOfElement] -= 1;
            numberOfElementsWithFrequency[countOfElement - 1] += 1;
        elif operation == 3:
            result.append(1 if numberOfElementsWithFrequency[element] > 0 else 0)
    
    return result

freqQuery([[3,4], [2, 1003], [1, 16], [3, 1]])
freqQuery([[1,5], [1,6], [3, 2], [1,10], [1, 10], [1, 6], [2, 5], [3, 2]])

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    ans = freqQuery(queries)

    fptr.write('\n'.join(map(str, ans)))
    fptr.write('\n')

    fptr.close()
