#!/bin/python3

import math
import os
import random
import re
import sys
import collections


if __name__ == '__main__':
    s = input()

    chars_count = collections.Counter()
    for c in s:
        chars_count[c] += 1

    for e in sorted(chars_count.items(), key=lambda p: (-p[1], p[0]))[:3]:
        print(e[0] + " " + str(e[1]))
