#include <bits/stdc++.h>

using namespace std;

int n, m;
vector<int> arr;
vector<int> res;

void dfs(int depth, int start){
    if(depth == m){
        for(int i = 0; i < m; i++){
            cout << res[i] << " ";
        }
        cout << "\n";
        return;
    }

    int before = -1;
    for(int i = start; i < arr.size(); i++){
            if(arr[i] == before) continue;
            before = arr[i];

            res.push_back(arr[i]);
            dfs(depth + 1, i);
            res.pop_back();
        
    }

}

int main() {
    cin >> n >> m;
    
    set<int> s;
    for(int i = 0; i < n; i++){
        int temp;
        cin >> temp;
        s.insert(temp);
    }

    arr.assign(s.begin(), s.end());

    dfs(0, 0);
    return 0;
}