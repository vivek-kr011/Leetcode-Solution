class Solution {
public:
   int subarraySum(vector<int>& nums, int k) {
       int n=nums.size();


       unordered_map<int,int>m;
       m[0]=1;
       int pre_sum=0;
       int ans=0;
       for(int i=0;i<n;i++)
       {
           pre_sum+=nums[i];
           if(m.find(pre_sum-k)!=m.end())
           ans+=m[pre_sum-k];


           m[pre_sum]++;
       }
       return ans;
   }
};
