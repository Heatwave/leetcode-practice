/**
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

#include <stdlib.h>
#include <stdio.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *twoSum(int *nums, int numsSize, int target, int *returnSize)
{
    size_t i, j;
    int hasRes = 0;
    for (i = 0; i < numsSize && !hasRes; i++)
    {
        for (j = i + 1; j < numsSize && !hasRes; j++)
        {
            if (nums[i] + nums[j] == target)
            {
                hasRes = 1;
            }
        }
    }
    int *res = (int *)malloc(sizeof(int) * 2);
    res[0] = i - 1;
    res[1] = j - 1;
    *returnSize = 2;
    return res;
}

int main()
{
    const int numsSize = 4;
    int nums[4] = {2, 7, 11, 15};
    int target = 9;
    int returnSize = 0;
    int *res = twoSum(nums, numsSize, target, &returnSize);
    printf("[%d,%d]", res[0], res[1]);
    return 0;
}
