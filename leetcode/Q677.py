#!/usr/bin/env python3
# -*- coding:utf-8 -*-

class MapSum:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.datadict = {}

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        self.datadict[key] = val

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        datasum = 0
        for key in self.datadict.keys():
            if (str(key).startswith(prefix)):
                datasum += self.datadict[key]
        return datasum
