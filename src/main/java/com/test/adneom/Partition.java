package com.test.adneom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: Mdao032
 * Sept 2019
 */

class Partition
{
    // Entry list (initial partition)
    private static List<Integer> list = new ArrayList<Integer>(
            Arrays.asList(1,2,3,4,8,9));

    // subpartitions size
    private static int size = 2;

    // process function
    public static<T> List[] partition(List<T> list, int n)
    {
        // get size of the list
        int size = list.size();

        // calculate number of subpartitions j of size n each
        int j = size / n;
        if (size % n != 0)
            j++;

        // create j empty lists
        List<T>[] partition = new ArrayList[j];
        for (int i = 0; i < j; i++)
            partition[i] = new ArrayList();

        // process each element of the list and add it corresponding
        for (int i = 0; i < size; i++)
        {
            int index = i / n;
            partition[index].add(list.get(i));
        }

        // return the lists
        return partition;
    }

    // partition initial list into multiple sublists
    public static void main(String[] args)
    {
        // partition initial list into subpartitions in f(size)
        List<Integer>[] partition = partition(list, size);

        // print the subpartitions
        for (int i = 0; i < partition.length; i++)
            System.out.println("Partition " + (i + 1) + ": " + partition[i]);
    }
}