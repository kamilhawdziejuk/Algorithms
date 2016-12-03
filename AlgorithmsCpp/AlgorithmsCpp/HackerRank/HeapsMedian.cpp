#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
#include <memory>
#include <iomanip>

using namespace std;

//https://www.hackerrank.com/challenges/ctci-find-the-running-median

/*
 * The solution is using two heaps or two priority queues, one max the other min, and always balanced.
 *  By balanced, it means the difference of the length of each data structure should be less than or equal to 1.
 *   And the min data structure should store the highest half of the sorted list and the max structure needs to
 *   store the lowest of the sorted list. In this way the insersion will take place in O(logn) and finding the
 *   median in O(1) as access time to top element of heap or priority queue is O(1).
*/


class HeapsMedian
{
public:
	priority_queue<int, vector<int>, less<int> > lower = priority_queue<int, vector<int>, less<int> >();
	priority_queue<int, vector<int>, greater<int> > higher = priority_queue<int, vector<int>, greater<int> >();

	void add(int i){
	    if(lower.empty())
	        lower.push(i);
	    else{
	        if(lower.size() > higher.size()){
	            if(lower.top() > i){
	                higher.push(lower.top());
	                lower.pop();
	                lower.push(i);
	            }
	            else
	                higher.push(i);
	        }
	        else{
	            if(higher.top() >= i)
	                lower.push(i);
	            else{
	                lower.push(higher.top());
	                higher.pop();
	                higher.push(i);
	            }
	        }
	    }
	}

	double find(){
	    int n = lower.size() + higher.size();
	    return (n % 2 == 0) ? (higher.top() + lower.top())/2.0 : (double)(lower.top());

	}
};


int mainHeapsMedian(){

	shared_ptr<HeapsMedian> p(new HeapsMedian);
    int n;
    cin >> n;
    double d;
    for(int a_i = 0;a_i < n;a_i++){
       cin >> d;
       p->add(d);
       cout << fixed << setprecision(1) << p->find() << endl;
    }
    return 0;
}
