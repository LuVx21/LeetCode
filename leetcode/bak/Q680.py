#!/usr/bin/env python3
# -*- coding:utf-8 -*-

class Solution:
    def validPalindrome(self, str):
        """
        :type s: str
        :rtype: bool
        """
        length = len(str)
        halflength = math.ceil(length / 2)
        if (str == str[::-1]):
            return True
        else:
            for i in range(halflength):
                if(str[i] != str[length - 1 - i]):
                    for j in range(i, halflength):
                        if(str[j + 1] != str[length - 1 - j] and str[j] != str[length - j - 2]):
                            return False
                    return True
