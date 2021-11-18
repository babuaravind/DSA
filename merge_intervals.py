class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda i : i[0])
        
        output_array = [intervals[0]]
        
        for i, j in intervals[1:]:
            last_end = output_array[-1][1]
            
            if i <= last_end:
                output_array[-1][1] = max(last_end, j)
            else:
                output_array.append([i, j])
        return output_array
            
            
        