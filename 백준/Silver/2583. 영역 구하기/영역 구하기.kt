import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val M = scanner.nextInt()
    val N = scanner.nextInt()
    val K = scanner.nextInt()
    val board = Array(M) { IntArray(N) }
    val visited = Array(M) { BooleanArray(N) }
    val dx = listOf(0, 0, -1, 1)
    val dy = listOf(-1, 1, 0, 0)

    repeat(K) {
        val x1 = scanner.nextInt()
        val y1 = scanner.nextInt()
        val x2 = scanner.nextInt()
        val y2 = scanner.nextInt()
        for (y in y1 until y2) {
            for (x in x1 until x2) {
                board[y][x] = 1
            }
        }
    }

    val result = mutableListOf<Int>()

    fun dfs(y: Int, x: Int): Int {
        visited[y][x] = true
        var size = 1
        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny in 0 until M && nx in 0 until N) {
                if (board[ny][nx] == 0 && !visited[ny][nx]) {
                    size += dfs(ny, nx)
                }
            }
        }
        return size
    }

    for (y in 0 until M) {
        for (x in 0 until N) {
            if (board[y][x] == 0 && !visited[y][x]) {
                result.add(dfs(y, x))
            }
        }
    }

    result.sort()
    println(result.size)
    println(result.joinToString(" "))
}