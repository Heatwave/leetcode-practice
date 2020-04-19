// g++ -std=c++14 contest/2020-spring/ju-qing-hong-fa-shi-jian.cpp

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
    int status[10005][3];

  public:
    vector<int> getTriggerTime(vector<vector<int>> &increase, vector<vector<int>> &requirements)
    {
        int increaseSize = increase.size();

        for (int i = 0; i < increaseSize; ++i)
            for (int j = 0; j < 3; ++j)
                status[i + 1][j] = status[i][j] + increase[i][j];

        vector<int> res;
        for (auto r : requirements)
        {
            int left = -1;
            int right = increaseSize + 1;
            while (left + 1 < right)
            {
                int mid = (left + right) >> 1;
                if (status[mid][0] >= r[0] &&
                    status[mid][1] >= r[1] &&
                    status[mid][2] >= r[2])
                    right = mid;
                else
                    left = mid;
            }

            if (right == increaseSize + 1)
                right = -1;
            res.push_back(right);
        }
        return res;
    }
};

int main()
{
    vector<vector<int>> increase = {{2, 8, 4}, {2, 5, 0}, {10, 9, 8}};
    vector<vector<int>> requirements = {{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}};
    Solution s;
    vector<int> res = s.getTriggerTime(increase, requirements);
    for (auto i : res)
        cout << i << " ";
    cout << endl;
    return 0;
}
