# Algorithm-Java

> **Algorithms** + **Data Structures** = Programs. ——Niklaus Wirth

没日没夜地写程序。看到这几个字我两眼一黑，这仿佛就是我未来的生活。
为了摆脱这种焦虑的心理，我逐步计划，创建了这个profile，目的是每天都能写点代码并做记录。先从我最不擅长的算法开始，
我参考了 @zhihu @SimonS的一篇答案，整理了如下技能树，每完成一项就点亮一个技能点，必要时再写点心得。以此来完善
我的知识体系结构。 

## 初期（校赛及省赛水题难度）：

1. 基本算法：
    - 枚举（[poj1753](src/EarlyStage/BasicAlgs/Enum/poj1753.java)，[poj2965](src/EarlyStage/BasicAlgs/Enum/poj2965.java)）
    - 贪心（poj1328，poj2109，poj2586）
    - 递归和分治法
    - 递推
    - 构造法（poj3295）
    - 模拟法（poj1068，poj2632，poj1573，poj2993，poj2996）
2. 图算法：
    - 图的深度优先遍历和广度优先遍历
    - 最短路径（dijkstra，bellman-ford，floyd，heap+dijkstra）（poj1860，poj3259，poj1062，poj2253，poj1125，poj2240）
    - 最小生成树（prim，kruskal）（poj1789，poj2485，poj1258，poj3026）
    - 拓扑排序（poj1094）
    - 二分图的最大匹配（匈牙利算法）（poj3041，poj3020）
    -最大流的增广路算法（KM算法）（poj1459，poj3436）
3. 数据结构：
    - 串（[poj1035](src/EarlyStage/DataStructure/poj1035.java)，[poj3080](src/EarlyStage/DataStructure/poj3080.java)，[poj1936](src/EarlyStage/DataStructure/poj1936.java)）
    - 排序（快排，归并排/与逆序数有关，堆排）（[poj2388](src/EarlyStage/DataStructure/poj2388.java)，[poj2299](src/EarlyStage/DataStructure/poj2299.java)）
    - 简单并查集的应用
    - 哈希表和二分查找等高效查找法（数的Hash，串的Hash）（[poj3349](src/EarlyStage/DataStructure/poj3349.java)，[poj3274](src/EarlyStage/DataStructure/poj3274.java)，poj2151，poj1840，poj2002，poj2503）
    - 哈夫曼树（poj3253）
    - 堆
    - trie树（静态建树，动态建树）（poj2513）
4. 简单搜索：
    - 深度优先搜索（poj2488，poj3083，poj3009，poj1321，poj2251）
    - 广度优先搜索（poj3278，poj1426，poj3126，poj3087，poj3414）
    - 简单搜索技巧和减枝（poj2531，poj1416，poj2676，poj1129）
5. [动态规划](src/EarlyStage/DynamicProgramming/README.md)：
    - 背包问题（[poj1837](src/EarlyStage/DynamicProgramming/poj1837.java)，[poj1276](src/EarlyStage/DynamicProgramming/poj1276.java)）
    - 型如下表的简单DP（可参考lrj的书page149）：
      （poj3267，poj1836，poj1260，poj2533）
      （poj3176，poj1080，poj1159）
      （最优二分检索树问题）
6. 数学：
    - 组合数学
        - 加法原理和乘法原理
        - 排列组合
        - 递推关系
    （[poj3252](src/EarlyStage/Mathematics/poj3252.java)，[poj1850](src/EarlyStage/Mathematics/poj1850.java)，poj1019，poj1942）
    - 数论
        - 素数与整数问题
        - 进制位
        - 同余模运算
    （poj2635，poj3292，poj1845，poj2115）
    - 计算方法
        - 二分法求解单调函数相关知识（poj3273，poj3258，poj1905，poj3122）
7. 计算几何：
    - 几何公式
    - 叉积和点积的运用（如线段相交的判定，点到线段的距离）（poj2031，poj1039）
    - 多边形的简单算法（求面积）和相关判定（点在多边形内，多边形是否相交）（poj1408，poj1584）
    - 凸包（poj2187，poj1113）
    
## 中期（校赛压轴及省赛中等难度）：
1. 基本算法：
    - C++的标准模板库的应用（poj3096，poj3007）
    - 较为复杂的模拟题的训练（poj3393，poj1472，poj3371，poj1027，poj2706）
2. 图算法：
    - 差分约束系统的建立和求解（poj1201，poj2983）
    - 最小费用最大流（poj2516，poj2195）
    - 双连通分量（poj2942）
    - 强连通分支及其缩点（poj2186）
    - 图的割边和割点（poj3352）
    - 最小割模型、网络流制约（poj3308）
