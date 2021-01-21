#include <iostream>
using namespace std;
void search(int x, int y);
int sum;
int n, m, t, x1, y1, x2, y2;  //分别为行列和障碍数，起点终点坐标
int map[50][50] = {0};        // map用于标记障碍
bool a[50][50] = {0};
bool isValid(int x,int y) {
    return x > 0 && x <= n && y > 0 && y <= m && map[x][y] == 0 && a[x][y] == 0;
}
int main() {
  cin >> n >> m >> t >> x1 >> y1 >> x2 >> y2;
  int i, k, l;
  for (i = 0; i < t; i++) {
    cin >> k >> l;
    map[k][l] = 1;
  }
  a[x1][y1] = 1;
  search(x1, y1);

  cout << sum;

  return 0;
}
void search(int x, int y) {
  if (x == x2 && y == y2) {
    sum++;
    return;
  } 
  else {
    if (isValid(x + 1,y)) {

      a[x + 1][y] = 1;
      search(x + 1, y);
      a[x + 1][y] = 0;
    }
    if (isValid(x - 1,y)) {
      a[x - 1][y] = 1;
      search(x - 1, y);
      a[x - 1][y] = 0;
    }
    if (isValid(x,y + 1)) {
      a[x][y + 1] = 1;  
      search(x, y + 1);
      a[x][y + 1] = 0;
    }
    if (isValid(x,y - 1)) {
      a[x][y - 1] = 1;
      search(x, y - 1);
      a[x][y - 1] = 0;
    }
  }
}
