class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var result = Int.MAX_VALUE

        val bits = IntArray(32)
        var sum = 0

        var j = 0

        for (i in nums.indices) {
            sum = sum or nums[i]
            for (f in bits.indices) {
                bits[f] += if (sum and (1 shl f) != 0) 1 else 0
            }
            while (sum >= k && j <= i) {
                for (f in bits.indices) {
                    bits[f] -= if (nums[j] and (1 shl f) != 0) 1 else 0
                    if (bits[f] == 0)
                        sum = sum and (1 shl f).inv()
                }
                result = minOf(result, i - j + 1)
                j++
            }
        }

        return if (result == Int.MAX_VALUE)
            -1
        else
            result
    }
}
