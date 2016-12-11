#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

struct Player {
    string name;
    int score;

    static bool comp(const Player &p1, const Player &p2)
    {
        if (p1.score > p2.score) return true;
        if (p1.score < p2.score) return false;
        if (p1.name < p2.name) return true;
        if (p1.name > p2.name) return false;
        return true;
    }
};

bool compare(const Player &p1, const Player &p2)
{
        if (p1.score > p2.score) return true;
        if (p1.score < p2.score) return false;
        if (p1.name < p2.name) return true;
        if (p1.name > p2.name) return false;
        return true;
}


int partition(vector<Player>& data, int left, int right, Player pivot)
{
    while (left<=right)
    {
        while (compare(data[left], pivot)) left++;
        while (compare(pivot, data[right])) right--;
        if (left <= right)
        {
            swap(data[left], data[right]);
            left++;
            right--;
        }
    }
    return left;
}

void quickSort(vector<Player> &data, int left, int right)
{
    if (left >= right) return;

    int pivotIndex = left + (right - left)/2;
    Player pivot = data[pivotIndex];
    int part = partition(data, left, right, pivot);
    quickSort(data, left, part - 1);
    quickSort(data, part, right);
}

vector<Player> comparator(vector<Player> players) {
    //sort(players.begin(), players.end(), Player::comp);
    quickSort(players, 0, players.size()-1);
    return players;
}

int mainComparatorSorting() {

    int n;
    cin >> n;
    vector< Player > players;
    string name;
    int score;
    for(int i = 0; i < n; i++){
        cin >> name >> score;
        Player p1;
        p1.name = name, p1.score = score;
        players.push_back(p1);
    }

    vector<Player > answer = comparator(players);
    for(int i = 0; i < answer.size(); i++) {
        cout << answer[i].name << " " << answer[i].score << endl;
    }
    return 0;
}