3. 数据结构：
    - 线段树（poj2528，poj2828，poj2777，poj2886，poj2750）
    - 静态二叉检索树（poj2482，poj2352）
    - 树状数组（poj1195，poj3321）
    - RMQ（poj3264，poj3368）
    - 并查集的高级应用（poj1703，poj2492）
    - KMP算法（poj1961，poj2406）
4. 搜索：
    - 最优化剪枝和可行性剪枝
    - 搜索的技巧和优化（poj3411，poj1724）
    - 记忆化搜索（poj3373，poj1691）
5. 动态规划：
    - 较为复杂的动态规划（如动态规划解特别的旅行商TSP问题等）
    （poj1191，poj1054，poj3280，poj2029，poj2948，poj1925，poj3034）
    - 记录状态的动态规划（poj3254，poj2411，poj1185）
    - 树型动态规划（poj2057，poj1947，poj2486，poj3140）
6. 数学：
    - 组合数学：
        - 容斥理论
        - 抽屉原理
        - 置换群与Polya定理（poj1286，poj2409，poj3270，poj1026）
        - 递推关系和母函数
    - 数学
        - 高斯消元法（poj2947，poj1487，poj2065，poj1166，poj1222）
        - 概率问题（poj3071，poj3440）
        - GCD、扩展的欧几里得（中国剩余定理）（poj3101）
    - 计算方法
        - 0/1分数规划（poj2976）
        - 三分法求解单峰（单谷）的极值
        - 矩阵法（poj3150，poj3422，poj3070）
        - 迭代逼近（poj3301）
    - 随机化算法（poj3318，poj2454）
    - 杂题（poj1870，poj3286，poj1095）
7. 计算几何学：
    - 坐标离散化
    - 扫描线算法（例如求矩形的面积和周长并常和线段树或堆一起使用）
    （poj1765，poj1177，poj1151，poj3277，poj2280，poj3004）
    - 多边形的内核（半平面交）（poj3130，poj3335）
    - 几何工具的综合应用（poj1819，poj1066，poj2043，poj3227，poj2165，poj3429）
    
## 高级（regional中等难度）：
1. 基本算法要求：
    - 代码快速写成，精简但不失风格
    - （poj2525，poj1684，poj1421，poj1048，poj2050，poj3306）
    - 保证正确率和高效性（poj3434）
2. 图算法：
    - 度限制最小生成树和第k最短路（poj1639）
    - 最短路，最小生成树，二分图，最大流问题的相关理论（主要是模型建立和求解）
    （poj3155，poj2112，poj1966，poj3281，poj1087，poj2289，poj3216，poj2446）
    - 最优比率生成树（poj2728）
    - 最小树形图（poj3164）
    - 次小生成树
    - 无向图、有向图的最小环
3. 数据结构：
    - trie图的建立和应用（poj2778）
    - LCA问题和RMQ问题（LCA最近公共祖先问题）有离线算法（并查集+dfs）和在线算法（RMQ+dfs）（poj2823）
    - 左偏树（可合并堆）
    - 后缀树（非常有用的数据结构，也是赛区考题的热点）（poj3415，poj3294）
4. 搜索：
    - 较麻烦的搜索题目训练（poj1069，poj3322，poj1475，poj1924，poj2049，poj3426）
    - 广搜的状态优化：利用M进制数存储状态、转化为串用hash表判重、按位压缩存储状态、双向广搜、A*算法
    （poj1768，poj1184，poj1872，poj1324，poj2046，poj1482）
    - 深搜的优化：尽量用位运算、一定要剪枝、函数参数尽可能少、层数不易过大、可以考虑双向搜索或者是轮换搜索、IDA*算法
    （poj3131，poj2870，poj2286）
5. 动态规划：
    - 需要用数据结构优化的动态规划（poj2754，poj3378，poj3017）
    - 四边形不等式理论
    - 较难的状态DP（poj3133）
6. 数学：
    - 组合数学
        - MoBius反演（poj2888，poj2154）
        - 偏序关系理论
    - 博弈论
        - 极大极小过程（poj3317，poj1085）
        - Nim问题
7. 计算几何学
    - 半平面求交（poj3384，poj2540）
    - 可是图的建立（poj2966）
    - 点集最小圆覆盖
    - 对踵点（poj2079）
8. 综合题
    - （poj3109，poj1478，poj1462，poj2729，poj2048，poj3336，poj3315，poj2148，poj1263）

--------------------
### 相关链接

- [程序员必须掌握哪些算法？ - SimonS的回答 - 知乎](https://www.zhihu.com/question/23148377/answer/36824071)

