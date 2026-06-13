func numIslands(grid [][]byte) int {
    m := len(grid)
    if m == 0 {
        return 0
    }

    n := len(grid[0])

    vis := make([][]bool, m)
    for i := range vis {
        vis[i] = make([]bool, n)
    }

    dirs := [][]int{
        {-1, 0},
        {0, -1},
        {1, 0},
        {0, 1},
    }

    cnt := 0

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if !vis[i][j] && grid[i][j] == '1' {
                cnt++
                dfs(grid, vis, i, j, dirs)
            }
        }
    }

    return cnt
}

func dfs(grid [][]byte, vis [][]bool, i, j int, dirs [][]int) {
    m := len(grid)
    n := len(grid[0])

    vis[i][j] = true

    for _, dir := range dirs {
        nx := i + dir[0]
        ny := j + dir[1]

        if nx >= 0 && nx < m &&
            ny >= 0 && ny < n &&
            !vis[nx][ny] &&
            grid[nx][ny] == '1' {

            dfs(grid, vis, nx, ny, dirs)
        }
    }
}