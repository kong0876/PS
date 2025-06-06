#include <bits/stdc++.h>
using namespace std;

int n;
vector<vector<int>> conn;
vector<int> parent;
vector<bool> visited;

void dfs(int now){
    visited[now] = true;

    for(int next : conn[now]){
        if(!visited[next]){
            parent[next] = now;
            dfs(next);
        }
    }
}

int main() {
    cin >> n;

    parent.resize(n + 1);
    conn.resize(n + 1);
    visited.resize(n + 1, false);

    for(int i = 0; i < n - 1; i ++){
        int a, b;
        cin >> a >> b;
        conn[a].push_back(b);
        conn[b].push_back(a);
    }

    dfs(1); // 루트가 1임

    for(int i = 2; i <= n; i++){
        cout << parent[i] << "\n";
    }

    return 0;
}