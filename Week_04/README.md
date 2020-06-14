# 搜索-遍历
    每个节点都要访问一次
    每个节点仅仅要访问一次
    对节点访问的顺序不限
        深度优先
        广度优先

```java
public class DFS {
  private Set<TreeNode> visited = new HashSet<>();
  /**
   * 深度遍历采用栈处理，广度遍历采用队列处理
   * */
  public void dfs(TreeNode treeNode) {
    // 是否已经访问过，
    if (!visited.add(treeNode)) {
      return;
    }
    // process current
    // process children
    // 处理左子树
    dfs(treeNode.left);
    // 处理右子树
    dfs(treeNode.right);
  }
}
```


# 贪心算法：
    每一步都是最优解的状态下，从而希望达到全局最优解

# 贪心算法 vs 动态规划
    贪心算法直接做出选择 不能回退，动态规划保留之前的运算结果


    

# 贪心算法适用场景：
    问题能够分解成子问题，子问题的最优解能递推到最终问题的最优解。这种子问题最优解成为最优子结构。
例如：
    求途中的最小生成树
    求哈夫曼编码
    零钱问题（如果组成面值的基数都是成倍的关系，可用贪心算法解决问题；例如：[20,10,5,1]，反例：[10,5,2,1]）

# 二分查找
    1. 单调性
    2. 存在上下界
    3. 能够通过索引访问

代码模板：
```java
/**
 * 返回target在nums中的下标
*/
public int search(int[] nums, int target) {
    int index = -1;

    if (nums == null || nums.length == 0) {
      return index;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left)/2;
      // 查询到对应值，直接返回
      if (nums[mid] == target) {
        index = mid;
        break;
      }
      // 此处只用一个判断，办证left和right的变化，不至于死循环
      if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index;
  }
```

# 求旋转排序数组中无序只
```java
/**
 * 153. 寻找旋转排序数组中的最小值
*/
  public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 无序
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 有序
                right = mid;
            }
        }
        return left;
}
```
第153，查询旋转排序数据最小值，最小值下标就为数组中无序位置
